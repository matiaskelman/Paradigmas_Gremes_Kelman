package Nemo;

public class CommandLeft extends Command{

    {this.key = 'l';}

    @Override
    public void move(Sub submarino) {
        submarino.setDireccion(cardinalPoint
                .getClassRelatedToSubDirection(submarino.getDireccion())
                .turnLeft()
        );
    }
}
