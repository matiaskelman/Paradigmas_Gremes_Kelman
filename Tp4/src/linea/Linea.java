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
		this.gameMode = gameMode;
	}

	public ArrayList<Character> getColumna(int columna) {
		return tablero.get(columna - 1);
	}

	public int getCantColumnas() {
		return this.tablero.size();
	}

	public int getAltura() {
		return altura;
	}

	public char getGameMode() {
		return gameMode;
	}

	public void agregarRojoEnColumna(int columna) {
		this.getColumna(columna).add('R');
	}

	public void agregarAzulEnColumna(int columna) {
		this.getColumna(columna).add('A');
	}

	public boolean show() {

		return true;
	}

	public boolean finished() {
		if (gameMode == 'A') {
			int index = 0;
			while (index < tablero.size()) {
				// for (int index = 0; index < tablero.size() - 1; index++)
				ArrayList<Character> column = this.tablero.get(index);
				if (column.get(column.size() - 1) == 'R') {
					int contadorDeFichasRojas = 1; // [0,1,2,3]
					int indexDeFichaRoja = column.size() - 2; // [R,R,R,R]
					while (indexDeFichaRoja >= 0 && contadorDeFichasRojas < 4) {
						if (column.get(indexDeFichaRoja) != 'R') {
							break;
						} else {
							contadorDeFichasRojas++;
							indexDeFichaRoja--;
						}
						if (contadorDeFichasRojas == 4) {
							return true;
						}
					}
				}
				if (column.get(column.size() - 1) == 'A') {
					int contadorDeFichasAzules = 1; // [0,1,2,3]
					int indexDeFichaAzul = column.size() - 2; // [R,R,R,R]
					while (indexDeFichaAzul >= 0 && contadorDeFichasAzules < 4) {
						if (column.get(indexDeFichaAzul) != 'A') {
							break;
						} else {
							contadorDeFichasAzules++;
							indexDeFichaAzul--;
						}
						if (contadorDeFichasAzules == 4) {
							return true;
						}
					}
				}
				index++;
			}
		}
		return false;
	}
}

//[[R(1,1),R(2,1)][B][][]]