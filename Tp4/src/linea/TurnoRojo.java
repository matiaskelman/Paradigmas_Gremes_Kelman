package linea;

public class TurnoRojo extends Turno{


    public char juegaRojo(){
        return 'R';
    }
    public char juegaAzul(){
        throw new RuntimeException("Azul no puede poner fichas dos veces seguidas");
    }

//    public void cambiarTurno();
//
    public char conseguirFicha(){return 'R';}

    @Override
    public boolean gano(Linea juego) {
        juego.setGanoRojo(true);
        return juego.getGameMode().isJuegoGanado(juego);
    }

}

