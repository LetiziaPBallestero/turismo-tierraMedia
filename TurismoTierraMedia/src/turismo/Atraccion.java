package turismo;

public class Atraccion extends Producto {
	private String nombre;
	private int cupoMaximo;

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

	public int getCuposOcupados() {
		return cuposOcupados;
	}

	public int getCupo(){
		return cupoMaximo - cuposOcupados;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean hayCupo() {
		return this.cuposOcupados < this.cupoMaximo;
	}

	@Override
	public void ocuparCupo() {
		this.cuposOcupados += 1;
	}

	@Override
	public String toString() {
		return "A/ " + nombre + " [Tipo de atraccion = " + tipoDeAtraccion + ", Costo = " + costo
				+ " monedas, Tiempo = " + tiempo + " horas, Cupo maximo = " + cupoMaximo + ", Cupos ocupados = "
				+ cuposOcupados + "]";
	}

	public String toStringCorto() {
		return nombre + ", " + costo + " monedas, " + tiempo + " horas]";
	}

}
