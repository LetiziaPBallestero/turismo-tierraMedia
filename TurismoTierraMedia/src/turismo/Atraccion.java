package turismo;

public class Atraccion extends Producto {
	private TipoDeAtraccion tipo;
	private String nombre;
	private int costo;
	private double tiempo;
	private int cupo;
	public Atraccion(TipoDeAtraccion tipo, String nombre, int costo, double tiempo, int cupo) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
	}

}
