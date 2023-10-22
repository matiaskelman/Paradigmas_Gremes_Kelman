package Nemo;

public class South extends cardinalPoint {

    {this.cardinalDirection = "South";}

    @Override
    public String turnRight() {return "West";}

    @Override
    public String turnLeft() {return "East";}

    @Override
    public Coordinates movementOnThePlain(Sub submarine) {return submarine.getCoordinates().moveY(-1);}
}
