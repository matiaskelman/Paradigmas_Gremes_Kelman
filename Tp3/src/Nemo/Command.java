package Nemo;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Nodes.collect;

abstract class Command {
	private static List<Command> availableCommands = Arrays.asList(new CommandRigth(), new CommandLeft(), new CommandEmerge(),
			new CommandSubmerge(), new CommandRelease(), new CommandFoward());
	
	public char key;

	public static Command commandFor(char command) {
        return (Command) availableCommands
				.stream()
				.filter(c -> command == c.key);

	}

	public abstract void move(Sub submarino);
}
