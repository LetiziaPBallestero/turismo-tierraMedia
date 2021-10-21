package turismo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerSugerencias {
	private static List<Usuario> usuarios;
	private static List<Producto> productos = new LinkedList<Producto>();
	private String archivoUsuarios;
	private String archivoAtracciones;
	private String archivoPromociones;

	public ScannerSugerencias(String archivoUsuarios, String archivoAtracciones, String archivoPromociones) {
		super();
		this.archivoUsuarios = archivoUsuarios;
		this.archivoAtracciones = archivoAtracciones;
		this.archivoPromociones = archivoPromociones;
	}

	public void escanearUsuariosYProductos() throws UsuarioException, PromocionException, AtraccionException {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		List<Promocion> promociones = new LinkedList<Promocion>();

		LectorUsuario lectorUsuario = new LectorUsuario();
		ScannerSugerencias.usuarios = lectorUsuario.leerUsuario(this.archivoUsuarios);

		LectorAtraccion lectorAtraccion = new LectorAtraccion();
		atracciones = lectorAtraccion.leerAtraccion(this.archivoAtracciones);
		productos.addAll(atracciones);

		LectorPromocion lectorPromocion = new LectorPromocion();
		promociones = lectorPromocion.leerPromocion(this.archivoPromociones, atracciones);
		productos.addAll(promociones);

	}

	public boolean ofrecer() {

		String opcion = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Desea añadir esta sugerencia a su itinerario? Si/No");
		opcion = sc.next();
		while (!opcion.toLowerCase().equals("si") && !opcion.toLowerCase().equals("no")) {
			System.out.println("¿Desea añadir esta sugerencia a su itinerario? Si/No");
			opcion = sc.next();
		}
		return opcion.toLowerCase().equals("si");
	}

	public void mostrar(Usuario usuario) {
		ScannerSugerencias.productos.sort(new ProductoComparator(usuario.getTipoDeAtraccionPreferido()));
		Iterator<Producto> iterador = ScannerSugerencias.productos.iterator();
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
				}
			} else {
				try {
					p = iterador.next();
				} catch (NoSuchElementException e) {
					System.out.println("No hay mï¿½s atracciones para mostrar");
				}
			}
		}
	}

	public void mostrarATodos() throws IOException {
		List<Usuario> aux = new LinkedList<Usuario>();
		Iterator<Usuario> iterador = ScannerSugerencias.usuarios.iterator();
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
