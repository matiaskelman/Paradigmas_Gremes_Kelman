package linea;

public class TurnoAzul extends Turno{


    public char juegaRojo(){throw new RuntimeException("Rojo no puede poner fichas dos veces seguidas");}
    public char juegaAzul(){return 'A';}

//    public void cambiarTurno(){}
//
    public char conseguirFicha(){return 'A';}

    @Override
    public String gano() {
        return null;
    }

}
