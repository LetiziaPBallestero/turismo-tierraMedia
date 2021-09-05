package turismo;

import java.util.Comparator;

public class ProductoComparator implements Comparator<Producto>{
	
	private TipoDeAtraccion tipoPreferido;
	
	public ProductoComparator(TipoDeAtraccion tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		if(o1.tipoDeAtraccion == this.tipoPreferido && o2.tipoDeAtraccion == this.tipoPreferido) {
			if(o1.esPromo() && o2.esPromo()) {
				if(Double.compare(o1.getCosto(), o2.getCosto()) == 0){
					return -Double.compare(o1.getTiempo(), o2.getTiempo());
				} else {
					return -Double.compare(o1.getCosto(), o2.getCosto());
				}
			} else {
				return -Boolean.compare(o1.esPromo(), o2.esPromo());
			}
		} else if (o1.tipoDeAtraccion != this.tipoPreferido && o2.tipoDeAtraccion != this.tipoPreferido) {
			if (o1.esPromo() && o2.esPromo()) {
				if(Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
					return -Double.compare(o1.getTiempo(), o2.getTiempo());
				} else {
					return -Double.compare(o1.getCosto(), o2.getCosto());
				}
			} else if (!o1.esPromo() && !o2.esPromo()) {
				if(Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
					return -Double.compare(o1.getTiempo(), o2.getTiempo());
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

}
