package structure.decorator;

/** 
 * A PhotoImage is a picture that I took at some point.
 */
public class PhotoImage {
	/** The human-readable title */
	String title;
	/** Where the actual pixels are */
	String fileName;
	/** How many pixels there are in the image file */
	int pixWidth, pixHeight;
	
	public String getDescription() {
		return getTitle();
	}

	public PhotoImage() {
		// Empty; used in Decorators.
	}

	public PhotoImage(String title, String fileName) {
		super();
		this.title = title;
		this.fileName = fileName;
	}
	
	/** Default toString() just uses getDescription */
	@Override
	public String toString() {
		return getTitle();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getPixWidth() {
		return pixWidth;
	}

	public void setPixWidth(int width) {
		this.pixWidth = width;
	}

	public int getPixHeight() {
		return pixHeight;
	}

	public void setPixHeight(int height) {
		this.pixHeight = height;
	}
}
