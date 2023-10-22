package Nemo;

public class North extends cardinalPoint {

    {this.cardinalDirection = "North";}

    @Override
    public String turnRight() {return "East";}

    @Override
    public String turnLeft() {return "West";}

    @Override
    public Coordinates movementOnThePlain(Sub submarine) {return submarine.getCoordinates().moveY(1);}
}
