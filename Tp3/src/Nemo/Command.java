package Nemo;

import java.util.*;



abstract class Command {
	private static List<Command> availableCommands = Arrays.asList(new CommandRigth(), new CommandLeft(), new CommandEmerge(),
			new CommandSubmerge(), new CommandRelease(), new CommandFoward());
	
	public char key;

	public static Command accionFor(char command) {
		System.out.print(command);
        return (Command) availableCommands
				.stream()
				.filter(c -> command == c.key);

	}

	public abstract void move(Sub submarino);
}
