package turismo;

import java.util.LinkedList;
import java.util.List;

public class TierraMedia {
	private static List<Usuario> usuarios;
	private static List<Producto> productos = new LinkedList<Producto>();
	
	public static void main(String[] args) throws UsuarioException, AtraccionException {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		List<Promocion> promociones = new LinkedList<Promocion>();
		
		LectorUsuario lectorUsuario = new LectorUsuario();
		TierraMedia.usuarios = lectorUsuario.leerUsuario("src/archivosDeEntrada/usuarios.csv");
		for(Usuario u : usuarios) {
			System.out.println(u);			
		}
		LectorAtraccion lectorAtraccion = new LectorAtraccion();
		atracciones = lectorAtraccion.leerAtraccion("src/archivosDeEntrada/atracciones.csv");
		for(Atraccion a : atracciones) {
			System.out.println(a);
			productos.add(a);
		}
	}

}
