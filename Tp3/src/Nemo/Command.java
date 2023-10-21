package Nemo;

import java.util.*;
import java.util.stream.Collectors;


abstract class Command {
	private static List<Command> availableCommands = Arrays.asList(new CommandRigth(), new CommandLeft(), new CommandEmerge(),
			new CommandSubmerge(), new CommandRelease(), new CommandFoward());
	
	public char key;

	public static Command commandFor(char command) {
		System.out.print(command);
		List<Command> commandGottenFromFilter =
				availableCommands
						.stream()
						.filter(c -> command == c.key)
						.collect(Collectors.toList());
		return commandGottenFromFilter.get(0);
	}

	public abstract void move(Sub submarino);
}
