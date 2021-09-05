package turismo;
import java.util.ArrayList;
import java.util.List;

public class PromocionAxB extends Promocion {
	

	public PromocionAxB(TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, List<Atraccion> atracciones) {
		super(tipoPromocion, tipoDeAtraccion, atracciones);
		// TODO Auto-generated constructor stub
	}
/*	
	@Override 
	protected double aplicarPromocion () {
		double costoTotal; 
		double tiempoTotal; 
		List <String> atraccionesPagas = new ArrayList <String> (); 
		
		for (Atraccion atraccion : this.atracciones) {
			atraccionesPagas.add(atracciones);
			if (atraccion.tipo == this.tipo && !nuevasAtracciones.contains(atraccion.getNombre())) {
				for (int i = 1 ; i < this.cantidadDeAtracciones; i++) {
					costoTotal += atraccion.costo;
				}
				tiempoTotal += atraccion.tiempoDeDuracion;
			}
		}
		this.tiempoDeDuracion = tiempoTotal; 
		return costoTotal; 
	}
	*/
	
}
