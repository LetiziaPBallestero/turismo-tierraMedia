package turismo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TierraMediaTest {

	@Test
	public void usuarioTest() {
		Usuario eowyn = new Usuario(TipoDeAtraccion.AVENTURA, "Eowyn", 10, 8);
		Usuario gandalf = new Usuario(TipoDeAtraccion.PAISAJE, "Gandalf", 100, 5);
		Usuario sam = new Usuario(TipoDeAtraccion.DEGUSTACION, "Sam", 36, 8);
		Usuario galadriel = new Usuario(TipoDeAtraccion.PAISAJE, "Galadriel", 120, 8);
		
		assertEquals("Eowyn", eowyn.getNombre());
		assertEquals(TipoDeAtraccion.PAISAJE, gandalf.getTipoDeAtraccionPreferido());
		assertEquals(36, sam.getPresupuesto(), 0);
		assertEquals(8, galadriel.getTiempoDisponible(), 0);
	}
	
	@Test
	public void atraccionTest() {
		Atraccion moria = new Atraccion("Moria", TipoDeAtraccion.AVENTURA, 10, 2, 6);
		Atraccion minasTirith = new Atraccion("Minas Tirith", TipoDeAtraccion.PAISAJE, 5, 2.5, 25);
		Atraccion laComarca = new Atraccion("La Comarca", TipoDeAtraccion.DEGUSTACION, 3, 6.5, 150);
		Atraccion mordor = new Atraccion("Mordor", TipoDeAtraccion.AVENTURA, 25, 3, 4);
		
		assertEquals("Moria", moria.getNombre());
		assertEquals(TipoDeAtraccion.PAISAJE, minasTirith.getTipo());
		assertEquals(3, laComarca.getCosto(), 0);
		assertEquals(3, mordor.getTiempo(), 0);
	}

}
