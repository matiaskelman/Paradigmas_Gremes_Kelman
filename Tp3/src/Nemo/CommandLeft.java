package Nemo;

public class CommandLeft extends Command{

    {this.key = 'l';}

    @Override
    public void commandAction(Sub submarine) {
        submarine
                .setDirection(cardinalPoint
                        .getClassRelatedToSubDirection(submarine.getDirection())
                        .turnLeft()
        );
    }
}
