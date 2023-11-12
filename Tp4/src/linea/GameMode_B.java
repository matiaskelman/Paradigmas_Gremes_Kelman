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