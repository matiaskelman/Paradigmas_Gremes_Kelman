package linea;

import org.junit.jupiter.api.function.Executable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class gameTest {

	@Test
	public void test01CrearTableroModeA() {
		Linea linea = new Linea(1, 2, 'A');
        assertEquals(1, linea.getCantColumnas());
        assertEquals(2, linea.getAltura());
		assertTrue(linea.getColumna(1).isEmpty());
	}

	@Test
	public void test02CrearTableroModeB() {
		Linea linea = new Linea(1, 2, 'B');
        assertEquals(1, linea.getCantColumnas());
        assertEquals(2, linea.getAltura());
		assertTrue(linea.getColumna(1).isEmpty());
	}

	@Test
	public void test03CrearTableroModeC() {
		Linea linea = new Linea(1, 2, 'C');
        assertEquals(1, linea.getCantColumnas());
        assertEquals(2, linea.getAltura());
		assertTrue(linea.getColumna(1).isEmpty());
	}

	@Test
	public void test04RojoPonePrimerFicha() {
		Linea linea = new Linea(1, 2, 'C');
		linea.agregarRojoEnColumna(1);
		assertSame(linea.getColumna(1).get(0), 'R');
	}

	@Test
	public void test05AzulPoneFicha() {
		Linea linea = new Linea(2, 2, 'C');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		assertSame(linea.getColumna(2).get(0), 'A');
	}

	@Test
	public void test08AzulYRojoPonenFicha(){
		Linea linea = new Linea(2,3,'C');
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(1);
		assertSame(linea.getColumna(1).get(0),'A');
		assertSame(linea.getColumna(2).get(0),'R');
	}
	@Test
	public void test09GanaRojoEnModoA_Vertical(){
		Linea linea = new Linea(2,5,'A');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		assertTrue(linea.finished());
	}
	@Test
	public void test10GanaRojoEnModoA_Horizontal(){
		Linea linea = new Linea(5,5,'A');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(4);
		assertTrue(linea.finished());
	}
	@Test
	public void test11GanaAzulEnModoA_Vertical(){
		Linea linea = new Linea(3,5,'A');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(2);
		assertTrue(linea.finished());
	}
	@Test
	public void test12GanaAzulEnModoA_Horizontal(){
		Linea linea = new Linea(5,5,'A');
		linea.agregarRojoEnColumna(5);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		assertTrue(linea.finished());
	}
	@Test
	public void test13GanaRojoEnModoB_TercerCuadrante(){
		Linea linea = new Linea(5,5,'B');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(5);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(4);
		System.out.print(linea.show());
		assertTrue(linea.finished());
	}
	@Test
	public void test50GanaRojoEnModoB_PrimerYTercerCuadrante(){
		Linea linea = new Linea(5,5,'B');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(5);
		linea.agregarRojoEnColumna(3);
		System.out.print(linea.show());
		assertTrue(linea.finished());
	}

	@Test
	public void test14GanaAzulEnModoB_PrimerYTercerCuadrante(){
		Linea linea = new Linea(5,5,'B');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(5);
		linea.agregarAzulEnColumna(5);
		linea.agregarRojoEnColumna(5);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(5);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(5);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(3);
		System.out.print(linea.show());
		assertTrue(linea.finished());
	}
@Test
	public void test13GanaRojoEnModoB_CuartoCuadrante(){
		Linea linea = new Linea(5,5,'B');
		linea.agregarRojoEnColumna(5);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(2);
		System.out.print(linea.show());
		assertTrue(linea.finished());
	}

	@Test
	public void test13GanaRojoEnModoB_SegundoCuadrante(){
		Linea linea = new Linea(5,5,'B');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(5);
		System.out.print(linea.show());
		assertTrue(linea.finished());
	}
	@Test
	public void test15GanaRojoEnModoC_Vertical(){
		Linea linea = new Linea(2,5,'C');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		assertTrue(linea.finished());
	}
	@Test
	public void test16GanaRojoEnModoC_Horizontal(){
		Linea linea = new Linea(5,5,'C');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(4);
		assertTrue(linea.finished());
	}
	@Test
	public void test17GanaRojoEnModoC_Diagonal(){
		Linea linea = new Linea(5,5,'C');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(5);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(4);
		System.out.print(linea.show());
		assertTrue(linea.finished());
	}
	@Test
	public void test18GanaAzulEnModoC_Vertical(){
		Linea linea = new Linea(5,5,'C');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(2);
		assertTrue(linea.finished());
	}
	@Test
	public void test19GanaAzulEnModoC_Horizontal(){
		Linea linea = new Linea(5,5,'C');
		linea.agregarRojoEnColumna(5);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		assertTrue(linea.finished());
	}
	@Test
	public void test20GanaAzulEnModoC_Diagonal(){
		Linea linea = new Linea(5,5,'C');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(5);
		linea.agregarAzulEnColumna(5);
		linea.agregarRojoEnColumna(5);
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(5);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(5);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(3);
		assertTrue(linea.finished());
	}
	@Test
	public void test21RojoAgregaFichaDosVecesSeguidas(){
		Linea linea = new Linea(5,5,'A');
		linea.agregarRojoEnColumna(1);
		assertThrowsLike(() -> linea.agregarRojoEnColumna(1),"Rojo no puede poner fichas dos veces seguidas");
	}
	@Test
	public void test22AzulAgregaFichaDosVecesSeguidas(){
		Linea linea = new Linea(5,5,'A');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(1);
		assertThrowsLike(() -> linea.agregarAzulEnColumna(1),"Azul no puede poner fichas dos veces seguidas");
	}

	private void assertThrowsLike(Executable executable, String message) {

		assertEquals(message,

				assertThrows(Exception.class , executable ).getMessage());

	}
}
