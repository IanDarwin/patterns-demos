package behavioral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A simple demo of using a State machine implemented as Java classes.
 * A text-mode game, and, not intended to be a full RPG game, sorry,
 * but at the beginning of (computer) time, the only games were text games
 * like Crowley's Adventure and later, Michael Toy's curses-based Rogue.
 * This is NOT the only way to implement state machines;
 * they have been done for years in many languages as
 * e.g., transition tables of integers, pointers to structures, etc.
 */
public class GameStateDemo {

	/** 
	 * Game on!
	 */
	public static void main(String[] args) throws IOException {
		display("Welcome to the game");
		doHelp();
		GameStateDemo game = new GameStateDemo();
		game.state.lookAround();
		game.play();
	}

	enum Command { LOOK, ENTER, EXIT, QUIT }

	abstract class State {
		public abstract void lookAround();
		public abstract void goInside();
		public abstract void goOutside();
		public void quitGame() {
			// In this trivial game it makes sense to allow exit
			// from any state, so allow that here.
			// In a real game, should not quit without e.g., 
			// prompting the user if they're holding any valuables.
			display("Goodbye!");
			System.exit(0);
		}
	}

	public State inHallwayState = new State() {
		public void lookAround() {
			display("You are in a hallway. There is a door here");
		}
		public void goInside() {
			display("You are in a room");
			state = inRoomState;
		}
		public void goOutside() {
			display("You are already in the hallway");
		}
	};

	public State inRoomState = new State() {
		public void lookAround() {
			// This would map to the description of a particular room
			display("The room is full of gold!");
		}
		public void goInside() {
			display("You are already in the room");
		}
		public void goOutside() {
			display("You are in a hallway");
			state = inHallwayState;
		}
	};

	public void oneMove(String line) {
		try {
			Command c = Command.valueOf(line.toUpperCase());
			switch(c) {
				case LOOK: state.lookAround(); break;
				case ENTER: state.goInside(); break;
				case EXIT: state.goOutside(); break;
				case QUIT: state.quitGame(); break;
			}
		} catch (IllegalArgumentException e) {
			display("I don't quite follow you.");
			doHelp();
		}
	}

	private static void doHelp() {
		display("I know but a few actions:");
		for (Command c : Command.values()) {
			System.out.print(c.name());
			System.out.print(' ');
		}
		System.out.println();
	}

	public static void display(String mesg) {
		System.out.println(mesg);
	}

	private final State INITIAL_STATE = inHallwayState;

	private State state = INITIAL_STATE;

	public void play() throws IOException {
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = is.readLine()) != null) {
			oneMove(line);
		}
	}
}
