package Nemo;

public class CommandFoward extends Command {

    {this.key = 'f';}

    @Override
    public void move(Sub submarino) {
        submarino.setCoordenadas(cardinalPoint
                        .getClassRelatedToSubDirection(submarino.getDireccion())
                        .movementOnThePlain(submarino));

        //if submarino.getDireccion() == este
        //submarino.getCoordenadas().moverX(1)

    }
}
