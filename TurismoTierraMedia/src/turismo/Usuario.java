package turismo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Usuario {
	private TipoDeAtraccion tipoDeAtraccionPreferido;
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private LinkedList<Producto> itinerario = new LinkedList();

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

	public LinkedList<Producto> getItinerario() {
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

	public String getNombre() {
		return nombre;
	}

}
