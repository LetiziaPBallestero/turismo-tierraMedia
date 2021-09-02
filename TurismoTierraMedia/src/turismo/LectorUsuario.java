package turismo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

public class LectorUsuario {
	
	public List<Usuario> leerUsuario(String file) throws UsuarioException {
		List <Usuario> usuarios = new ArrayList<Usuario>();
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			// Lectura del fichero
			String linea = br.readLine();
			while ((linea != null)) {
				try {
					usuarios.add(this.crearUsuario(linea));
				}
				catch (UsuarioException e) {
					System.out.println(e.getMessage());
				}
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return usuarios;
	}
	
	private Usuario crearUsuario(String linea) throws UsuarioException {
		String lin[] = linea.split(",");
		if(lin.length!=4) {
			throw new UsuarioException("Cantidad de parámetros errónea");
		}
		return new Usuario(TipoDeAtraccion.valueOf(lin[0]), lin[1],
				Integer.parseInt(lin[2]), Double.parseDouble(lin[3]));
	}

}
