package turismo;

public abstract class Producto {
	protected double costo;
	protected double tiempo;
	protected TipoDeAtraccion tipoDeAtraccion;
	public Producto(TipoDeAtraccion tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
	
	public boolean esPromo() {
		return false;
	}

	public double getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

}
