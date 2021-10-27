package turismo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerDB {
	private static List<Usuario> usuarios;
	private static List<Producto> productos = new LinkedList<Producto>();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private AtraccionDAO atraccionDAO = new AtraccionDAO();
	private PromocionDAO promocionDAO = new PromocionDAO();
	private String archivoUsuarios;
	private String archivoAtracciones;
	private String archivoPromociones;

	public ScannerDB(String archivoUsuarios, String archivoAtracciones, String archivoPromociones) {
		super();
		this.archivoUsuarios = archivoUsuarios;
		this.archivoAtracciones = archivoAtracciones;
		this.archivoPromociones = archivoPromociones;
	}

	public void escanearUsuariosYProductos() throws UsuarioException, PromocionException, AtraccionException {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		List<Promocion> promociones = new LinkedList<Promocion>();

		LectorUsuario lectorUsuario = new LectorUsuario();
		ScannerDB.usuarios = lectorUsuario.leerUsuario(this.archivoUsuarios);

		LectorAtraccion lectorAtraccion = new LectorAtraccion();
		atracciones = lectorAtraccion.leerAtraccion(this.archivoAtracciones);
		productos.addAll(atracciones);

		LectorPromocion lectorPromocion = new LectorPromocion();
		promociones = lectorPromocion.leerPromocion(this.archivoPromociones, atracciones);
		for(Promocion p : promociones) {
			p.aplicarPromocion();
		}
		productos.addAll(promociones);

	}

	public boolean ofrecer() {

		String opcion = "";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Desea añadir esta sugerencia a su itinerario? Si/No");
		opcion = sc.next();
		while (!opcion.toLowerCase().equals("si") && !opcion.toLowerCase().equals("no")) {
			System.out.println("¿Desea añadir esta sugerencia a su itinerario? Si/No");
			opcion = sc.next();
		}
		return opcion.toLowerCase().equals("si");
	}

	public void mostrar(Usuario usuario) throws SQLException {
		ScannerDB.productos.sort(new ProductoComparator(usuario.getTipoDeAtraccionPreferido()));
		Iterator<Producto> iterador = ScannerDB.productos.iterator();
		while (iterador.hasNext()) {
			Producto p = iterador.next();
			if (usuario.getPresupuesto() >= p.getCosto() && usuario.getTiempoDisponible() >= p.getTiempo()
					&& p.hayCupo() && !usuario.getItinerario().contains((CharSequence) p.getNombre())) {
				System.out.println(p);
				if (this.ofrecer()) {
					usuario.agregarAItinerario(p);
					usuario.setPresupuesto(usuario.getPresupuesto() - p.getCosto());
					usuario.setTiempoDisponible(usuario.getTiempoDisponible() - p.getTiempo());
					p.ocuparCupo();
					usuarioDAO.update(usuario);
					if (p.esPromo())
						promocionDAO.update(p);
					else {
						atraccionDAO.update(p);
					}
				}
			} else {
				try {
					p = iterador.next();
				} catch (NoSuchElementException e) {
					System.out.println("No hay más atracciones para mostrar");
				}
			}
		}
	}

	public void mostrarATodos() throws IOException, SQLException {
		List<Usuario> aux = new LinkedList<Usuario>();
		Iterator<Usuario> iterador = ScannerDB.usuarios.iterator();
		while (iterador.hasNext()) {
			Usuario u = iterador.next();
			System.out.println(u);
			this.mostrar(u);
			aux.add(u);
			iterador.remove();
		}
		for (Usuario u : aux) {
			System.out.println("Itinerario de " + u.getNombre() + ": " + u.getItinerario());
			imprimirItinerarios(u, "src/archivosDeSalida/" + u.getNombre() + ".txt");
		}
	}

	public void imprimirItinerarios(Usuario usuario, String file) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(file));
		salida.println("Itinerario de " + usuario.getNombre() + ": " + usuario.getItinerario());
		salida.close();
	}

}
