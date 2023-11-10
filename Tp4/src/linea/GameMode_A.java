package linea;

import java.util.ArrayList;

public class GameMode_A extends GameMode{

    {this.key = 'A';}

    @Override
    public boolean isJuegoGanado(Linea juego) {
        int indexColumna = 0;
        while (indexColumna < juego.getCantColumnas() && !juego.getTablero().get(indexColumna).isEmpty()) {
            ArrayList<Character> column = juego.getTablero().get(indexColumna);
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
        return false;
    }
}


