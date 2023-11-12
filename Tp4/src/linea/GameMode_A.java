package linea;

public class GameMode_A extends GameMode {

    {this.key = 'A';}

    @Override
    public boolean isJuegoGanado(Linea juego) {
        return juego.victoriaHorizontal() || juego.victoriaVertical();}
    }
