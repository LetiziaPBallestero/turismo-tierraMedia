package turismo;

import java.util.List;

public abstract class Promocion extends Producto {
	protected TipoDePromocion tipoPromocion;
	protected List <Atraccion> atracciones; 
	protected double costo; 
	
	public Promocion (TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, List <Atraccion> atracciones) {
		super(tipoDeAtraccion);
		this.tipoPromocion = tipoPromocion;
		this.atracciones = atracciones;
	}
	
	protected double aplicarPromocion () {
		return this.costo;
	}

	@Override
	public String toString() {
		return "Promocion [Tipo de promoción = " + tipoPromocion + ", Atracciones = " + atracciones + ", Costo = " + costo + "]";
	}
	
	
}

// falta el toString