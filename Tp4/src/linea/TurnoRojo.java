package linea;

public class TurnoRojo extends Turno{

    public static final String AZUL_NO_PUEDE_PONER_FICHAS_DOS_VECES_SEGUIDAS = "Azul no puede poner fichas dos veces seguidas";

    public char juegaRojo(){
        return 'R';
    }
    
    public char juegaAzul(){
        throw new RuntimeException(AZUL_NO_PUEDE_PONER_FICHAS_DOS_VECES_SEGUIDAS);
    }

    public char conseguirFicha(){return 'R';}
    
    public String getTurno(String ganador) {
        return "Es turno del Rojo";
    }
}

