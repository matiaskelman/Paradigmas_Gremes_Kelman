package linea;

import java.util.*;
import java.util.stream.Collectors;


public abstract class GameMode {

    public static final String NO_EXISTE_ESTE_MODO_DE_JUEGO = "No existe este modo de juego";
    private static List<GameMode> posiblesModoDeJuego = Arrays.asList(new GameMode_A(),new GameMode_B(), new GameMode_C());

    public char key;

    public abstract boolean isJuegoGanado(Linea juego);

    public static GameMode modoFor(char modo) {
        List<GameMode> modoGottenFromFilter =
                posiblesModoDeJuego.stream().filter(c -> modo == c.key).collect(Collectors.toList());

        if(modoGottenFromFilter.isEmpty()){throw new RuntimeException(NO_EXISTE_ESTE_MODO_DE_JUEGO);}

        return modoGottenFromFilter.get(0);
    }
}
