package turismo;

public abstract class Promocion extends Producto {

	public Promocion(TipoDeAtraccion tipoAtraccion,int costo, double tiempo) {
		super(costo, tiempo, tipoAtraccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esPromo() {
		return true;
	}

}
