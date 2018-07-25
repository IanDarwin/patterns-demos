package visitor;

/**
 * Simple text node.
 */
public class TextNodeOld {
	private StringBuilder text = new StringBuilder();
	
	public TextNodeOld() {
		// empty
	}

	public TextNodeOld(String s) {
		// Here we know the SB exists and is empty
		text.append(s);
	}
	
	public String getText() {
		return text.toString();
	}

	public void setText(String text) {
		this.text.setLength(0); this.text.append(text);
	}

	// Lots of function methods here - dummied out for now
	public int wordCount() {
		// Delegate to external wordcount module
		return 0;
	}
	public String getAsDraft() {
		// Break text into chunks of up to 72 chars, then print
		return null;
	}
}
