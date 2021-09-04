package turismo;
import java.util.ArrayList;
import java.util.List;

public class PromocionAxB extends Promocion {
	

	public PromocionAxB(TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, List<Atraccion> atracciones) {
		super(tipoPromocion, tipoDeAtraccion, atracciones);
		// TODO Auto-generated constructor stub
	}

/*
	public PromocionAXB (TipoDeAtraccion tipo, TipoDePromocion promocion, int cantidad, double costo, List <Atraccion> atracciones) {
		super (tipo, promocion, cantidad, atracciones); 
		if (this.tipoPromocion == TipoDePromocion.AXB ) {
			this.costo = this.aplicarPromocion();
		}
	}
	*/

	/*
	@Override 
	protected double aplicarPromocion () {
		double costoTotal = 0; 
		double tiempoTotal = 0; 
		List <String> nuevasAtracciones = new ArrayList <String> (); 
		
		for (Atraccion atraccion : this.atracciones) {
			nuevasAtracciones.add (atracciones.getNombre());
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
