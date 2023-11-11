package linea;

public class TurnoTerminado extends Turno{


    public char juegaRojo(){throw new RuntimeException("El juego ya ha terminado");}
    public char juegaAzul(){throw new RuntimeException("El juego ya ha terminado");}

//    public void cambiarTurno();
//
     public char conseguirFicha(){return 'N';}

    @Override
    public String gano() {
        return null;
    }

}
