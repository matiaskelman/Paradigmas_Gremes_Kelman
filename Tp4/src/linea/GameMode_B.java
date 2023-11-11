package linea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GameMode_B extends GameMode{

    {this.key = 'B';}

    @Override
    public boolean isJuegoGanado(Linea juego) {

        int indiceFilaDeUltimaFicha = juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).size() - 1;

        int contadorDeFichasCuadrante1y3 = 1;

        int contadorDeFichasCuadrante2y4 = 1;


        //primer cuadrante
        contadorDeFichasCuadrante1y3 = (int) (contadorDeFichasCuadrante1y3 + IntStream.range(1,4).takeWhile((indice) ->
                                                               juego.getColumnaDeUltimaFichaPuesta()-1 + indice <= juego.getTablero().size() -1
                                                            && indiceFilaDeUltimaFicha+indice <= juego.getAltura()-1
                                                            && !juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).isEmpty()
                                                            //&& juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1).size() < juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).size() funciona
                                                            && juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1).size()+indice <= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).size()
                                                            && juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).get(indiceFilaDeUltimaFicha + indice)).mapToDouble((each) -> 1.0).sum());

        //tercer cuadrante
        contadorDeFichasCuadrante1y3 = (int) (contadorDeFichasCuadrante1y3 + IntStream.range(1,4).takeWhile((indice) ->
                   juego.getColumnaDeUltimaFichaPuesta()-1 - indice >= 0
                && indiceFilaDeUltimaFicha-indice >= 0
                && !juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).isEmpty()
                && juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - indice).size()-1 <= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).size()
                && juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).get(indiceFilaDeUltimaFicha - indice)).mapToDouble((each) -> 1.0).sum());

        //segundo cuadrante
        contadorDeFichasCuadrante2y4 = (int) (contadorDeFichasCuadrante2y4 + IntStream.range(1,4).takeWhile((indice) ->
                            juego.getColumnaDeUltimaFichaPuesta()-1 - indice >= 0
                        && indiceFilaDeUltimaFicha+indice <= juego.getAltura()-1
                        && !juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1- indice).isEmpty()
                        && juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1).size()+indice <= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).size()
                        && juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).get(indiceFilaDeUltimaFicha + indice)).mapToDouble((each) -> 1.0).sum());






        if (contadorDeFichasCuadrante1y3 >= 4){return true;}




//        int contadorDeFichasRojasOAzules = 0;
//        int contadorDeFichasTotales = 0;
//        int contadorDeFichasCuadrante1Y3 = 0;
//        int contadorDeFichasCuadrante2Y4 = 0;
//        int indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
//        int indexFila = juego.getTablero().get(indexCol).size()-1;
//        //primer cuadrante
//        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura() > indexFila) {
//            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha()) {
//                contadorDeFichasRojasOAzules++;
//                indexCol++;
//                indexFila++;
//                contadorDeFichasTotales++;
//                contadorDeFichasCuadrante1Y3++;
//            }
//
//            if (contadorDeFichasRojasOAzules == 4){return true;}
//            else if (contadorDeFichasCuadrante1Y3 == 4){return true;}
//            else if ( contadorDeFichasTotales == 4 || indexCol == juego.getCantColumnas() || juego.getTablero().get(indexCol).isEmpty() || juego.getAltura() == indexFila || juego.getTablero().get(indexCol).size() <= juego.getTablero().get(indexCol-1).size() || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha()){
//                contadorDeFichasRojasOAzules = 0;
//                contadorDeFichasTotales = 0;
//                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
//                indexFila = juego.getTablero().get(indexCol).size()-1;
//                break;
//            }
//        }
//        //segundo cuadrante
//        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura()  > indexFila) {
//            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha()) {
//                contadorDeFichasRojasOAzules++;
//                indexCol--;
//                indexFila++;
//                contadorDeFichasTotales++;
//                contadorDeFichasCuadrante2Y4++;
//            }
//
//            if (contadorDeFichasRojasOAzules == 4){return true;}
//            else if (contadorDeFichasCuadrante2Y4 == 4){return true;}
//            else if ( contadorDeFichasTotales == 4 || indexCol == -1 || juego.getTablero().get(indexCol).isEmpty() || juego.getAltura() == indexFila || juego.getTablero().get(indexCol).size() <= juego.getTablero().get(indexCol+1).size() || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha() ){
//                contadorDeFichasRojasOAzules = 0;
//                contadorDeFichasTotales = 0;
//                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
//                indexFila = juego.getTablero().get(indexCol).size()-1;
//                break;
//            }
//        }
//        //cuarto cuadrante
//        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura() > indexFila) {
//            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha() ) {
//                contadorDeFichasRojasOAzules++;
//                indexCol++;
//                indexFila--;
//                contadorDeFichasTotales++;
//                contadorDeFichasCuadrante2Y4++;
//            }
//
//            if (contadorDeFichasRojasOAzules == 4){return true;}
//            else if (contadorDeFichasCuadrante2Y4 == 4){return true;}
//
//
//
//            else if ( contadorDeFichasTotales == 4 || indexCol == juego.getCantColumnas() || juego.getTablero().get(indexCol).isEmpty() || -1 == indexFila || juego.getTablero().get(indexCol).size() < juego.getTablero().get(indexCol-1).size()-1 || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha() ){
//                contadorDeFichasRojasOAzules = 0;
//                contadorDeFichasTotales = 0;
//                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
//                indexFila = juego.getTablero().get(indexCol).size()-1;
//                break;
//            }
//        }
//        //tercer cuadrante
//        while (indexCol < juego.getCantColumnas() && !juego.getTablero().get(indexCol).isEmpty() && juego.getAltura() > indexFila) {
//            if (juego.getTablero().get(indexCol).get(indexFila) == juego.getTurnoAnterior().conseguirFicha() ) {
//                contadorDeFichasRojasOAzules++;
//                indexCol--;
//                indexFila--;
//                contadorDeFichasTotales++;
//                contadorDeFichasCuadrante1Y3++;
//            }
//
//            if (contadorDeFichasRojasOAzules == 4){return true;}
//            else if (contadorDeFichasCuadrante1Y3 == 4){return true;}
//
//
//
//            else if ( contadorDeFichasTotales == 4 || indexCol == -1 || juego.getTablero().get(indexCol).isEmpty() || - 1 == indexFila || juego.getTablero().get(indexCol).size() < juego.getTablero().get(indexCol+1).size()-1 || juego.getTablero().get(indexCol).get(indexFila) != juego.getTurnoAnterior().conseguirFicha() ){
//                contadorDeFichasRojasOAzules = 0;
//                contadorDeFichasTotales = 0;
//                indexCol = juego.getColumnaDeUltimaFichaPuesta()-1;
//                indexFila = juego.getTablero().get(indexCol).size()-1;
//                break;
//            }
//        }
//
        return false;
    }

}
