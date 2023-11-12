package linea;

public abstract class Turno {

    public abstract char juegaRojo();
    public abstract char juegaAzul();


    public abstract char conseguirFicha();
   public abstract String getTurno();

    public abstract boolean gano(Linea juego);

}
