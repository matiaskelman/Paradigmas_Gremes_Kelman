package linea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GameMode_B extends GameMode{

    {this.key = 'B';}

    @Override
    public boolean isJuegoGanado(Linea juego) {return juego.victoriaDiagonalCuadrante1y3() || juego.victoriaDiagonalCuadrante2y4();}

    }
//        int indiceFilaDeUltimaFicha = juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).size() - 1;
//
//        int contadorDeFichasCuadrante1y3 = 1;
//
//        int contadorDeFichasCuadrante2y4 = 1;
//
//
//        //primer cuadrante
//        contadorDeFichasCuadrante1y3 = (int) (contadorDeFichasCuadrante1y3 + IntStream.range(1,4).takeWhile((indice) ->
//                                                               juego.getColumnaDeUltimaFichaPuesta()-1 + indice <= juego.getTablero().size() -1
//                                                            && indiceFilaDeUltimaFicha+indice <= juego.getAltura()-1
//                                                            && !juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).isEmpty()
//                                                            //&& juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1).size() < juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).size() funciona
//                                                            && juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1).size()+indice <= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).size()
//                                                            && juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).get(indiceFilaDeUltimaFicha + indice)).mapToDouble((each) -> 1.0).sum());
//
//        //tercer cuadrante
//        contadorDeFichasCuadrante1y3 = (int) (contadorDeFichasCuadrante1y3 + IntStream.range(1,4).takeWhile((indice) ->
//                   juego.getColumnaDeUltimaFichaPuesta()-1 - indice >= 0
//                && indiceFilaDeUltimaFicha-indice >= 0
//                && !juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).isEmpty()
//                && juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - indice).size()-1 <= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).size()
//                && juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).get(indiceFilaDeUltimaFicha - indice)).mapToDouble((each) -> 1.0).sum());
//
//        //segundo cuadrante
//        contadorDeFichasCuadrante2y4 = (int) (contadorDeFichasCuadrante2y4 + IntStream.range(1,4).takeWhile((indice) ->
//                            juego.getColumnaDeUltimaFichaPuesta()-1 - indice >= 0
//                        && indiceFilaDeUltimaFicha+indice <= juego.getAltura()-1
//                        && !juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1- indice).isEmpty()
//                        && juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1).size()+indice <= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).size()
//                        && juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 - indice).get(indiceFilaDeUltimaFicha + indice)).mapToDouble((each) -> 1.0).sum());
//
//        //cuarto cuadrante
//        contadorDeFichasCuadrante2y4 = (int) (contadorDeFichasCuadrante2y4 + IntStream.range(1,4).takeWhile((indice) ->
//                            juego.getColumnaDeUltimaFichaPuesta()-1 + indice <= juego.getTablero().size() -1
//                        && indiceFilaDeUltimaFicha-indice >= 0
//                        && !juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).isEmpty()
//                        && juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 ).size()-indice <= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).size()
//                        && juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()-1 + indice).get(indiceFilaDeUltimaFicha - indice)).mapToDouble((each) -> 1.0).sum());
//
//
//
//
//
//
//        if (contadorDeFichasCuadrante1y3 >= 4){return true;}
//        if (contadorDeFichasCuadrante2y4 >= 4){return true;}
//

