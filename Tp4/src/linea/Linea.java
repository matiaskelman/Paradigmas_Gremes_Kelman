package linea;

import java.util.ArrayList;
import java.util.List;

public class Linea {

	private char gameMode;
	private int altura;
	List<ArrayList<Character>> tablero;

	public Linea(int columnas, int altura, char gameMode) {
		this.tablero = new ArrayList<>();
		for (int i = columnas; i > 0; i--) {
			tablero.add(new ArrayList<Character>());
		}
		this.altura = altura;
		this.gameMode = Character.toLowerCase(gameMode);
	}

	public int getCantColumnas() {
		// TODO Auto-generated method stub
		return this.tablero.size();
	}

	public ArrayList<Character> getColumna(int index) {
		index = index - 1;
		return tablero.get(index);
	}

	public int getAltura() {
		// TODO Auto-generated method stub
		return altura;
	}

	public void agregarRojoEnColumna(int columna) {
		this.getColumna(columna).add('R');
	}
	public void agregarAzulEnColumna(int columna) {
		this.getColumna(columna).add('A');
	}
}

//[[R(1,1),R(2,1)][B][][]]