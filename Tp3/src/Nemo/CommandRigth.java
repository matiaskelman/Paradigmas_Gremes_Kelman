package Nemo;

public class CommandRigth extends Command {

	{this.key = 'r';}


	@Override
	public void move(Sub submarino) {
		submarino.setDireccion(cardinalPoint
				.getClassRelatedToSubDirection(submarino.getDireccion())
				.turnRight()
		);
	}
}
