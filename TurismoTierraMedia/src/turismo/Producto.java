package turismo;

public abstract class Producto {
	protected TipoDeAtraccion tipoDeAtraccion;
	public Producto(TipoDeAtraccion tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

}
