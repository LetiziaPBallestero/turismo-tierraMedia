package turismo;

import java.util.LinkedList;
import java.util.List;

public class TierraMedia {
	private static List<Usuario> usuarios;
	private static List<Producto> productos = new LinkedList<Producto>();
	
	public static void main(String[] args) throws UsuarioException {
		LectorUsuario lectorUsuario = new LectorUsuario();
		TierraMedia.usuarios = lectorUsuario.leerUsuario("src/archivosDeEntrada/usuarios.csv");
		for(Usuario u : usuarios) {
			System.out.println(u);			
		}
		
	}

}
