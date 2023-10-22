package Nemo;

public class Sub {
	private Coordinates coordinates;
	private DepthManager depth;
	private String direction;

	public Sub(Coordinates initialCoordinate, String initialDirection) {
		coordinates = initialCoordinate;
		direction = initialDirection;
        depth = new DepthManager();
    }

	public String getDirection() {return this.direction;}

	public void setDirection(String d) {this.direction = d;}

	public Coordinates getCoordinates() {return this.coordinates;}

	public void setCoordinates(Coordinates coordinates) {this.coordinates = coordinates;}

	public int getDepth() {return -depth.size();}

	public DepthManager getDepthManager() {return this.depth;}

	public void action(String commands) {
		commands
				.chars()
				.forEachOrdered(command -> actionForSingleCommand((char) command));
	}
	public void actionForSingleCommand(char command) {Command.commandFor(command).commandAction(this);}
}
