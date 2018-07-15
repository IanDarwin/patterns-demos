package visitor;

/**
 * Simple bitmap image node.
 */
public class ImageNode implements Node {
	String fileName;
	byte[] imageData;
	int height, width;
	ImageCaptionNode caption;
	
	public ImageNode(String fileName, String caption) {
		load(fileName);
		this.caption = new ImageCaptionNode(caption);
	}
	
	private void load(String fileName) {
		// dummy for now
		this.fileName = fileName;
		height = width = 64;
	}

	@Override
	public
	void accept(Visitor v) {
		v.visitImageNode(this);	
	}
}
