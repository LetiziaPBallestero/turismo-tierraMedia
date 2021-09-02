package turismo;

public class Atraccion extends Producto {
	private TipoDeAtraccion tipo;
	private String nombre;
	private int costo;
	private double tiempo;
	private int cupoMaximo;
	private int cuposOcupados;

	public Atraccion(String nombre, TipoDeAtraccion tipo, int costo, double tiempo, int cupo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupoMaximo = cupo;
	}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public boolean hayCupo() {
		return this.cuposOcupados < this.cupoMaximo;
	}

	@Override
	public String toString() {
		return "A/ " + nombre + " [Tipo de atracción = " + tipo + ", Costo = " + costo + " monedas, Tiempo = " + tiempo
				+ " horas, Cupo máximo = " + cupoMaximo + ", Cupos ocupados = " + cuposOcupados + "]";
	}

}
