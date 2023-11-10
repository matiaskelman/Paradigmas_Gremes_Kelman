package linea;

import java.util.ArrayList;
import java.util.List;

public class Linea {

	private char gameMode;
	private int altura;
	private String turno;
	private int columnaDeUltimaFichaPuesta;
	List<ArrayList<Character>> tablero;

	public Linea(int columnas, int altura, char gameMode) {
		this.tablero = new ArrayList<>();
		for (int i = columnas; i > 0; i--) {
			tablero.add(new ArrayList<Character>());
		}
		this.altura = altura;
		this.gameMode = gameMode;
		this.turno = "Rojo";

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
		if(turno.equals("Rojo")){
			tablero.get(columna-1).add('R');
			this.turno = "Azul";
			this.columnaDeUltimaFichaPuesta = columna;
		}
		else {
			throw new RuntimeException("Rojo no puede poner fichas dos veces seguidas");
		}
	}

	public void agregarAzulEnColumna(int columna) {
		if(turno.equals("Azul")){
			tablero.get(columna-1).add('A');
			this.turno = "Rojo";
			this.columnaDeUltimaFichaPuesta = columna;
		}
		else {
			throw new RuntimeException("Azul no puede poner fichas dos veces seguidas");
		}
	}

	public boolean show() {

		return true;
	}

	public boolean finished() {
		if (gameMode == 'A') {
			int indexColumna = 0;
				while (indexColumna < this.getCantColumnas() && !tablero.get(indexColumna).isEmpty()) {
					ArrayList<Character> column = tablero.get(indexColumna);
					if (column.get(column.size() - 1) == 'R') {
						int contadorDeFichasRojasVerticales = 1; // [0,1,2,3]
						int indexDeFichaRoja = column.size() - 2; // [R,R,R,R]
						while (indexDeFichaRoja >= 0 && contadorDeFichasRojasVerticales < 4) {
							if (column.get(indexDeFichaRoja) != 'R') {
								break;
							} else {
								contadorDeFichasRojasVerticales++;
								indexDeFichaRoja--;
							}
							if (contadorDeFichasRojasVerticales == 4) {
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
					indexColumna++;
				}
			//Algoritmo para horizontales
			for (int fila = 0; altura-1 > fila; fila++){
				int contadorDeFichasHorizontalesRojas = 0;
				int indexCol = 0;
				if(tablero.get(indexCol).get(fila) == 'R') {
					while ( indexCol < this.getCantColumnas() && contadorDeFichasHorizontalesRojas < 4){
						if(tablero.get(indexCol).get(fila) != 'R'){break;}
						else{contadorDeFichasHorizontalesRojas++;}
					}
					if(contadorDeFichasHorizontalesRojas == 4){return true;}
				}
				int contadorDeFichasHorizontalesAzules = 0;
				if(tablero.get(indexCol).get(fila) == 'A') {
					while ( indexCol < this.getCantColumnas() && contadorDeFichasHorizontalesAzules < 4){
						if(tablero.get(indexCol).get(fila) != 'A'){break;}
						else{contadorDeFichasHorizontalesAzules++;}
					}
					if(contadorDeFichasHorizontalesAzules == 4){return true;}
				}
//			tablero.stream().forEach((columna) -> {if( columna.get(finalFila) == 'R'){}
//			});
//			//int contadorDeFichasHorizontalesRojas = (int) tablero.stream().filter(columna -> columna.get(finalFila) == 'R').count();
//			if (contadorDeFichasHorizontalesRojas == 4){return true;}
//			int contadorDeFichasHorizontalesAzules = (int) tablero.stream().filter(columna -> columna.get(finalFila) == 'A').count();
//			if (contadorDeFichasHorizontalesAzules == 4){return true;}
			}
		}
		if(this.gameMode == 'B'){
//			int aumentoEnX=0;
//			int aumentoEnY=0;
//			while(aumentoEnX < this.getCantColumnas() && !tablero.get(aumentoEnX).isEmpty() && altura-1 > aumentoEnY) {
//				int contadorFichasRojas = 0;
//				int indexCol = 0 + aumentoEnX;
//				int indexFila = 0 + aumentoEnY;
//				while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura - 1 > indexFila) {
//					//for (int indexCol = 0, aumentoEnY = 0;indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura-1 > aumentoEnY;aumentoEnY++,indexCol++){
//					if (tablero.get(indexCol).get(indexFila) == 'R') {
//						contadorFichasRojas++;
//						indexFila++;
//						indexCol++;
//					}
//					else {
//						aumentoEnX++;
//						break;}
//				}
//				//for (int indexCol = 0, indexFila = 0; indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura - 1 > indexFila; indexFila++, indexCol++) {
//				//	if (tablero.get(indexCol).get(indexFila) == 'A') {
//				//		contadorFichasRojas++;
//				//	} else {
//				//		break;
//				//	}
//				//}
//			}
//			while(aumentoEnX > 0 && !tablero.get(aumentoEnX).isEmpty() && altura-1 > aumentoEnY) {
//				int contadorFichasRojas = 0;
//				int indexCol = 0 + aumentoEnX;
//				int indexFila = 0 + aumentoEnY;
//				while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura - 1 > indexFila) {
//					//for (int indexCol = 0, aumentoEnY = 0;indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura-1 > aumentoEnY;aumentoEnY++,indexCol++){
//					if (tablero.get(indexCol).get(indexFila) == 'R') {
//						contadorFichasRojas++;
//						indexFila++;
//						indexCol++;
//					}
//					else {
//						aumentoEnX--;
//						aumentoEnY++;
//						break;}
//				}
//			}
			int contadorDeFichasRojas = 0;
			int contadorDeFichasAzules = 0;
			int contadorDeFichasTotales = 0;
			int indexCol = this.columnaDeUltimaFichaPuesta-1;
			int indexFila = tablero.get(indexCol).size()-1;
			//primer cuadrante
			while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura > indexFila) {
				if (tablero.get(indexCol).get(indexFila) == 'R') {
					contadorDeFichasRojas++;
					indexCol++;
					indexFila++;
					contadorDeFichasTotales++;
				} else if (tablero.get(indexCol).get(indexFila) == 'A') {
					contadorDeFichasAzules++;
					indexCol++;
					indexFila++;
					contadorDeFichasTotales++;
				}
				if (contadorDeFichasRojas == 4){return true;}

				else if (contadorDeFichasAzules == 4){return true;}

				else if (contadorDeFichasTotales == 4 || indexCol == this.getCantColumnas() || tablero.get(indexCol).isEmpty() || altura == indexFila || tablero.get(indexCol).size() <= tablero.get(indexCol-1).size() ){
					contadorDeFichasRojas = 0;
					contadorDeFichasAzules = 0;
					contadorDeFichasTotales = 0;
					indexCol = this.columnaDeUltimaFichaPuesta-1;
					indexFila = tablero.get(indexCol).size()-1;
					break;
				}
			}
			//segundo cuadrante
			while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura  > indexFila) {
				if (tablero.get(indexCol).get(indexFila) == 'R') {
					contadorDeFichasRojas++;
					indexCol--;
					indexFila++;
					contadorDeFichasTotales++;
				} else if (tablero.get(indexCol).get(indexFila) == 'A') {
					contadorDeFichasAzules++;
					indexCol--;
					indexFila++;
					contadorDeFichasTotales++;
				}
				if (contadorDeFichasRojas == 4){return true;}

				else if (contadorDeFichasAzules == 4){return true;}

				else if (contadorDeFichasTotales == 4 || indexCol == -1 || tablero.get(indexCol).isEmpty() || altura == indexFila || tablero.get(indexCol).size() <= tablero.get(indexCol+1).size() ){
					contadorDeFichasRojas = 0;
					contadorDeFichasAzules = 0;
					contadorDeFichasTotales = 0;
					indexCol = this.columnaDeUltimaFichaPuesta-1;
					indexFila = tablero.get(indexCol).size()-1;
					break;
				}
			}
			//cuarto cuadrante
			while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura > indexFila) {
				if (tablero.get(indexCol).get(indexFila) == 'R') {
					contadorDeFichasRojas++;
					indexCol++;
					indexFila--;
					contadorDeFichasTotales++;
				} else if (tablero.get(indexCol).get(indexFila) == 'A') {
					contadorDeFichasAzules++;
					indexCol++;
					indexFila--;
					contadorDeFichasTotales++;
				}
				if (contadorDeFichasRojas == 4){return true;}

				else if (contadorDeFichasAzules == 4){return true;}

				else if (contadorDeFichasTotales == 4 || indexCol == this.getCantColumnas() || tablero.get(indexCol).isEmpty() || -1 == indexFila || tablero.get(indexCol).size() < tablero.get(indexCol-1).size()-1 ){
					contadorDeFichasRojas = 0;
					contadorDeFichasAzules = 0;
					contadorDeFichasTotales = 0;
					indexCol = this.columnaDeUltimaFichaPuesta-1;
					indexFila = tablero.get(indexCol).size()-1;
					break;
				}
			}
			//tercer cuadrante
			while (indexCol < this.getCantColumnas() && !tablero.get(indexCol).isEmpty() && altura > indexFila) {
				if (tablero.get(indexCol).get(indexFila) == 'R') {
					contadorDeFichasRojas++;
					indexCol--;
					indexFila--;
					contadorDeFichasTotales++;
				} else if (tablero.get(indexCol).get(indexFila) == 'A') {
					contadorDeFichasAzules++;
					indexCol--;
					indexFila--;
					contadorDeFichasTotales++;
				}
				if (contadorDeFichasRojas == 4){return true;}

				else if (contadorDeFichasAzules == 4){return true;}

				else if (contadorDeFichasTotales == 4 || indexCol == -1 || tablero.get(indexCol).isEmpty() || - 1 == indexFila || tablero.get(indexCol).size() < tablero.get(indexCol+1).size()-1 ){
					contadorDeFichasRojas = 0;
					contadorDeFichasAzules = 0;
					contadorDeFichasTotales = 0;
					indexCol = this.columnaDeUltimaFichaPuesta;
					indexFila = tablero.get(indexCol).size()-1;
					break;
				}
			}

		}
		return false;
	}
}

//[[R(1,1),R(2,1)][B][][]]