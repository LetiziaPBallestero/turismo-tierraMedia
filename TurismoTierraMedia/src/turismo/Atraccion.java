package turismo;

public class Atraccion extends Producto {
	private TipoDeAtraccion tipo;
	private String nombre;
	private int costo;
	private double tiempo;
	private int cupoMaximo;
	private int cuposOcupados;

	public Atraccion(String nombre,TipoDeAtraccion tipoAtraccion,int costo, double tiempo, int cupoMaximo) {
		super(costo, tiempo, tipoAtraccion);
		this.nombre = nombre;
		this.cupoMaximo = cupoMaximo;
		this.cuposOcupados = cuposOcupados;
		// TODO Auto-generated constructor stub
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
