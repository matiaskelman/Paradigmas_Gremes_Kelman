package Nemo;

public class East extends cardinalPoint {

    {this.cardinalDirection = "East";}

    @Override
    public String turnRight() {
        return "South";
    }

    @Override
    public String turnLeft() {
        return "North";
    }

    @Override
    public Coordenadas movementOnThePlain(Sub submarino) {
        return submarino.getCoordenadas().moverX(1);
    }
}
