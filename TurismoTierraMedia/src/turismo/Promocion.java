package turismo;

import java.util.List;

public abstract class Promocion extends Producto {
	protected TipoDePromocion tipoPromocion;
	protected List <Atraccion> atracciones; 
	protected double tiempo;
	
	public Promocion (TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, List <Atraccion> atracciones) {
		super(tipoDeAtraccion);
		this.tipoPromocion = tipoPromocion;
		this.atracciones = atracciones;
		
		for (Atraccion atraccion : this.atracciones) {
			this.tiempo = this.tiempo + atraccion.getTiempo();
		}
	}
	
	protected void aplicarPromocion () {
	}
	
	@Override
	public String getNombre() {
		String nombres = "";
		for (Atraccion a : this.atracciones) {
			nombres += a.getNombre() + "/ ";
		}
		return nombres;
	}
	
	
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	@Override
	public double getTiempo() {
		return this.tiempo;
	}
	
	@Override
	public boolean hayCupo() {
		boolean cupo = true;
		for (Atraccion a : this.atracciones) {
			if (a.hayCupo()) {
				cupo = true;
			}
		}
		return cupo;
	}
	
	@Override
	public void ocuparCupo() {
		for(Atraccion a : this.atracciones) {
			a.ocuparCupo();
		}
	}
	
	@Override
	public boolean esPromo() {
		return true;
	}

	@Override
	public String toString() {
		return "P " + tipoPromocion + "/ [Costo total = " + this.getCosto() + ", Tiempo total = " + this.getTiempo() + " horas, Atracciones = " + atracciones + "]";
	}
	
}
