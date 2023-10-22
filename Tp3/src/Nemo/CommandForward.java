package Nemo;

public class CommandForward extends Command {

    {this.key = 'f';}

    @Override
    public void commandAction(Sub submarine) {
        submarine.setCoordinates(cardinalPoint
                        .getClassRelatedToSubDirection(submarine.getDirection())
                        .movementOnThePlain(submarine));
    }
}
