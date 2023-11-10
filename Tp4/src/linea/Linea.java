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

	public Turno getTurnoAnterior() {return turnoAnterior;}

	public List<ArrayList<Character>> getTablero(){return this.tablero;}

	public GameMode getGameMode() {
		return gameMode;
	}

	public void agregarRojoEnColumna(int columna) {
		tablero.get(columna-1).add(turno.juegaRojo());
		this.turno = new TurnoAzul();
		this.turnoAnterior = new TurnoRojo();
		this.columnaDeUltimaFichaPuesta = columna;

	}

	public int getColumnaDeUltimaFichaPuesta(){return columnaDeUltimaFichaPuesta;}

	public void agregarAzulEnColumna(int columna) {
		tablero.get(columna-1).add(turno.juegaAzul());
		this.turno = new TurnoRojo();
		this.turnoAnterior = new TurnoAzul();
		this.columnaDeUltimaFichaPuesta = columna;
	}

	public Turno getTurno(){return turno;}

	public boolean show() {

		return true;
	}

	public boolean finished() {
		return gameMode.isJuegoGanado(this);
	}
//		if (gameMode == 'A') {
//			int indexColumna = 0;
//				while (indexColumna < this.getCantColumnas() && !tablero.get(indexColumna).isEmpty()) {
//					ArrayList<Character> column = tablero.get(indexColumna);
//					if (column.get(column.size() - 1) == 'R') {
//						int contadorDeFichasRojasVerticales = 1; // [0,1,2,3]
//						int indexDeFichaRoja = column.size() - 2; // [R,R,R,R]
//						while (indexDeFichaRoja >= 0 && contadorDeFichasRojasVerticales < 4) {
//							if (column.get(indexDeFichaRoja) != 'R') {
//								break;
//							} else {
//								contadorDeFichasRojasVerticales++;
//								indexDeFichaRoja--;
//							}
//							if (contadorDeFichasRojasVerticales == 4) {
////								turno = new TurnoTerminado();
//								return true;
//							}
//						}
//
//					}
//					if (column.get(column.size() - 1) == 'A') {
//						int contadorDeFichasAzules = 1; // [0,1,2,3]
//						int indexDeFichaAzul = column.size() - 2; // [R,R,R,R]
//						while (indexDeFichaAzul >= 0 && contadorDeFichasAzules < 4) {
//							if (column.get(indexDeFichaAzul) != 'A') {
//								break;
//							} else {
//								contadorDeFichasAzules++;
//								indexDeFichaAzul--;
//							}
//							if (contadorDeFichasAzules == 4) {
//								return true;
//							}
//						}
//					}
//					indexColumna++;
//				}
//			//Algoritmo para horizontales
//			for (int fila = 0; altura-1 > fila; fila++){
//				int contadorDeFichasHorizontalesRojas = 0;
//				int indexCol = 0;
//				if(tablero.get(indexCol).get(fila) == 'R') {
//					while ( indexCol < this.getCantColumnas() && contadorDeFichasHorizontalesRojas < 4){
//						if(tablero.get(indexCol).get(fila) != 'R'){break;}
//						else{contadorDeFichasHorizontalesRojas++;}
//					}
//					if(contadorDeFichasHorizontalesRojas == 4){return true;}
//				}
//				int contadorDeFichasHorizontalesAzules = 0;
//				if(tablero.get(indexCol).get(fila) == 'A') {
//					while ( indexCol < this.getCantColumnas() && contadorDeFichasHorizontalesAzules < 4){
//						if(tablero.get(indexCol).get(fila) != 'A'){break;}
//						else{contadorDeFichasHorizontalesAzules++;}
//					}
//					if(contadorDeFichasHorizontalesAzules == 4){return true;}
//				}
//			}
//		}
//		if(this.gameMode == 'B'){
//			int contadorDeFichasRojas = 0;
//			int contadorDeFichasAzules = 0;
//			int contadorDeFichasTotales = 0;
//			int indexCol = this.columnaDeUltimaFichaPuesta-1;
//			int indexFila = tablero.get(indexCol).size()-1;
//			//primer cuadrante
//			while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura > indexFila) {
//				if (tablero.get(indexCol).get(indexFila) == 'R') {
//					contadorDeFichasRojas++;							//	  o   o			X
//					indexCol++;											//		X		      X
//					indexFila++;										//    0   o				O
//					contadorDeFichasTotales++;							//						 X
//				} else if (tablero.get(indexCol).get(indexFila) == 'A') {
//					contadorDeFichasAzules++;
//					indexCol++;
//					indexFila++;
//					contadorDeFichasTotales++;
//				}
//				if (contadorDeFichasRojas == 4){return true;}
//
//				else if (contadorDeFichasAzules == 4){return true;}
//
//				else if (contadorDeFichasTotales == 4 || indexCol == this.getCantColumnas() || tablero.get(indexCol).isEmpty() || altura == indexFila || tablero.get(indexCol).size() <= tablero.get(indexCol-1).size() ){
//					contadorDeFichasRojas = 0;
//					contadorDeFichasAzules = 0;
//					contadorDeFichasTotales = 0;
//					indexCol = this.columnaDeUltimaFichaPuesta-1;
//					indexFila = tablero.get(indexCol).size()-1;
//					break;
//				}
//			}
//			//segundo cuadrante
//			while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura  > indexFila) {
//				if (tablero.get(indexCol).get(indexFila) == 'R') {
//					contadorDeFichasRojas++;
//					indexCol--;
//					indexFila++;
//					contadorDeFichasTotales++;
//				} else if (tablero.get(indexCol).get(indexFila) == 'A') {
//					contadorDeFichasAzules++;
//					indexCol--;
//					indexFila++;
//					contadorDeFichasTotales++;
//				}
//				if (contadorDeFichasRojas == 4){return true;}
//
//				else if (contadorDeFichasAzules == 4){return true;}
//
//				else if (contadorDeFichasTotales == 4 || indexCol == -1 || tablero.get(indexCol).isEmpty() || altura == indexFila || tablero.get(indexCol).size() <= tablero.get(indexCol+1).size() ){
//					contadorDeFichasRojas = 0;
//					contadorDeFichasAzules = 0;
//					contadorDeFichasTotales = 0;
//					indexCol = this.columnaDeUltimaFichaPuesta-1;
//					indexFila = tablero.get(indexCol).size()-1;
//					break;
//				}
//			}
//			//cuarto cuadrante
//			while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura > indexFila) {
//				if (tablero.get(indexCol).get(indexFila) == 'R') {
//					contadorDeFichasRojas++;
//					indexCol++;
//					indexFila--;
//					contadorDeFichasTotales++;
//				} else if (tablero.get(indexCol).get(indexFila) == 'A') {
//					contadorDeFichasAzules++;
//					indexCol++;
//					indexFila--;
//					contadorDeFichasTotales++;
//				}
//				if (contadorDeFichasRojas == 4){return true;}
//
//				else if (contadorDeFichasAzules == 4){return true;}
//
//				else if (contadorDeFichasTotales == 4 || indexCol == this.getCantColumnas() || tablero.get(indexCol).isEmpty() || -1 == indexFila || tablero.get(indexCol).size() < tablero.get(indexCol-1).size()-1 ){
//					contadorDeFichasRojas = 0;
//					contadorDeFichasAzules = 0;
//					contadorDeFichasTotales = 0;
//					indexCol = this.columnaDeUltimaFichaPuesta-1;
//					indexFila = tablero.get(indexCol).size()-1;
//					break;
//				}
//			}
//			//tercer cuadrante
//			while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura > indexFila) {
//				if (tablero.get(indexCol).get(indexFila) == 'R') {
//					contadorDeFichasRojas++;
//					indexCol--;
//					indexFila--;
//					contadorDeFichasTotales++;
//				} else if (tablero.get(indexCol).get(indexFila) == 'A') {
//					contadorDeFichasAzules++;
//					indexCol--;
//					indexFila--;
//					contadorDeFichasTotales++;
//				}
//				if (contadorDeFichasRojas == 4){return true;}
//
//				else if (contadorDeFichasAzules == 4){return true;}
//
//				else if (contadorDeFichasTotales == 4 || indexCol == -1 || tablero.get(indexCol).isEmpty() || - 1 == indexFila || tablero.get(indexCol).size() < tablero.get(indexCol+1).size()-1 ){
//					contadorDeFichasRojas = 0;
//					contadorDeFichasAzules = 0;
//					contadorDeFichasTotales = 0;
//					indexCol = this.columnaDeUltimaFichaPuesta;
//					indexFila = tablero.get(indexCol).size()-1;
//					break;
//				}
//			}
//
//		}
//		return false;
//	}
}

//[[R(1,1),R(2,1)][B][][]]