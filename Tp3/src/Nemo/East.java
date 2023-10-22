package Nemo;

public class East extends cardinalPoint {

    {this.cardinalDirection = "East";}

    @Override
    public String turnRight() {return "South";}

    @Override
    public String turnLeft() {return "North";}

    @Override
    public Coordinates movementOnThePlain(Sub submarine) {return submarine.getCoordinates().moveX(1);}
}
