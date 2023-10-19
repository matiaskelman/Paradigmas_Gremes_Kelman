package Nemo;

import java.util.*;

abstract class Command {
	private List<Command> availableCommands = Arrays.asList(new CommandRigth(), new CommandLeft(), new CommandEmerge(),
			new CommandSubmerge(), new CommandRelease(), new CommandFoward());
	
	public char key;

	public static Command commandFor() {
		return null;

	}

}
