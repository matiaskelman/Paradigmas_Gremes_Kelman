package Nemo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestNemo {
	@Test
	public void testNewSubmarine() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		assertTrue(sub.getCoordenadas() == coordenadasIniciales);
		assertTrue(sub.getDireccion() == direccionInicial);
	}

	@Test
	public void testNullCommands() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("");
		assertTrue(sub.getCoordenadas() == coordenadasIniciales);
		assertTrue(sub.getDireccion() == direccionInicial);
	}

	@Test
	public void testDescend() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		assertTrue(sub.getCoordenadas().getZ() == -1);
	}

	@Test
	public void testAscend() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		sub.accion("d");
		sub.accion("u");
		assertTrue(sub.getCoordenadas().getZ() == -1);
	}

	@Test
	public void testLiberarCapsula01() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		sub.accion("d");
		sub.accion("m");
		assertTrue(sub.isExploto() == true);
	}

	@Test
	public void testLiberarCapsula02() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		sub.accion("m");
		assertTrue(sub.isExploto() == false);
	}

	@Test
	public void testRotarDerecha01() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("r");
		assertTrue(sub.getDireccion() == 90);
	}

	@Test
	public void testRotarIzquierda01() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("l");
		assertTrue(sub.getDireccion() == -90);
	}

	public void testRotar() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("l");
		sub.accion("r");
		assertTrue(sub.getDireccion() == 0);
	}

	@Test
	public void testAvanzar01() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("l");
		assertTrue(sub.getDireccion() == -90);
	}

} // Test
