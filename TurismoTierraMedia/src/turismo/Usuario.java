package turismo;

import java.util.ArrayList;

public class Usuario {
	private TipoDeAtraccion tipoDeAtraccionPreferido;
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private ArrayList<Producto> itinerario;

	public Usuario(TipoDeAtraccion tipoDeAtraccionPreferido, String nombre, int presupuesto, double tiempoDisponible) {
		super();
		this.tipoDeAtraccionPreferido = tipoDeAtraccionPreferido;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}

	public TipoDeAtraccion getTipoDeAtraccionPreferido() {
		return tipoDeAtraccionPreferido;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public ArrayList<Producto> getItinerario() {
		return itinerario;
	}
	
	public void agregarAItinerario(Producto producto) {
		itinerario.add(producto);
	}

	@Override
	public String toString() {
		return "U/ " + nombre + " [Tipo de atracción preferido = " + tipoDeAtraccionPreferido + ", Presupuesto = "
				+ presupuesto + " monedas, Tiempo disponible = " + tiempoDisponible + " horas]";
	}

}
