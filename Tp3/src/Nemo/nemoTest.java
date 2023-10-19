package Nemo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class nemoTest {
	@Test
	public void test01NewSubmarine() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		assertTrue(sub.getCoordenadas() == coordenadasIniciales);
		assertTrue(sub.getDireccion() == direccionInicial);
	}

	@Test
	public void test02NullCommands() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("");
		assertTrue(sub.getCoordenadas() == coordenadasIniciales);
		assertTrue(sub.getDireccion() == direccionInicial);
	}

	@Test
	public void test03Descend() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		assertTrue(sub.getCoordenadas().getZ() == -1);
	}

	@Test
	public void test04Ascend() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		sub.accion("d");
		sub.accion("u");
		assertTrue(sub.getCoordenadas().getZ() == -1);
	}

	@Test
	public void test05LiberarCapsula01() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		sub.accion("d");
		sub.accion("m");
		assertTrue(sub.isExploto() == true);
	}

	@Test
	public void test06LiberarCapsula02() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		sub.accion("m");
		assertTrue(sub.isExploto() == false);
	}

	@Test
	public void test07RotarDerecha01() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("r");
		assertTrue(sub.getDireccion() == -90);
	}

	@Test
	public void test08RotarIzquierda01() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("l");
		assertTrue(sub.getDireccion() == 90);
	}

	public void test09Rotar() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("l");
		sub.accion("r");
		assertTrue(sub.getDireccion() == 0);
	}

	@Test
	public void test10Avanzar01() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("f");
		assertTrue(sub.getCoordenadas().getX() == 2);
	}

	@Test
	public void test11Avanzar02() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		sub.accion("r");
		sub.accion("f");
		assertTrue(sub.getCoordenadas().getY() == 1);
	}

	@Test
	public void test12Avanzar03() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("d");
		sub.accion("r");
		sub.accion("r");
		sub.accion("f");
		assertTrue(sub.getCoordenadas().getX() == 0);
	}

	@Test
	public void test13MultiplesComandos() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.accion("drrf");
		assertTrue(sub.getCoordenadas().getX() == 0);
	}

} // Test
