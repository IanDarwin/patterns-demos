package visitor;

/**
 * Simple text node.
 */
public class TextNode implements Node {
	private StringBuilder text = new StringBuilder();
	
	public TextNode() {
		// empty
	}

	public TextNode(String s) {
		// Here we know the SB exists and is empty
		text.append(s);
	}
	
	public String getText() {
		return text.toString();
	}

	public void setText(String text) {
		this.text.setLength(0); this.text.append(text);
	}

	public void accept(Visitor v) {
		v.visitTextNode(this);
	}
}
