package linea;

public class TurnoAzul extends Turno{

    public static final String ROJO_NO_PUEDE_PONER_FICHAS_DOS_VECES_SEGUIDAS = "Rojo no puede poner fichas dos veces seguidas";

    public char juegaRojo(){throw new RuntimeException(ROJO_NO_PUEDE_PONER_FICHAS_DOS_VECES_SEGUIDAS);}
    
    public char juegaAzul(){return 'A';}
    
    public char conseguirFicha(){return 'A';}
    
    public String getTurno(String ganador) {
        return "Es turno del Azul";
    }
}
