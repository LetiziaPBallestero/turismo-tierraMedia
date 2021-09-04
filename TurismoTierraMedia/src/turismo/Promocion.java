package turismo;

public abstract class Promocion extends Producto {
	protected TipoDePromocion tipoPromocion;
	protected List <Atraccion> atracciones; 
	protected int cantidadDeAtracciones; 
	protected List <Promocion> promociones; 
	protected double costo; 
	
	public Promocion (TipoDeAtraccion tipo, TipoDePromocion promociones, int cantidad, List <Atraccion> atracciones) {
		super(tipo);
		this.tipoPromocion = promociones;
		this.cantidadDeAtracciones = cantidad;
		this.atracciones = atracciones;
	}
	
	protected double aplicarPromocion () {
		return this.costo;
	}
}

// falta el toString