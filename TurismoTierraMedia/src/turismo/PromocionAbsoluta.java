package turismo;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private String tipo;
	private int costo;
	private List<Atraccion> atracciones;

	public PromocionAbsoluta(TipoDeAtraccion tipoAtraccion, int costo, double tiempo) {
		super(costo, tiempo, tipoAtraccion);
	}

}
