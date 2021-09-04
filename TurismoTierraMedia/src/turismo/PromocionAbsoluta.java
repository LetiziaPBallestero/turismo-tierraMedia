package turismo;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, int costo, List<Atraccion> atracciones) {
		super(tipoPromocion, tipoDeAtraccion, atracciones);
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "PromocionAbsoluta [tipoPromocion=" + tipoPromocion + ", atracciones=" + atracciones + ", costo=" + costo
				+ ", tipoDeAtraccion=" + tipoDeAtraccion + "]";
	}
	

}
