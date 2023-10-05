package Nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class TestNemo {
	@Test
	public void testNewSubmarine() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 3);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		assertTrue(sub.getCoordenadas() == coordenadasIniciales);
		assertTrue(sub.getDireccion() == direccionInicial);
	}

	@Test
	public void testNullCommands() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 3);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.moverse("");
		assertTrue(sub.getCoordenadas() == coordenadasIniciales);
		assertTrue(sub.getDireccion() == direccionInicial);
	}

	@Test
	public void testDescend() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 3);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.moverse("d");
		assertTrue(sub.getCoordenadas().getZ() == 2);
	}

	@Test
	public void testAscend() {
		Coordenadas coordenadasIniciales = new Coordenadas(1, 2, 0);
		float direccionInicial = 0;
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.moverse("d");
		sub.moverse("d");
		sub.moverse("u");
		assertTrue(sub.getCoordenadas().getZ() == -1);
		
	}

} // Test
