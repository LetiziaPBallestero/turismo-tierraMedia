package turismo;

import java.util.LinkedList;

public class Usuario {
	private TipoDeAtraccion tipoDeAtraccionPreferido;
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private LinkedList<Producto> itinerario = new LinkedList<Producto>();

	public Usuario(TipoDeAtraccion tipoDeAtraccionPreferido, String nombre, double presupuesto, double tiempoDisponible) {
		super();
		this.tipoDeAtraccionPreferido = tipoDeAtraccionPreferido;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}

	public TipoDeAtraccion getTipoDeAtraccionPreferido() {
		return tipoDeAtraccionPreferido;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	//public LinkedList<Producto> getItinerario() {
		//return itinerario;
	//}
	
	public String getItinerario() {
		double costoTotal = 0;
		double tiempoTotal = 0;
		String atracciones = "";
		for (Producto p : this.itinerario) {
			costoTotal += p.getCosto();
			tiempoTotal += p.getTiempo();
			if(p.esPromo())
				atracciones += p.getNombre();
			if(!p.esPromo())
				atracciones += p.getNombre() + "/ ";
			}
		return "Costo total = " + costoTotal + ", Tiempo total = " + tiempoTotal + ", Atracciones = " + atracciones;			
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
