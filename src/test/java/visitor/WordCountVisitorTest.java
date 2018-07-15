package visitor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordCountVisitorTest {
	
	WordCountVisitor target;

	@Before
	public void setUp() throws Exception {
		target = new WordCountVisitor();
	}

	@Test
	public void testCounter() {
		final TextNode textNode = new TextNode();
		textNode.setText("Avoid controversial statements in examples");
		target.visitTextNode(textNode);
		assertEquals(5, target.getWordCount());
	}
	
	@Test
	public void testCounterEmptyString() {
		final TextNode textNode = new TextNode();
		textNode.setText("");
		target.visitTextNode(textNode);
		assertEquals(0, target.getWordCount());
	}

}
