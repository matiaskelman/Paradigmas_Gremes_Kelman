package Nemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class nemoTest {
	@Test
	public void test01NewSubmarine() {
		Coordinates initialCoordinates = new Coordinates(1, 2);
		String initialDirection = "North";
		Sub sub = new Sub(initialCoordinates, initialDirection);
        assertSame(sub.getCoordinates(), initialCoordinates);
        assertSame(sub.getDirection(), initialDirection);
	}

	@Test
	public void test02NullCommands() {
		Coordinates initialCoordinates = new Coordinates(1, 2);
		String initialDirection = "North";
		Sub sub = new Sub(initialCoordinates, initialDirection);
		sub.action("");
        assertSame(sub.getCoordinates(), initialCoordinates);
        assertSame(sub.getDirection(), initialDirection);
	}

	@Test
	public void test03Descend() {
		Sub sub = new Sub(new Coordinates(1, 2), "North");
		sub.action("d");
        assertEquals(-1, sub.getDepth());
	}

	@Test
	public void test04Ascend() {
		Sub sub = new Sub(new Coordinates(1, 2), "North");
		sub.action("ddu");
        assertEquals(-1, sub.getDepth());
	}

	@Test
	public void test05AscendOnSurface() {
		assertThrowsLike(() -> new Sub(new Coordinates(1, 2), "North").action("u"), DepthZero.ERROR_MESSAGE);
	}

	@Test
	public void test06RotateNorthRight() {
		Sub sub = new Sub(new Coordinates(1, 2), "North");
		sub.action("r");
		assertEquals("East", sub.getDirection());
	}

	@Test
	public void test07RotateNorthLeft() {
		Sub sub = new Sub(new Coordinates(1, 2), "North");
		sub.action("l");
		assertEquals("West", sub.getDirection());
	}

	@Test
	public void test08RotateSouthRight() {
		Sub sub = new Sub(new Coordinates(1, 2), "South");
		sub.action("r");
		assertEquals("West", sub.getDirection());
	}

	@Test
	public void test09RotateSouthLeft() {
		Sub sub = new Sub(new Coordinates(1, 2), "South");
		sub.action("l");
		assertEquals("East", sub.getDirection());
	}

	@Test
	public void test10RotateEastRight() {
		Sub sub = new Sub(new Coordinates(1, 2), "East");
		sub.action("r");
		assertEquals("South", sub.getDirection());
	}

	@Test
	public void test11RotateEastLeft() {
		Sub sub = new Sub(new Coordinates(1, 2), "East");
		sub.action("l");
		assertEquals("North", sub.getDirection());
	}

	@Test
	public void test12RotateWestRight() {
		Sub sub = new Sub(new Coordinates(1, 2), "West");
		sub.action("r");
		assertEquals("North", sub.getDirection());
	}

	@Test
	public void test13RotateWestLeft() {
		Sub sub = new Sub(new Coordinates(1, 2), "West");
		sub.action("l");
		assertEquals("South", sub.getDirection());
	}

	@Test
	public void test14Rotate() {
		Sub sub = new Sub(new Coordinates(1, 2), "East");
		sub.action("lr");
		assertEquals("East", sub.getDirection());
	}

	@Test
	public void test15AdvanceEast() {
		Sub sub = new Sub(new Coordinates(1, 2), "East");
		sub.action("f");
        assertEquals(2, sub.getCoordinates().getX());
	}

	@Test
	public void test16AdvanceWest() {
		Sub sub = new Sub(new Coordinates(1, 2), "West");
		sub.action("f");
		assertEquals(0, sub.getCoordinates().getX());
	}

	@Test
	public void test17AdvanceNorth() {
		Sub sub = new Sub(new Coordinates(1, 2), "North");
		sub.action("f");
		assertEquals(3, sub.getCoordinates().getY());
	}

	@Test
	public void test18AdvanceSouth() {
		Sub sub = new Sub(new Coordinates(1, 2), "South");
		sub.action("f");
		assertEquals(1, sub.getCoordinates().getY());
	}

	@Test
	public void test19AdvanceAfterChangeOfDirection01() {
		Sub sub = new Sub(new Coordinates(1, 2), "East");
		sub.action("drf");
        assertEquals(1, sub.getCoordinates().getY());
	}

	@Test
	public void test20AdvanceAfterChangeOfDirection02() {
		Sub sub = new Sub(new Coordinates(1, 2), "East");
		sub.action("drrf");
        assertEquals(0, sub.getCoordinates().getX());
	}

	@Test
	public void test21ReleaseCapsuleAtInappropriateDepth01() {
		assertThrowsLike(() -> new Sub(new Coordinates(1, 2), "North").action("ddm"), DepthDangerousForCapsule.ERROR_MESSAGE);
	}

	@Test
	public void test22ReleaseCapsuleAtInappropriateDepth02() {
		assertThrowsLike(() -> new Sub(new Coordinates(1, 2), "North").action("dddm"), DepthDangerousForCapsule.ERROR_MESSAGE);
	}

	private void assertThrowsLike(Executable executable, String message) {
		assertEquals(message,
				assertThrows(Exception.class , executable ).getMessage());

	}
}

