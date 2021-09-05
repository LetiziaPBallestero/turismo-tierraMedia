package turismo;

public abstract class Producto {
	protected double costo;
	protected double tiempo;
	protected int cuposOcupados;
	protected TipoDeAtraccion tipoDeAtraccion;
	public Producto(TipoDeAtraccion tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
	
	public boolean esPromo() {
		return false;
	}
	
	public abstract boolean hayCupo();
	

	public double getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public abstract void ocuparCupo();

}
