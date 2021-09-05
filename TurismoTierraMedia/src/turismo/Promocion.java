package turismo;

import java.util.List;

public abstract class Promocion extends Producto {
	protected TipoDePromocion tipoPromocion;
	protected List <Atraccion> atracciones; 
	protected double costo; 
	protected double tiempo; 
	
	public Promocion (TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, List <Atraccion> atracciones) {
		super(tipoDeAtraccion);
		this.tipoPromocion = tipoPromocion;
		this.atracciones = atracciones;
	}
	
	protected void aplicarPromocion () {
	}
	
	protected double getTiempo() {
		return this.tiempo;
	}
	
	protected double getCosto() {
		return this.costo;
	}
	
	@Override
	public boolean esPromo() {
		return true;
	}

	@Override
	public String toString() {
		return "P " + tipoPromocion + "/ [Costo total = " + this.getCosto() + ", Tiempo total = " + this.getTiempo() + " horas, Atracciones = " + atracciones + "]";
	}
	
}
