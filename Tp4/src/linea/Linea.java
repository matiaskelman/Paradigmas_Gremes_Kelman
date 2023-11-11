package linea;

import java.util.ArrayList;
import java.util.List;

public class Linea {

	private GameMode gameMode;
	private int altura;
	private Turno turno;
	private Turno turnoAnterior;
	private int columnaDeUltimaFichaPuesta;
	List<ArrayList<Character>> tablero;

	public Linea(int columnas, int altura, char gameMode) {
		this.tablero = new ArrayList<>();
		for (int i = columnas; i > 0; i--) {
			tablero.add(new ArrayList<Character>());
		}
		this.altura = altura;
		this.gameMode = GameMode.modoFor(gameMode);
		this.turno = new TurnoRojo();

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

	public Turno getTurnoAnterior() {
		return turnoAnterior;
	}

	public List<ArrayList<Character>> getTablero() {
		return this.tablero;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public int getColumnaDeUltimaFichaPuesta() {
		return columnaDeUltimaFichaPuesta;
	}

	public void agregarRojoEnColumna(int columna) {
		tablero.get(columna - 1).add(turno.juegaRojo());
		//boolean terminado = gameMode.isJuegoGanado(this);
		this.turno = new TurnoAzul();
		this.turnoAnterior = new TurnoRojo();
		this.columnaDeUltimaFichaPuesta = columna;

	}

	public void agregarAzulEnColumna(int columna) {
		tablero.get(columna - 1).add(turno.juegaAzul());
		this.turno = new TurnoRojo();
		this.turnoAnterior = new TurnoAzul();
		this.columnaDeUltimaFichaPuesta = columna;
	}

	public Turno getTurno() {
		return turno;
	}

	public String show() {

		return tablero.stream()
				.map(row -> row.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append))
				.collect(StringBuilder::new, (result, row) -> result.append(row).append("\n"), StringBuilder::append)
				.toString();
	}

	public boolean finished() {
		return gameMode.isJuegoGanado(this);
	}
}