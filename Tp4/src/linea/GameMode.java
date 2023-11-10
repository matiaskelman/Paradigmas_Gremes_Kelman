package linea;

import java.util.*;
//import java.util.Arrays;
//import java.util.List;
import java.util.stream.Collectors;


public abstract class GameMode {

    private static List<GameMode> posiblesModoDeJuego = Arrays.asList(new GameMode_A(),new GameMode_B(), new GameMode_C());

    public char key;

    public abstract boolean isJuegoGanado(Linea juego);

    public static GameMode modoFor(char modo) {
        List<GameMode> modoGottenFromFilter =
                posiblesModoDeJuego.stream().filter(c -> modo == c.key).collect(Collectors.toList());

        return modoGottenFromFilter.get(0);
    }
}
