package turismo;

public class Atraccion extends Producto {
	private String nombre;
	private int costo;
	private double tiempo;
	private int cupoMaximo;
	private int cuposOcupados;

	public Atraccion(String nombre, TipoDeAtraccion tipo, int costo, double tiempo, int cupo) {
		super(tipo);
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupoMaximo = cupo;
	}

	public TipoDeAtraccion getTipo() {
		return tipoDeAtraccion;
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
		return "A/ " + nombre + " [Tipo de atracción = " + tipoDeAtraccion + ", Costo = " + costo + " monedas, Tiempo = " + tiempo
				+ " horas, Cupo máximo = " + cupoMaximo + ", Cupos ocupados = " + cuposOcupados + "]";
	}

}
