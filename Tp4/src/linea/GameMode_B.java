package linea;

public class GameMode_B extends GameMode{

    {this.key = 'B';}

    @Override
    public boolean isJuegoGanado(Linea juego) {return juego.victoriaDiagonalCuadrante1y3() || juego.victoriaDiagonalCuadrante2y4();}
    }
