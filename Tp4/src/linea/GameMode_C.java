package linea;

import java.util.ArrayList;

public class GameMode_C extends GameMode{

    {this.key = 'C';}

    @Override
    public boolean isJuegoGanado(Linea juego) {
        int indexColumna = 0;
        while (indexColumna < juego.getCantColumnas() && !juego.getTablero().get(indexColumna).isEmpty()) {
            ArrayList<Character> column = juego.getTablero().get(indexColumna);
            if (column.get(column.size() - 1) == 'R') {
                int contadorDeFichasRojasVerticales = 1;
                int indexDeFichaRoja = column.size() - 2;
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
        for (int fila = 0; juego.getAltura() - 1 > fila; fila++) {
            int contadorDeFichasHorizontalesRojas = 0;
            int indexCol = 0;
            if (juego.getTablero().get(indexCol).get(fila) == 'R') {
                while (indexCol < juego.getCantColumnas() && contadorDeFichasHorizontalesRojas < 4) {
                    if (juego.getTablero().get(indexCol).get(fila) != 'R') {
                        break;
                    } else {
                        contadorDeFichasHorizontalesRojas++;
                    }
                }
                if (contadorDeFichasHorizontalesRojas == 4) {
                    return true;
                }
            }
            int contadorDeFichasHorizontalesAzules = 0;
            if (juego.getTablero().get(indexCol).get(fila) == 'A') {
                while (indexCol < juego.getCantColumnas() && contadorDeFichasHorizontalesAzules < 4) {
                    if (juego.getTablero().get(indexCol).get(fila) != 'A') {
                        break;
                    } else {
                        contadorDeFichasHorizontalesAzules++;
                    }
                }
                if (contadorDeFichasHorizontalesAzules == 4) {
                    return true;
                }
            }
        }

        int contadorDeFichasRojasOAzules = 0;
        int contadorDeFichasTotales = 0;
        int contadorDeFichasCuadrante1Y3 = 0;
        int contadorDeFichasCuadrante2Y4 = 0;
        int indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
        int indexFila = juego.getTablero().get(indexCol).size()-1;
        //primer cuadrante
        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura() > indexFila) {
            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha()) {
                contadorDeFichasRojasOAzules++;
                indexCol++;
                indexFila++;
                contadorDeFichasTotales++;
                contadorDeFichasCuadrante1Y3++;
            }

            if (contadorDeFichasRojasOAzules == 4){return true;}
            else if (contadorDeFichasCuadrante1Y3 == 4){return true;}
            else if ( contadorDeFichasTotales == 4 || indexCol == juego.getCantColumnas() || juego.getTablero().get(indexCol).isEmpty() || juego.getAltura() == indexFila || juego.getTablero().get(indexCol).size() <= juego.getTablero().get(indexCol-1).size() || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha()){
                contadorDeFichasRojasOAzules = 0;
                contadorDeFichasTotales = 0;
                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
                indexFila = juego.getTablero().get(indexCol).size()-1;
                break;
            }
        }
        //segundo cuadrante
        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura()  > indexFila) {
            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha()) {
                contadorDeFichasRojasOAzules++;
                indexCol--;
                indexFila++;
                contadorDeFichasTotales++;
                contadorDeFichasCuadrante2Y4++;
            }

            if (contadorDeFichasRojasOAzules == 4){return true;}
            else if (contadorDeFichasCuadrante2Y4 == 4){return true;}
            else if ( contadorDeFichasTotales == 4 || indexCol == -1 || juego.getTablero().get(indexCol).isEmpty() || juego.getAltura() == indexFila || juego.getTablero().get(indexCol).size() <= juego.getTablero().get(indexCol+1).size() || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha() ){
                contadorDeFichasRojasOAzules = 0;
                contadorDeFichasTotales = 0;
                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
                indexFila = juego.getTablero().get(indexCol).size()-1;
                break;
            }
        }
        //cuarto cuadrante
        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura() > indexFila) {
            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha() ) {
                contadorDeFichasRojasOAzules++;
                indexCol++;
                indexFila--;
                contadorDeFichasTotales++;
                contadorDeFichasCuadrante2Y4++;
            }

            if (contadorDeFichasRojasOAzules == 4){return true;}
            else if (contadorDeFichasCuadrante2Y4 == 4){return true;}
            else if ( contadorDeFichasTotales == 4 || indexCol == juego.getCantColumnas() || juego.getTablero().get(indexCol).isEmpty() || -1 == indexFila || juego.getTablero().get(indexCol).size() < juego.getTablero().get(indexCol-1).size()-1 || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha() ){
                contadorDeFichasRojasOAzules = 0;
                contadorDeFichasTotales = 0;
                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
                indexFila = juego.getTablero().get(indexCol).size()-1;
                break;
            }
        }
        //tercer cuadrante
        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura() > indexFila) {
            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha() ) {
                contadorDeFichasRojasOAzules++;
                indexCol--;
                indexFila--;
                contadorDeFichasTotales++;
                contadorDeFichasCuadrante1Y3++;
            }

            if (contadorDeFichasRojasOAzules == 4){return true;}
            else if (contadorDeFichasCuadrante1Y3 == 4){return true;}
            else if ( contadorDeFichasTotales == 4 || indexCol == -1 || juego.getTablero().get(indexCol).isEmpty() || - 1 == indexFila || juego.getTablero().get(indexCol).size() < juego.getTablero().get(indexCol+1).size()-1 || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha() ){
                contadorDeFichasRojasOAzules = 0;
                contadorDeFichasTotales = 0;
                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
                indexFila = juego.getTablero().get(indexCol).size()-1;
                break;
            }
        }

        return false;
    }

}
