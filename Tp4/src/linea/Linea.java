package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea {
	private GameMode gameMode;

	private int altura;
	private Turno turno;
	private Turno turnoAnterior;
	private int columnaDeUltimaFichaPuesta;
	private int filaDeUltimaFichaPuesta;
	List<ArrayList<Character>> tablero;
	private boolean ganoRojo = false;
	private boolean ganoAzul = false;
	private String ganador;

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

	public int getColumnaDeUltimaFichaPuesta() {
		return columnaDeUltimaFichaPuesta;
	}

	public int getIndexColumnaDeUltimaFichaPuesta() {
		return columnaDeUltimaFichaPuesta - 1;
	}

	public int getFilaDeUltimaFichaPuesta() {return filaDeUltimaFichaPuesta;}

	public int getIndexFilaDeUltimaFichaPuesta() {
		return filaDeUltimaFichaPuesta - 1;
	}

	public int getAltura() {
		return altura;
	}

	public Turno getTurno() {
		return turno;
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

	public void agregarRojoEnColumna(int columna) {
		tablero.get(columna - 1).add(turno.juegaRojo());
		this.turno = new TurnoAzul();
		this.turnoAnterior = new TurnoRojo();
		this.columnaDeUltimaFichaPuesta = columna;
		this.filaDeUltimaFichaPuesta = this.getTablero().get(getIndexColumnaDeUltimaFichaPuesta()).size();
		ganoRojo = gameMode.isJuegoGanado(this);

	}

	public void agregarAzulEnColumna(int columna) {
		tablero.get(columna - 1).add(turno.juegaAzul());
		this.turno = new TurnoRojo();
		this.turnoAnterior = new TurnoAzul();
		this.columnaDeUltimaFichaPuesta = columna;
		this.filaDeUltimaFichaPuesta = this.getTablero().get(getIndexColumnaDeUltimaFichaPuesta()).size();
		ganoAzul = gameMode.isJuegoGanado(this);
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

	public boolean victoriaVertical() {
		int cantidadDeFichas = this.getTablero().get(getIndexColumnaDeUltimaFichaPuesta()).stream()
				.filter((ficha) -> this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta()).indexOf(ficha) + 1 > this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta()).size() - 4 && ficha == this.getTurnoAnterior().conseguirFicha())
				.mapToInt((ficha) -> 1)    //[A,R,R,R,R]
				.sum();
		return cantidadDeFichas >= 4;
	}

	public boolean victoriaHorizontal() {
		int cantidadDeFichass = 0;

		IntStream.range(this.getColumnaDeUltimaFichaPuesta() - 4, this.getColumnaDeUltimaFichaPuesta()).forEachOrdered(System.out::println);
		System.out.print("=============\n");
		IntStream.range(this.getColumnaDeUltimaFichaPuesta() - 4, this.getColumnaDeUltimaFichaPuesta()).map(i -> this.getColumnaDeUltimaFichaPuesta() - i + this.getColumnaDeUltimaFichaPuesta() - 4 - 1).forEachOrdered(System.out::println);
		System.out.print("=============\n");
		cantidadDeFichass = (int) (cantidadDeFichass + IntStream.range(this.getColumnaDeUltimaFichaPuesta() - 4, this.getColumnaDeUltimaFichaPuesta())
				.map(i -> this.getColumnaDeUltimaFichaPuesta() - i + this.getColumnaDeUltimaFichaPuesta() - 4 - 1) //invierte la lista
				.takeWhile((indice) ->
						   indice >= 0
						&& !this.getTablero().get(indice).isEmpty()
						&& this.getTablero().get(indice).size() >= this.getTablero().get(this.getColumnaDeUltimaFichaPuesta()-1).size()
						&& this.getTurnoAnterior().conseguirFicha() == this.getTablero().get(indice).get(this.getIndexFilaDeUltimaFichaPuesta())).mapToDouble((each) -> 1.0).sum());

		cantidadDeFichass = (int) (cantidadDeFichass + IntStream.range(this.getColumnaDeUltimaFichaPuesta(), this.getColumnaDeUltimaFichaPuesta() + 3)
				.takeWhile((indice) ->
						   indice <= this.getTablero().size() - 1
						&& !this.getTablero().get(indice).isEmpty()
						&& this.getTablero().get(indice).size() >= this.getTablero().get(this.getColumnaDeUltimaFichaPuesta()-1).size()
						&& this.getTurnoAnterior().conseguirFicha() == this.getTablero().get(indice).get(this.getIndexFilaDeUltimaFichaPuesta())).mapToDouble((each) -> 1.0).sum());

		return cantidadDeFichass >= 4;
	}

	public boolean victoriaDiagonalCuadrante1y3() {
		int contadorDeFichasCuadrante1y3 = 1;

		//primer cuadrante
		contadorDeFichasCuadrante1y3 = (int) (contadorDeFichasCuadrante1y3 + IntStream.range(1,4).takeWhile((indice) ->
						   this.getIndexColumnaDeUltimaFichaPuesta() + indice <= this.getTablero().size() -1
						&& this.getIndexFilaDeUltimaFichaPuesta() + indice <= this.getAltura()-1
						&& !this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() + indice).isEmpty()
						&& this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta()).size()+indice <= this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() + indice).size()
						&& this.getTurnoAnterior().conseguirFicha() == this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() + indice).get(this.getIndexFilaDeUltimaFichaPuesta() + indice)).mapToDouble((each) -> 1.0).sum());

		//tercer cuadrante
		contadorDeFichasCuadrante1y3 = (int) (contadorDeFichasCuadrante1y3 + IntStream.range(1,4).takeWhile((indice) ->
						   this.getIndexColumnaDeUltimaFichaPuesta() - indice >= 0
						&& this.getIndexFilaDeUltimaFichaPuesta() - indice >= 0
						&& !this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() - indice).isEmpty()
						&& this.getTablero().get(this.getColumnaDeUltimaFichaPuesta() - indice).size()-1 <= this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() - indice).size()
						&& this.getTurnoAnterior().conseguirFicha() == this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() - indice).get(this.getIndexFilaDeUltimaFichaPuesta() - indice)).mapToDouble((each) -> 1.0).sum());

		return contadorDeFichasCuadrante1y3 >= 4;
	}

	public boolean victoriaDiagonalCuadrante2y4() {
		int contadorDeFichasCuadrante2y4 = 1;

		//segundo cuadrante
		contadorDeFichasCuadrante2y4 = (int) (contadorDeFichasCuadrante2y4 + IntStream.range(1,4).takeWhile((indice) ->
						   this.getIndexColumnaDeUltimaFichaPuesta() - indice >= 0
						&& this.getIndexFilaDeUltimaFichaPuesta() + indice <= this.getAltura()-1
						&& !this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() - indice).isEmpty()
						&& this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta()).size() + indice <= this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() - indice).size()
						&& this.getTurnoAnterior().conseguirFicha() == this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() - indice).get(this.getIndexFilaDeUltimaFichaPuesta() + indice)).mapToDouble((each) -> 1.0).sum());

		//cuarto cuadrante
		contadorDeFichasCuadrante2y4 = (int) (contadorDeFichasCuadrante2y4 + IntStream.range(1,4).takeWhile((indice) ->
						   this.getIndexColumnaDeUltimaFichaPuesta() + indice <= this.getTablero().size() -1
						&& this.getIndexFilaDeUltimaFichaPuesta() - indice >= 0
						&& !this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() + indice).isEmpty()
						&& this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta()).size() - indice <= this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() + indice).size()
						&& this.getTurnoAnterior().conseguirFicha() == this.getTablero().get(this.getIndexColumnaDeUltimaFichaPuesta() + indice).get(this.getIndexFilaDeUltimaFichaPuesta() - indice)).mapToDouble((each) -> 1.0).sum());

		return contadorDeFichasCuadrante2y4 >= 4;
	}
}