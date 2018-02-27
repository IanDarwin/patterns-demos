package behavioral.bidpay;

import java.util.List;

/**
 * A CompositeCommand bundles multiple other Commands inside it.
 * It both is-a Command and has-a (list of) Command.
 */
class CompositeCommand implements Command {
	List<Command> commands;
	public CompositeCommand(List<Command> commands) {
		this.commands = commands;
	}
	public void execute() {
		commands.forEach(Command::execute);
	}
}
