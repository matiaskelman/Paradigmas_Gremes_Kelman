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
		return this.tablero.size();
	}

	public ArrayList<Character> getColumna(int columna) {
		return tablero.get(columna-1);
	}

	public int getAltura() {
		return altura;
	}

	public void agregarRojoEnColumna(int columna) {
		this.getColumna(columna).add('R');
	}
	public void agregarAzulEnColumna(int columna) {
		this.getColumna(columna).add('A');
	}

	public char getGameMode() {
		return gameMode;
	}

	public boolean show() {

		return true;
	}

	public boolean finished() {
		if (this.gameMode == 'A') {
			for (int index = 0; index == tablero.size() - 1; index++) {
				ArrayList<Character> column = this.tablero.get(index);
				if (column.get(column.size() - 1) == 1) {

				}

			}
		}
		return true;
	}

	public void playRedAt(int prompt) {
	}

	public void playBlueAt(int prompt) {
	}
}


//[[R(1,1),R(2,1)][B][][]]