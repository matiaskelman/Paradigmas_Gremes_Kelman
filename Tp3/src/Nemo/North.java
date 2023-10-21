package Nemo;

public class North extends cardinalPoint {

    {this.cardinalDirection = "North";}

    @Override
    public String turnRight() {
        return "East";
    }

    @Override
    public String turnLeft() {
        return "West";
    }

    @Override
    public Coordenadas movementOnThePlain(Sub submarino) {
        return submarino.getCoordenadas().moverY(1);
    }
}
