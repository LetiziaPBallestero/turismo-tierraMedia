package turismo;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class LectorPromocion {
	
	
	public List <Promocion> leerPromocion (String file) throws PromocionException, AtraccionException {
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
	
	private Promocion crearPromocion(String linea) throws PromocionException, AtraccionException {
			String lin[] = linea.split(",");
			Promocion promo = null;
			
			if (lin[0].toLowerCase() == "axb") {
				List<Atraccion> atraccionesPromo = null;
				agregarAtraccionesAPromo(lin[3], atraccionesPromo);
				agregarAtraccionesAPromo(lin[4], atraccionesPromo);
				if (lin[5] != null){
					agregarAtraccionesAPromo(lin[5], atraccionesPromo);
				}
				promo = new PromocionAxB(TipoDePromocion.valueOf(lin[0]), TipoDeAtraccion.valueOf(lin[1]), atraccionesPromo);
			}
			if (lin[0].toLowerCase() == "absoluta") {
				List<Atraccion> atraccionesPromo = null;
				agregarAtraccionesAPromo(lin[3], atraccionesPromo);
				agregarAtraccionesAPromo(lin[4], atraccionesPromo);
				if (lin[5] != null) {
					agregarAtraccionesAPromo(lin[5], atraccionesPromo);
				}
				promo = new PromocionAbsoluta(TipoDePromocion.valueOf(lin[0]), TipoDeAtraccion.valueOf(lin[1]), Integer.parseInt(lin[2]), atraccionesPromo);
			}
			if (lin[0].toLowerCase() == "porcentual") {
				List<Atraccion> atraccionesPromo = null;
				agregarAtraccionesAPromo(lin[3], atraccionesPromo);
				agregarAtraccionesAPromo(lin[4], atraccionesPromo);
				if (lin[5] != null) {
					agregarAtraccionesAPromo(lin[5], atraccionesPromo);
				}
				promo = new PromocionPorcentual(TipoDePromocion.valueOf(lin[0]), TipoDeAtraccion.valueOf(lin[1]), Integer.parseInt(lin[2]), atraccionesPromo);
			}
			return promo;
		}

	private void agregarAtraccionesAPromo(String nombre, List<Atraccion> atraccionesPromo) throws AtraccionException {
		List<Atraccion> atracciones;
        LectorAtraccion lectorAtraccion = new LectorAtraccion();
        atracciones = lectorAtraccion.leerAtraccion("src/archivosDeEntrada/atracciones.csv");
        for(Atraccion a : atracciones) {
        if(nombre == a.getNombre()) {
            atraccionesPromo.add(a);
        }
    }
}
	
}
