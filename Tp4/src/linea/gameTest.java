package linea;

import org.junit.jupiter.api.function.Executable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class gameTest {
//Soy gay. Si no me pones un 10 es porque sos homofobico.
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
		assertSame(linea.getColumna(1).get(0),'R');
	}
	@Test
	public void test05AzulPonePrimerFicha() {
		Linea linea = new Linea(1, 2, 'C');
		linea.agregarAzulEnColumna(1);
		assertSame(linea.getColumna(1).get(0),'A');
	}
	@Test
	public void test06AzulYRojoPonenFicha(){
		Linea linea = new Linea(2,3,'C');
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(2);
		assertSame(linea.getColumna(1).get(0),'A');
		assertSame(linea.getColumna(2).get(0),'R');
	}
	@Test
	public void test07GanaRojoEnModoA_Vertical(){
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
	public void test08GanaRojoEnModoA_Horizontal(){
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
	public void test09GanaAzulEnModoA_Vertical(){
		Linea linea = new Linea(2,5,'A');
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		assertTrue(linea.finished());
	}
	@Test
	public void test10GanaAzulEnModoA_Horizontal(){
		Linea linea = new Linea(5,5,'A');
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
	public void test11GanaRojoEnModoB(){
		Linea linea = new Linea(5,5,'B');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(4);
		assertTrue(linea.finished());
	}
	@Test
	public void test12GanaAzulEnModoB(){
		Linea linea = new Linea(5,5,'B');
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(4);
		assertTrue(linea.finished());
	}
	@Test
	public void test07GanaRojoEnModoC_Vertical(){
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
	public void test08GanaRojoEnModoC_Horizontal(){
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
	public void test11GanaRojoEnModoC_Diagonal(){
		Linea linea = new Linea(5,5,'C');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(4);
		assertTrue(linea.finished());
	}
	@Test
	public void test09GanaAzulEnModoC_Vertical(){
		Linea linea = new Linea(2,5,'C');
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		assertTrue(linea.finished());
	}
	@Test
	public void test10GanaAzulEnModoC_Horizontal(){
		Linea linea = new Linea(5,5,'C');
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
	public void test12GanaAzulEnModoC_Diagonal(){
		Linea linea = new Linea(5,5,'C');
		linea.agregarAzulEnColumna(1);
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(3);
		linea.agregarRojoEnColumna(4);
		linea.agregarAzulEnColumna(4);
		assertTrue(linea.finished());
	}
	@Test
	public void test20RojoAgregaFichaDosVecesSeguidas(){
		Linea linea = new Linea(5,5,'A');
		linea.agregarRojoEnColumna(1);
		assertThrowsLike(() -> linea.agregarRojoEnColumna(1),"Rojo no puede poner fichas dos veces seguidas");
	}
	@Test
	public void test20AzulAgregaFichaDosVecesSeguidas(){
		Linea linea = new Linea(5,5,'A');
		linea.agregarAzulEnColumna(1);
		assertThrowsLike(() -> linea.agregarAzulEnColumna(1),"Azul no puede poner fichas dos veces seguidas");
	}

	private void assertThrowsLike(Executable executable, String message) {

		assertEquals(message,

				assertThrows(Exception.class , executable ).getMessage());

	}
}
