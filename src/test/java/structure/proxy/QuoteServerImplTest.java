package structure.proxy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteServerImplTest {

	private static final String LOREM = "Lorem ipsem dolor";
	QuoteServer target;

	@Before
	public void setUp() throws Exception {
		target = new QuoteServerImpl();
	}

	@Test
	public void testGetQuote() {
		((QuoteServerImpl)target).sayings.clear();
		target.addQuote(LOREM);
		assertEquals(LOREM, target.getQuote());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSmash() {
		((QuoteServerImpl)target).sayings.clear();
		target.getQuote();
	}

}
