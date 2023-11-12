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
    public boolean isJuegoGanado(Linea juego) {
        return juego.victoriaHorizontal() || juego.victoriaVertical();}
    }



