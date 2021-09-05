package turismo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PromocionAxB extends Promocion {

	public PromocionAxB(TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, List<Atraccion> atracciones) {
		super(tipoPromocion, tipoDeAtraccion, atracciones);
		this.aplicarPromocion();
	}

	@Override 
	protected void aplicarPromocion () {
		List <Atraccion> atraccionesPagas = new LinkedList <Atraccion> (); 
		for (int i = 0; i < (this.atracciones.size()-1); i++) {
			atraccionesPagas.add(this.atracciones.get(i));
		}
		for (Atraccion atraccion : atraccionesPagas) {
			this.costo += atraccion.getCosto();
		}
	}
	
	@Override
	public double getTiempo() {
		for (Atraccion atraccion : this.atracciones) {
			this.tiempo += atraccion.getTiempo();
		}
		return this.tiempo;
	}
}
