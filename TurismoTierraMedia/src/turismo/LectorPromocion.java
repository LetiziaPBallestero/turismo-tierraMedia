package turismo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorPromocion {
	
	public void leerPromocion() {
		FileReader fr = null; 
		BufferedReader br = null; 
		
		try {
			fr = new FileReader ("promociones.txt"); 
			br = new BufferedReader (fr); 
			
			String linea = br.readLine (); 
			while (( linea != null)) {
				this.crearEImprimirPromocion (linea);
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private Promocion crearEImprimirPromocion (string linea) {
	// antes de crear este método tengo que consultar cómo va a ser el archivo de promocion 
		
	private Promocion crearPromocion(String linea) {
			String lin[] = linea.split(",");
			/*if(lin.length!=5) {
				throw new AtraccionException("Cantidad de parámetros errónea");
			}
			*/
			if (lin[0].toLowerCase() == "axb") {
				return new PromocionAxB(TipoDeAtraccion.valueOf(lin[1]), );
			}
			if (lin[0].toLowerCase() == "absoluta") {
				return new PromocionAbsoluta();
			}
			if (lin[0].toLowerCase() == "porcentual") {
				return new PromocionPorcentual(Strings convertidos a datos);
			}
			return //hace error
		}

	
	
}
