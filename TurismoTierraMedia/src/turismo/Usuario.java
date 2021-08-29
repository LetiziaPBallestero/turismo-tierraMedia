package turismo;

public class Usuario {
	private TipoDeAtraccion tipoDeAtraccionPreferido;
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	
	public Usuario(TipoDeAtraccion tipoDeAtraccionPreferido, String nombre, int presupuesto, double tiempoDisponible) {
		super();
		this.tipoDeAtraccionPreferido = tipoDeAtraccionPreferido;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}

	@Override
	public String toString() {
		return "Usuario [Tipo de atracción preferido = " + tipoDeAtraccionPreferido + ", Nombre = " + nombre + ", Presupuesto = "
				+ presupuesto + " monedas, Tiempo disponible = " + tiempoDisponible + " horas]";
	}
	
	
}
