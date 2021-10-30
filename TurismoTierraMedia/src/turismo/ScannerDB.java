package turismo;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
	private ItinerarioDAO itinerarioDAO = new ItinerarioDAO();

	public ScannerDB() {
		super();
	}

	public void escanearUsuariosYProductos()
			throws UsuarioException, PromocionException, AtraccionException, SQLException, ParseException {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		List<Promocion> promociones = new LinkedList<Promocion>();

		ScannerDB.usuarios = usuarioDAO.getAll();

		atracciones = atraccionDAO.getAll();
		productos.addAll(atracciones);

		promociones = promocionDAO.getAll(atracciones);
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
					itinerarioDAO.update(usuario, p);
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
		}
	}
}
