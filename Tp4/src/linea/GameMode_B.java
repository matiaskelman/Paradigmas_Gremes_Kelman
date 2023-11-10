package linea;

public class GameMode_B extends GameMode{

    {this.key = 'B';}

    @Override
    public boolean isJuegoGanado(Linea juego) {
        int contadorDeFichasRojas/Azules = 0;
        int contadorDeFichasTotales = 0;
        int contadorDeFichasCuadrante1Y3 = 0;
        int contadorDeFichasCuadrante2Y4 = 0;
        int indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
        int indexFila = juego.getTablero().get(indexCol).size()-1;
        //primer cuadrante
        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura() > indexFila) {
            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha()) {
                contadorDeFichasRojas/Azules++;							
                indexCol++;											
                indexFila++;										
                contadorDeFichasTotales++;
                contadorDeFichasCuadrante1Y3++;
            }

            if (contadorDeFichasRojas/Azules == 4){return true;}
            else if (contadorDeFichasCuadrante1Y3 == 4){return true;}
            else if ( contadorDeFichasTotales == 4 || indexCol == juego.getCantColumnas() || juego.getTablero().get(indexCol).isEmpty() || juego.getAltura() == indexFila || juego.getTablero().get(indexCol).size() <= juego.getTablero().get(indexCol-1).size() || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha()){
                contadorDeFichasRojas/Azules = 0;
                contadorDeFichasTotales = 0;
                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
                indexFila = juego.getTablero().get(indexCol).size()-1;
                break;
            }
        }
        //segundo cuadrante
        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura()  > indexFila) {
            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha()) {
                contadorDeFichasRojas/Azules++;
                indexCol--;
                indexFila++;
                contadorDeFichasTotales++;
                contadorDeFichasCuadrante2Y4++;
            }

            if (contadorDeFichasRojas/Azules == 4){return true;}
            else if (contadorDeFichasCuadrante2Y4 == 4){return true;}
            else if ( contadorDeFichasTotales == 4 || indexCol == -1 || juego.getTablero().get(indexCol).isEmpty() || juego.getAltura() == indexFila || juego.getTablero().get(indexCol).size() <= juego.getTablero().get(indexCol+1).size() || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha() ){
                contadorDeFichasRojas/Azules = 0;
                contadorDeFichasTotales = 0;
                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
                indexFila = juego.getTablero().get(indexCol).size()-1;
                break;
            }
        }
        //cuarto cuadrante
        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura() > indexFila) {
            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha() ) {
                contadorDeFichasRojas/Azules++;
                indexCol++;
                indexFila--;
                contadorDeFichasTotales++;
                contadorDeFichasCuadrante2Y4++;
            }

            if (contadorDeFichasRojas/Azules == 4){return true;}
            else if (contadorDeFichasCuadrante2Y4 == 4){return true;}



            else if ( contadorDeFichasTotales == 4 || indexCol == juego.getCantColumnas() || juego.getTablero().get(indexCol).isEmpty() || -1 == indexFila || juego.getTablero().get(indexCol).size() < juego.getTablero().get(indexCol-1).size()-1 || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha() ){
                contadorDeFichasRojas/Azules = 0;
                contadorDeFichasTotales = 0;
                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
                indexFila = juego.getTablero().get(indexCol).size()-1;
                break;
            }
        }
        //tercer cuadrante
        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura() > indexFila) {
            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha() ) {
                contadorDeFichasRojas/Azules++;
                indexCol--;
                indexFila--;
                contadorDeFichasTotales++;
                contadorDeFichasCuadrante1Y3++;
            }

            if (contadorDeFichasRojas/Azules == 4){return true;}
            else if (contadorDeFichasCuadrante1Y3 == 4){return true;}



            else if ( contadorDeFichasTotales == 4 || indexCol == -1 || juego.getTablero().get(indexCol).isEmpty() || - 1 == indexFila || juego.getTablero().get(indexCol).size() < juego.getTablero().get(indexCol+1).size()-1 || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha() ){
                contadorDeFichasRojas/Azules = 0;
                contadorDeFichasTotales = 0;
                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
                indexFila = juego.getTablero().get(indexCol).size()-1;
                break;
            }
        }

        return false;
    }

}
