package linea;

public class TurnoAzul extends Turno{


    public char juegaRojo(){throw new RuntimeException("Rojo no puede poner fichas dos veces seguidas");}
    public char juegaAzul(){return 'A';}


    public char conseguirFicha(){return 'A';}
    public String getTurno() {
        return "Es turno del Azul";
    }
    @Override
    public boolean gano(Linea juego) {
        return false;
    }

}
