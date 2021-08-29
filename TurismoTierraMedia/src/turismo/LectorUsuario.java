package turismo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorUsuario {
	
	public void leerUsuario() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			fr = new FileReader("src/usuarios.txt");
			br = new BufferedReader(fr);
			// Lectura del fichero
			String linea = br.readLine();
			while ((linea != null)) {
				this.crearEImprimirUsuario(linea);
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
	}
	
	private Usuario crearEImprimirUsuario(String linea) {
		String lin[] = linea.split(",");
		System.out.println(new Usuario(TipoDeAtraccion.valueOf(lin[0]), lin[1],
				Integer.parseInt(lin[2]), Double.parseDouble(lin[3])).toString());
		return new Usuario(TipoDeAtraccion.valueOf(lin[0]), lin[1],
				Integer.parseInt(lin[2]), Double.parseDouble(lin[3]));
	}
	
	public static void main(String[] args) {
		LectorUsuario lectorUsuario = new LectorUsuario();
		lectorUsuario.leerUsuario();
	}
}
