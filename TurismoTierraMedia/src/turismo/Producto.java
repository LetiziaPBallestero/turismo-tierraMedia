package turismo;

public abstract class Producto {
	protected int costo;
	protected double tiempo;
	protected TipoDeAtraccion tipoAtraccion;

	public Producto(int costo, double tiempo, TipoDeAtraccion tipoAtraccion) {

		this.costo = costo;
		this.tiempo = tiempo;
		this.tipoAtraccion = tipoAtraccion;
	}

	public boolean esPromo() {
		return false;
	}
}
