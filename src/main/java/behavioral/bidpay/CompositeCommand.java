package behavioral.bidpay;

import java.util.List;

class CompositeCommand {
	List<Command> commands;
	public CompositeCommand(List<Command> commands) {
		this.commands = commands;
	}
	public void execute() {
		commands.forEach(Command::execute);
	}
}
