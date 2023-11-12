package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GameMode_A extends GameMode {

    {this.key = 'A';}

    @Override
    public boolean isJuegoGanado(Linea juego) {return juego.victoriaHorizontal() || juego.victoriaVertical();}

    }

//        int cantidadDeFichas = juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).stream()
//                .filter((ficha) -> juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).indexOf(ficha) + 1 > juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).size() - 4 && ficha == juego.getTurnoAnterior().conseguirFicha())
//                .mapToInt((ficha) -> 1)    //[A,R,R,R,R]
//                .sum();
//        if (cantidadDeFichas >= 4) {
//            return true;
//        }
//
//        int indiceFilaDeUltimaFicha = juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).size() - 1;
//
//        int cantidadDeFichass = 0;
//
//        cantidadDeFichass = (int) (cantidadDeFichass + IntStream.range(juego.getColumnaDeUltimaFichaPuesta() - 4, juego.getColumnaDeUltimaFichaPuesta())
//                        .map(i -> juego.getColumnaDeUltimaFichaPuesta() - i + juego.getColumnaDeUltimaFichaPuesta() - 4 - 1)
//                        .takeWhile((indice) -> (indice >= 0)
//                                && (!juego.getTablero().get(indice).isEmpty())
//                                && (juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(indice).get(indiceFilaDeUltimaFicha))
//                                && juego.getTablero().get(indice).size() >= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()).size()).mapToDouble((each) -> 1.0).sum());
//
//        cantidadDeFichass = (int) (cantidadDeFichass + IntStream.range(juego.getColumnaDeUltimaFichaPuesta(), juego.getColumnaDeUltimaFichaPuesta() + 3)
//                        .takeWhile((indice) -> indice <= juego.getTablero().size() - 1
//                                && !juego.getTablero().get(indice).isEmpty()
//                                && juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(indice).get(indiceFilaDeUltimaFicha)
//                                && juego.getTablero().get(indice).size() >= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()).size()).mapToDouble((each) -> 1.0).sum());
//
//        return cantidadDeFichass >= 4;



