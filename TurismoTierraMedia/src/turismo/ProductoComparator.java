package turismo;

import java.util.Comparator;

public class ProductoComparator implements Comparator<Producto>{
	
	private TipoDeAtraccion tipoPreferido;
	
	public ProductoComparator(TipoDeAtraccion tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		if(ambosSonTipoPreferido(o1, o2)) {
			if(ambosSonPromo(o1, o2)) {
				if(tienenMismoCosto(o1, o2)){
					return -compararTiempo(o1, o2);
				} else {
					return -Double.compare(o1.getCosto(), o2.getCosto());
				}
			} else {
				return -Boolean.compare(o1.esPromo(), o2.esPromo());
			}
		} else if (ningunoEsTipoPreferido(o1, o2)) {
			if (ambosSonPromo(o1, o2)) {
				if(tienenMismoCosto(o1, o2)) {
					return -compararTiempo(o1, o2);
				} else {
					return -Double.compare(o1.getCosto(), o2.getCosto());
				}
			} else if (ningunoEsPromo(o1, o2)) {
				if(tienenMismoCosto(o1, o2)) {
					return -compararTiempo(o1, o2);
				} else {
					return -Double.compare(o1.getCosto(), o2.getCosto());
				}
			} else {
				return -Boolean.compare(o1.esPromo(), o2.esPromo());
			}
		} else {
			if(o1.tipoDeAtraccion == this.tipoPreferido)
				return -1;
			return 1;
		}
	}

	private int compararTiempo(Producto o1, Producto o2) {
		return Double.compare(o1.getTiempo(), o2.getTiempo());
	}

	private boolean ningunoEsPromo(Producto o1, Producto o2) {
		return !o1.esPromo() && !o2.esPromo();
	}

	private boolean ningunoEsTipoPreferido(Producto o1, Producto o2) {
		return o1.tipoDeAtraccion != this.tipoPreferido && o2.tipoDeAtraccion != this.tipoPreferido;
	}

	private boolean tienenMismoCosto(Producto o1, Producto o2) {
		return Double.compare(o1.getCosto(), o2.getCosto()) == 0;
	}

	private boolean ambosSonPromo(Producto o1, Producto o2) {
		return o1.esPromo() && o2.esPromo();
	}

	private boolean ambosSonTipoPreferido(Producto o1, Producto o2) {
		return o1.tipoDeAtraccion == this.tipoPreferido && o2.tipoDeAtraccion == this.tipoPreferido;
	}

}


