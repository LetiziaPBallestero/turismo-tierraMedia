package turismo;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	private int descuento;

	public PromocionPorcentual(TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, int descuento, List<Atraccion> atracciones) {
		super(tipoPromocion, tipoDeAtraccion, atracciones);
		this.descuento = descuento;
	}

}
