package Nemo;

public class South extends cardinalPoint {

    {this.cardinalDirection = "South";}

    @Override
    public String turnRight() {
        return "West";
    }

    @Override
    public String turnLeft() {
        return "East";
    }

    @Override
    public Coordenadas movementOnThePlain(Sub submarino) {
        return submarino.getCoordenadas().moverY(-1);
    }
}
