package linea;

public class TurnoTerminado extends Turno{


    public char juegaRojo(){throw new RuntimeException("El juego ya ha terminado");}
    public char juegaAzul(){throw new RuntimeException("El juego ya ha terminado");}


     public char conseguirFicha(){return 'N';}
     public String getTurno() {
         return "Juego terminado";
     }
    @Override
    public boolean gano(Linea juego) {
        return false;
    }

}
