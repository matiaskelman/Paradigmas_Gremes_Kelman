package linea;

public class TurnoTerminado extends Turno{

    public static final String JUEGO_YA_HA_TERMINADO = "El juego ya ha terminado";

    public char juegaRojo(){throw new RuntimeException(JUEGO_YA_HA_TERMINADO);}
    
    public char juegaAzul(){throw new RuntimeException(JUEGO_YA_HA_TERMINADO);}
   
    public char conseguirFicha(){return 'N';}
    
    public String getTurno(String ganador) {
        return ganador;
    }
}
