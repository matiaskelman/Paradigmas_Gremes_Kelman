package linea;

public class GameMode_C extends GameMode {

    {this.key = 'C';}

    @Override
    public boolean isJuegoGanado(Linea juego) {return juego.victoriaVertical() || juego.victoriaHorizontal() || juego.victoriaDiagonalCuadrante1y3() || juego.victoriaDiagonalCuadrante2y4();}
}
