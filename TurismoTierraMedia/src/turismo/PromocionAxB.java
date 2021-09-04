package turismo;
import java.util.ArrayList;

public class PromocionAxB extends Promocion {
	public PromocionAXB (TipoDeAtraccion tipo, TipoDePromocion promocion, int cantidad, double costo, List <Atraccion> atracciones) {
		super (tipo, promocion, cantidad, atracciones); 
		if (this.tipoPromocion == TipoDePromocion.AXB ) {
			this.costo = this.aplicarPromocion();
		}
	}

	
	@Override 
	protected double aplicarPromocion () {
		double costoTotal = 0; 
		double tiempoTotal = 0; 
		List <String> nuevasAtracciones = new ArrayList <String> (); 
		
		for (Atraccion atraccion : this.atracciones) {
			nuevasAtracciones.add (atracciones.obtenerNombre());
			if (atraccion.tipo == this.tipo && !nuevasAtracciones.contains(atraccion.obtenerNombre())) {
				for (int i = 1 ; i < this.cantidadDeAtracciones; i++) {
					costoTotal += atraccion.costo;
				}
				tiempoTotal += atraccion.tiempoDeDuracion;
			}
		}
		this.tiempoDeDuracion = tiempoTotal; 
		return costoTotal; 
	}
	
}
