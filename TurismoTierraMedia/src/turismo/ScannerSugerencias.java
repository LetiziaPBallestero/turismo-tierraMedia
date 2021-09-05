package turismo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ScannerSugerencias {
	private static List<Usuario> usuarios;
	private static List<Producto> productos = new LinkedList<Producto>();
	
	public void escanearUsuariosYProductos() throws UsuarioException, PromocionException, AtraccionException {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		List<Promocion> promociones = new LinkedList<Promocion>();

		LectorUsuario lectorUsuario = new LectorUsuario();
		ScannerSugerencias.usuarios = lectorUsuario.leerUsuario("src/archivosDeEntrada/usuarios.csv");
		
		LectorAtraccion lectorAtraccion = new LectorAtraccion();
		atracciones = lectorAtraccion.leerAtraccion("src/archivosDeEntrada/atracciones.csv");
		productos.addAll(atracciones);

		LectorPromocion lectorPromocion = new LectorPromocion();
		promociones = lectorPromocion.leerPromocion("src/archivosDeEntrada/promociones.csv", atracciones);
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
		Iterator<Producto> iterador = this.productos.iterator();
		while (iterador.hasNext()){
		     Producto p = iterador.next();
		     System.out.println(p);
		     if (this.ofrecer()){
		    	 usuario.agregarAItinerario(p);
		     }
		 }
		
		/*for (Producto p : ScannerSugerencias.productos) {
			System.out.println(p);
			if(this.ofrecer()) {
				usuario.agregarAItinerario(p);
			}
			ScannerSugerencias.productos.remove(p);
		}*/
	}
	
	public void mostrarATodos() {
		List<Usuario> aux = new LinkedList<Usuario>();
		Iterator<Usuario> iterador = this.usuarios.iterator();
		while (iterador.hasNext()){
		     Usuario u = iterador.next();
		     System.out.println(u);
		     this.mostrar(u);
		     aux.add(u);
	         iterador.remove();
		 }
		for (Usuario u : aux) {
			System.out.println("Itinerario de " + u.getNombre() + ": "+ u.getItinerario());
		}
		
		/*for (Usuario u : ScannerSugerencias.usuarios) {
			System.out.println(u);
			this.mostrar(u);
			ScannerSugerencias.usuarios.remove(u);
		}*/
	}
	
}
