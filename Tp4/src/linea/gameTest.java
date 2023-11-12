package linea;

import org.junit.jupiter.api.function.Executable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class gameTest {

	@Test
	public void test01CrearTableroModeA() {
		Linea linea = new Linea(4, 4, 'A');
        assertEquals(4, linea.getCantColumnas());
        assertEquals(4, linea.getAltura());
		assertTrue(linea.getColumna(1).isEmpty());
	}

	@Test
	public void test02CrearTableroModeB() {
		Linea linea = new Linea(4, 4, 'B');
        assertEquals(4, linea.getCantColumnas());
        assertEquals(4, linea.getAltura());
		assertTrue(linea.getColumna(1).isEmpty());
	}

	@Test
	public void test03CrearTableroModeC() {
		Linea linea = new Linea(4, 4, 'C');
        assertEquals(4, linea.getCantColumnas());
        assertEquals(4, linea.getAltura());
		assertTrue(linea.getColumna(1).isEmpty());
	}

	@Test
	public void test04RojoPonePrimerFicha() {
		Linea linea = new Linea(4, 4, 'C');
		linea.agregarRojoEnColumna(1);
		assertSame(linea.getColumna(1).get(0), 'R');
	}

	@Test
	public void test05AzulPoneFicha() {
		Linea linea = new Linea(4, 4, 'C');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		assertSame(linea.getColumna(2).get(0), 'A');
	}

	@Test
	public void test06AzulYRojoPonenFicha(){
		Linea linea = new Linea(4,4,'C');
		linea.agregarRojoEnColumna(2);
		linea.agregarAzulEnColumna(1);
		assertSame(linea.getColumna(1).get(0),'A');
		assertSame(linea.getColumna(2).get(0),'R');
	}
	@Test
	public void test07GanaRojoEnModoA_Vertical(){
		Linea linea = new Linea(4,5,'A');
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
		Linea linea = new Linea(4,5,'A');
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
	public void test10GanaAzulEnModoA_Horizontal(){
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
	public void test11GanaRojoEnModoB_TercerCuadrante(){
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
		assertTrue(linea.finished());
	}
	@Test
	public void test12GanaRojoEnModoB_PrimerYTercerCuadrante(){
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
		assertTrue(linea.finished());
	}

	@Test
	public void test13GanaAzulEnModoB_PrimerYTercerCuadrante(){
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
		assertTrue(linea.finished());
	}
@Test
	public void test14GanaRojoEnModoB_CuartoCuadrante(){
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
		assertTrue(linea.finished());
	}

	@Test
	public void test15GanaRojoEnModoB_SegundoCuadrante(){
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
		assertTrue(linea.finished());
	}
	@Test
	public void test16GanaRojoEnModoC_Vertical(){
		Linea linea = new Linea(4,5,'C');
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
	public void test17GanaRojoEnModoC_Horizontal(){
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
	public void test18GanaRojoEnModoC_Diagonal(){
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
		assertTrue(linea.finished());
	}
	@Test
	public void test19GanaAzulEnModoC_Vertical(){
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
	public void test20GanaAzulEnModoC_Horizontal(){
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
	public void test21GanaAzulEnModoC_Diagonal(){
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
	public void test22Empate(){
		Linea linea = new Linea(4,4,'B');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		linea.agregarRojoEnColumna(3);
		linea.agregarAzulEnColumna(4);
		assertSame(linea.getGanador(),"No gano nadie");
		assertTrue(linea.finished());

	}

	@Test
	public void test23LaBaseMayorA4(){
		assertThrowsLike(() -> new Linea(3,4,'A'), Linea.LA_BASE_Y_LA_ALTURA_MINIMA_SON_4);
	}

	@Test
	public void test24LaAlturaMayorA4(){
		assertThrowsLike(() -> new Linea(4,3,'A'), Linea.LA_BASE_Y_LA_ALTURA_MINIMA_SON_4);
	}

	@Test
	public void test25ModoDeJuegoNoExistente(){
		assertThrowsLike(() -> new Linea(5,5,'F'), GameMode.NO_EXISTE_ESTE_MODO_DE_JUEGO);
	}
	@Test
	public void test26RojoAgregaFichaDosVecesSeguidas(){
		Linea linea = new Linea(5,5,'A');
		linea.agregarRojoEnColumna(1);
		assertThrowsLike(() -> linea.agregarRojoEnColumna(1),TurnoAzul.ROJO_NO_PUEDE_PONER_FICHAS_DOS_VECES_SEGUIDAS);
	}
	@Test
	public void test27AzulAgregaFichaDosVecesSeguidas(){
		Linea linea = new Linea(5,5,'A');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(1);
		assertThrowsLike(() -> linea.agregarAzulEnColumna(1),TurnoRojo.AZUL_NO_PUEDE_PONER_FICHAS_DOS_VECES_SEGUIDAS);
	}
	@Test
	public void test28NoSePuedeSeguirJugandoLuegoDeHaberTerminado(){
		Linea linea = new Linea(4,4,'A');
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		linea.agregarAzulEnColumna(2);
		linea.agregarRojoEnColumna(1);
		assertTrue(linea.finished());
		assertThrowsLike(() -> linea.agregarAzulEnColumna(1), TurnoTerminado.JUEGO_YA_HA_TERMINADO);
	}

	private void assertThrowsLike(Executable executable, String message) {

		assertEquals(message,

				assertThrows(Exception.class , executable ).getMessage());

	}
}
