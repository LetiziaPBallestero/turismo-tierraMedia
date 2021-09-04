package turismo;

public abstract class Promocion extends Producto {

	public Promocion(int costo, double tiempo, TipoDeAtraccion tipoAtraccion) {
		super(costo, tiempo, tipoAtraccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esPromo() {
		return true;
	}

}
