package turismo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LectorPromocion {

	public List<Promocion> leerPromocion(String file, List<Atraccion> atracciones) throws PromocionException, AtraccionException {
		List<Promocion> promociones = new LinkedList<Promocion>();
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while ((linea != null)) {
				try {
					promociones.add(this.crearPromocion(linea, atracciones));
				} catch (PromocionException e) {
					System.out.println(e.getMessage());
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

	private Promocion crearPromocion(String linea, List<Atraccion> atracciones) throws PromocionException, AtraccionException {
		String lin[] = linea.split(",");
		Promocion promo = null;
		List<Atraccion> atraccionesPromo = new LinkedList<Atraccion>();

		if (lin[0].toLowerCase().equals("axb")) {
			for (int i = 3; i < lin.length; i++) {
				agregarAtraccionAPromo(lin[i], atraccionesPromo, atracciones);
			}
			promo = new PromocionAxB(TipoDePromocion.valueOf(lin[0]), TipoDeAtraccion.valueOf(lin[1]),
					atraccionesPromo);
		}
		if (lin[0].toLowerCase().equals("absoluta")) {
			for (int i = 3; i < lin.length; i++) {
				agregarAtraccionAPromo(lin[i], atraccionesPromo, atracciones);
			}
			promo = new PromocionAbsoluta(TipoDePromocion.valueOf(lin[0]), TipoDeAtraccion.valueOf(lin[1]),
					Integer.parseInt(lin[2]), atraccionesPromo);
		}
		if (lin[0].toLowerCase().equals("porcentual")) {
			for (int i = 3; i < lin.length; i++) {
				agregarAtraccionAPromo(lin[i], atraccionesPromo, atracciones);
			}
			promo = new PromocionPorcentual(TipoDePromocion.valueOf(lin[0]), TipoDeAtraccion.valueOf(lin[1]),
					Integer.parseInt(lin[2]), atraccionesPromo);
		}
		return promo;
	}

	private void agregarAtraccionAPromo(String nombre, List<Atraccion> atraccionesPromo, List<Atraccion> atracciones)  {
		for (Atraccion a : atracciones) {
			if (nombre.equals(a.getNombre())) {
				atraccionesPromo.add(a);
			}
		}
	}

}