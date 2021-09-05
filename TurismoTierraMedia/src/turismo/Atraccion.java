package turismo;

public class Atraccion extends Producto {
	private String nombre;
	private int cupoMaximo;
	private int cuposOcupados;

	public Atraccion(String nombre, TipoDeAtraccion tipo, double costo, double tiempo, int cupo) {
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

	public boolean hayCupo() {
		return this.cuposOcupados < this.cupoMaximo;
	}

	@Override
	public String toString() {
		return "A/ " + nombre + " [Tipo de atraccion = " + tipoDeAtraccion + ", Costo = " + costo + " monedas, Tiempo = " + tiempo
				+ " horas, Cupo maximo = " + cupoMaximo + ", Cupos ocupados = " + cuposOcupados + "]";
	}
	
	public String toStringCorto() {
		return nombre + ", " + costo + " monedas, " + tiempo
				+ " horas]";
	}

}
