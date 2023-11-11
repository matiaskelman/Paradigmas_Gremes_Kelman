package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GameMode_A extends GameMode {

    {
        this.key = 'A';
    }

    @Override
    public boolean isJuegoGanado(Linea juego) {

        //AtomicBoolean estaGanado = new AtomicBoolean(false);

        int cantidadDeFichas = juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).stream()
                .filter((ficha) -> juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).indexOf(ficha) + 1 > juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).size() - 4 && ficha == juego.getTurnoAnterior().conseguirFicha())
                .mapToInt((ficha) -> 1)    //[A,R,R,R,R]
                .sum();
        if (cantidadDeFichas >= 4) {
            return true;
        }

//        juego.getTablero().stream().forEach((columna) ->{
//            AtomicInteger cantidadDeFichas = new AtomicInteger();
//            columna
//                    .stream()
//                    .sorted(Comparator.reverseOrder())
//                    .takeWhile((ficha) -> ficha == juego.getTurnoAnterior().conseguirFicha())
//                    .forEach((ficha) -> cantidadDeFichas.getAndIncrement());
//
//            if( cantidadDeFichas.get() == 4) {
//                estaGanado.set(true);}
//        });

        int indiceFilaDeUltimaFicha = juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta() - 1).size() - 1;
//        juego.getTablero().stream().takeWhile((columna) -> juego.getTablero().indexOf(columna) < juego.getColumnaDeUltimaFichaPuesta() + 2
//                        && juego.getColumnaDeUltimaFichaPuesta() - 2 < juego.getTablero().indexOf(columna)
//                        && columna.size() >= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()).size()
//                        && columna.get(indiceFilaDeUltimaFicha) == juego.getTurno().conseguirFicha())
//                .forEach((columna) -> {
//
//                });
        int cantidadDeFichass = 0;
//        IntStream.range(juego.getColumnaDeUltimaFichaPuesta(), juego.getColumnaDeUltimaFichaPuesta()+1 ).forEach((indice) -> );
//        IntStream.range(juego.getColumnaDeUltimaFichaPuesta()-1,juego.getColumnaDeUltimaFichaPuesta()-4).forEachOrdered((indice) -> {
//            if (indice >= 0 && indice <= juego.getTablero().size()-1 && juego.getTurno().conseguirFicha() == juego.getTablero().get(indice).get(indiceFilaDeUltimaFicha) ) {
//                cantidadDeFichass++;
//            }
//        });
        cantidadDeFichass = (int) (cantidadDeFichass + IntStream.range(juego.getColumnaDeUltimaFichaPuesta() - 4, juego.getColumnaDeUltimaFichaPuesta())
                        .map(i -> juego.getColumnaDeUltimaFichaPuesta() - i + juego.getColumnaDeUltimaFichaPuesta() - 4 - 1)
                        .takeWhile((indice) -> (indice >= 0)
                                && (!juego.getTablero().get(indice).isEmpty())
                                && (juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(indice).get(indiceFilaDeUltimaFicha))
                                && juego.getTablero().get(indice).size() >= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()).size()).mapToDouble((each) -> 1.0).sum());

        cantidadDeFichass = (int) (cantidadDeFichass + IntStream.range(juego.getColumnaDeUltimaFichaPuesta(), juego.getColumnaDeUltimaFichaPuesta() + 3)
                        .takeWhile((indice) -> indice <= juego.getTablero().size() - 1
                                && !juego.getTablero().get(indice).isEmpty()
                                && juego.getTurnoAnterior().conseguirFicha() == juego.getTablero().get(indice).get(indiceFilaDeUltimaFicha)
                                && juego.getTablero().get(indice).size() >= juego.getTablero().get(juego.getColumnaDeUltimaFichaPuesta()).size()).mapToDouble((each) -> 1.0).sum());

        return cantidadDeFichass >= 4;

//3-2-1-4-5-6-7
//1-2-3-4-5-6-7
        //1-2-3-4  4-1+1-1
    }
}

        //return estaGanado.get();



//        int indexColumna = 0;
//        while (indexColumna < juego.getCantColumnas() && !juego.getTablero().get(indexColumna).isEmpty()) {
//            ArrayList<Character> column = juego.getTablero().get(indexColumna);
//            if (column.get(column.size() - 1) == 'R') {
//                int contadorDeFichasRojasVerticales = 1; // [0,1,2,3]
//                int indexDeFichaRoja = column.size() - 2; // [R,R,R,R]
//                while (indexDeFichaRoja >= 0 && contadorDeFichasRojasVerticales < 4) {
//                    if (column.get(indexDeFichaRoja) != 'R') {
//                        break;
//                    } else {
//                        contadorDeFichasRojasVerticales++;
//                        indexDeFichaRoja--;
//                    }
//                    if (contadorDeFichasRojasVerticales == 4) {
//                        return true;
//                    }
//                }
//
//            }
//            if (column.get(column.size() - 1) == 'A') {
//                int contadorDeFichasAzules = 1; // [0,1,2,3]
//                int indexDeFichaAzul = column.size() - 2; // [R,R,R,R]
//                while (indexDeFichaAzul >= 0 && contadorDeFichasAzules < 4) {
//                    if (column.get(indexDeFichaAzul) != 'A') {
//                        break;
//                    } else {
//                        contadorDeFichasAzules++;
//                        indexDeFichaAzul--;
//                    }
//                    if (contadorDeFichasAzules == 4) {
//                        return true;
//                    }
//                }
//            }
//            indexColumna++;
//        }
//        //Algoritmo para horizontales
//        for (int fila = 0; juego.getAltura() - 1 > fila; fila++) {
//            int contadorDeFichasHorizontalesRojas = 0;
//            int indexCol = 0;
//            if (juego.getTablero().get(indexCol).get(fila) == 'R') {
//                while (indexCol < juego.getCantColumnas() && contadorDeFichasHorizontalesRojas < 4) {
//                    if (juego.getTablero().get(indexCol).get(fila) != 'R') {
//                        break;
//                    } else {
//                        contadorDeFichasHorizontalesRojas++;
//                    }
//                }
//                if (contadorDeFichasHorizontalesRojas == 4) {
//                    return true;
//                }
//            }
//            int contadorDeFichasHorizontalesAzules = 0;
//            if (juego.getTablero().get(indexCol).get(fila) == 'A') {
//                while (indexCol < juego.getCantColumnas() && contadorDeFichasHorizontalesAzules < 4) {
//                    if (juego.getTablero().get(indexCol).get(fila) != 'A') {
//                        break;
//                    } else {
//                        contadorDeFichasHorizontalesAzules++;
//                    }
//                }
//                if (contadorDeFichasHorizontalesAzules == 4) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//}


