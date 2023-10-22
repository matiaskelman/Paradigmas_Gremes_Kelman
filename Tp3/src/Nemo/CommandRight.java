package Nemo;

public class CommandRight extends Command {

	{this.key = 'r';}


	@Override
	public void commandAction(Sub submarine) {
		submarine
				.setDirection(cardinalPoint
						.getClassRelatedToSubDirection(submarine.getDirection())
						.turnRight()
		);
	}
}
