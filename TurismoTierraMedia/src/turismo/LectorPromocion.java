package turismo;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class LectorPromocion {
	
	public List <Promocion> leerPromocion (String file) throws PromocionException {
		List <Promocion> promociones = new LinkedList <Promocion>();
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader (file); 
			br = new BufferedReader (fr); 
			String linea = br.readLine();
			while ((linea != null)) {
				try {
					promociones.add(this.crearPromocion(linea));
				}
				catch (PromocionException e) {
					System.out.println (e.getMessage());
				}
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return promociones;
	}
	
	private Promocion crearPromocion(String linea) throws PromocionException {
			String lin[] = linea.split(",");
			if(lin.length!=5) {
				throw new AtraccionException("Cantidad de parámetros errónea");
			}

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
