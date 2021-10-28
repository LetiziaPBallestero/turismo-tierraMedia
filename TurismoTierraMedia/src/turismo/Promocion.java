package turismo;

import java.util.List;
import java.util.Objects;

public abstract class Promocion extends Producto {
	protected TipoDePromocion tipoPromocion;
	protected List<Atraccion> atracciones;
	protected double tiempo;
	protected int idPromo;

	public Promocion(TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion) {
		super(tipoDeAtraccion);
		this.tipoPromocion = tipoPromocion;
	}

	public Promocion(int idPromo, TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion) {
		super(tipoDeAtraccion);
		this.tipoPromocion = tipoPromocion;
		this.idPromo = idPromo;
	}

	public Promocion(TipoDePromocion tipoPromocion, TipoDeAtraccion tipoDeAtraccion, List<Atraccion> atracciones) {
		super(tipoDeAtraccion);
		this.tipoPromocion = tipoPromocion;
		this.atracciones = atracciones;

		for (Atraccion atraccion : this.atracciones) {
			this.tiempo = this.tiempo + atraccion.getTiempo();
		}
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
		for (Atraccion atraccion : this.atracciones) {
			this.tiempo = this.tiempo + atraccion.getTiempo();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPromo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return idPromo == other.idPromo;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	protected void aplicarPromocion() {
	}

	@Override
	public String getNombre() {
		String nombres = "";
		for (Atraccion a : this.atracciones) {
			nombres += a.getNombre() + "/ ";
		}
		return nombres;
	}

	public int getIdPromo() {
		return idPromo;
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
		for (Atraccion a : this.atracciones) {
			a.ocuparCupo();
		}
	}

	@Override
	public boolean esPromo() {
		return true;
	}

	@Override
	public String toString() {
		return "P " + tipoPromocion + "/ [Costo total = " + this.getCosto() + ", Tiempo total = " + this.getTiempo()
				+ " horas, Atracciones = " + atracciones + "]";
	}

}
