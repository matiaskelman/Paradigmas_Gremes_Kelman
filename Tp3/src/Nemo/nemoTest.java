package Nemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class nemoTest {
	@Test
	public void test01NewSubmarine() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
        assertSame(sub.getCoordinates(), coordenadasIniciales);
        assertSame(sub.getDirection(), direccionInicial);
	}

	@Test
	public void test02NullCommands() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("");
        assertSame(sub.getCoordinates(), coordenadasIniciales);
        assertSame(sub.getDirection(), direccionInicial);
	}

	@Test
	public void test03Descend() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("d");
        assertEquals(-1, sub.getDepth());
	}

	@Test
	public void test04Ascend() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("ddu");
        assertEquals(-1, sub.getDepth());
	}

	@Test
	public void test05AscendOnSurface() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		assertThrowsLike(() -> sub.action("u"), DepthZero.ERROR_MESSAGE);
	}

	@Test
	public void test06RotateNorthRight() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("r");
        assertSame("East", sub.getDirection());
	}

	@Test
	public void test07RotateNorthLeft() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("l");
		assertSame("West", sub.getDirection());
	}

	@Test
	public void test08RotateSouthRight() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "South";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("r");
		assertSame("West", sub.getDirection());
	}

	@Test
	public void test09RotateSouthLeft() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "South";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("l");
		assertSame("East", sub.getDirection());
	}

	@Test
	public void test10RotateEastRight() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "East";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("r");
		assertSame("South", sub.getDirection());
	}

	@Test
	public void test11RotateEastLeft() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "East";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("l");
        assertSame("North", sub.getDirection());
	}

	@Test
	public void test12RotateWestRight() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "West";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("r");
		assertSame("North", sub.getDirection());
	}

	@Test
	public void test13RotateWestLeft() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "West";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("l");
		assertSame("South", sub.getDirection());
	}

	@Test
	public void test14Rotate() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "East";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("lr");
        assertSame("East", sub.getDirection());
	}

	@Test
	public void test15AdvanceEast() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "East";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("f");
        assertEquals(2, sub.getCoordinates().getX());
	}

	@Test
	public void test16AdvanceWest() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "West";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("f");
		assertEquals(0, sub.getCoordinates().getX());
	}

	@Test
	public void test17AdvanceNorth() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("f");
		assertEquals(3, sub.getCoordinates().getY());
	}

	@Test
	public void test18AdvanceSouth() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "South";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("f");
		assertEquals(1, sub.getCoordinates().getY());
	}

	@Test
	public void test19AdvanceAfterChangeOfDirection01() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "East";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("drf");
        assertEquals(1, sub.getCoordinates().getY());
	}

	@Test
	public void test20AdvanceAfterChangeOfDirection02() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "East";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		sub.action("drrf");
        assertEquals(0, sub.getCoordinates().getX());
	}

	@Test
	public void test21ReleaseCapsuleAtInappropriateDepth01() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		assertThrowsLike(() -> sub.action("ddm"), DepthDangerousForCapsule.ERROR_MESSAGE);
	}

	@Test
	public void test22ReleaseCapsuleAtInappropriateDepth02() {
		Coordinates coordenadasIniciales = new Coordinates(1, 2);
		String direccionInicial = "North";
		Sub sub = new Sub(coordenadasIniciales, direccionInicial);
		assertThrowsLike(() -> sub.action("dddm"), DepthDangerousForCapsule.ERROR_MESSAGE);
	}


	private void assertThrowsLike(Executable executable, String message) {

		assertEquals(message,
				assertThrows(Exception.class , executable ).getMessage());

	}
}

