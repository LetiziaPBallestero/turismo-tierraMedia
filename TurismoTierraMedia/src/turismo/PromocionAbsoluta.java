package turismo;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, double costo, List<Atraccion> atracciones) {
		super(tipoPromocion, tipoDeAtraccion, atracciones);
		this.costo = costo;
	}

}
