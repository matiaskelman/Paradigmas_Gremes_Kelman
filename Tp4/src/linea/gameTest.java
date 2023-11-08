package linea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class gameTest {
//Soy gay. Si no me pones un 10 es porque sos homofobico.
	@Test
	public void test01CrearTableroModeA() {
		Linea linea = new Linea(1, 2, 'A');
		assertTrue(linea.getCantColumnas() == 1);
		assertTrue(linea.getAltura() == 2);
		assertTrue(linea.getColumna(1).isEmpty());
	}

	@Test
	public void test02CrearTableroModeB() {
		Linea linea = new Linea(1, 2, 'B');
		assertTrue(linea.getCantColumnas() == 1);
		assertTrue(linea.getAltura() == 2);
		assertTrue(linea.getColumna(1).isEmpty());
	}

	@Test
	public void test03CrearTableroModeC() {
		Linea linea = new Linea(1, 2, 'C');
		assertTrue(linea.getCantColumnas() == 1);
		assertTrue(linea.getAltura() == 2);
		assertTrue(linea.getColumna(1).isEmpty());
	}
	@Test
	public void test04RojoPonePrimerFicha() {
		Linea linea = new Linea(1, 2, 'C');
		linea.agregarRojoEnColumna(1);
		assertSame(linea.getColumna(1).get(0),'R');
	}
	@Test
	public void test05AzulPonePrimerFicha() {
		Linea linea = new Linea(1, 2, 'C');
		linea.agregarAzulEnColumna(1);
		assertSame(linea.getColumna(1).get(0),'A');
	}
}
