package Nemo;

public class West extends cardinalPoint {

    {this.cardinalDirection = "West";}

    @Override
    public String turnRight() {return "North";}

    @Override
    public String turnLeft() {return "South";}

    @Override
    public Coordinates movementOnThePlain(Sub submarine) {return submarine.getCoordinates().moveX(-1);}
}

