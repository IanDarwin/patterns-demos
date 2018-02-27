package behavioral.bidpay;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class CompositeCommandTest {

	boolean flag1, flag2;

	class SimpleCommand implements Command {
		Command command;
		SimpleCommand(Command command) {
			this.command = command;
		}
		public void execute() {
			command.execute();
		}
	}

	@Test
	public void testComposite() {
		flag1 = flag2 = false;
		Command c1 = new SimpleCommand(()->flag1 = true);
		Command c2 = new SimpleCommand(()->flag2 = true);
		new CompositeCommand(Arrays.asList(new Command[]{c1,c2})).execute();
		assertTrue(flag1);
		assertTrue(flag2);
	}
}
