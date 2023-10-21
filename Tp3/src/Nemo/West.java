package Nemo;

public class West extends cardinalPoint {

    {this.cardinalDirection = "West";}

    @Override
    public String turnRight() {
        return "North";
    }

    @Override
    public String turnLeft() {
        return "South";
    }

    @Override
    public Coordenadas movementOnThePlain(Sub submarino) {
        return submarino.getCoordenadas().moverX(-1);
    }
}

