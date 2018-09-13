package structure.decorator;

/**
 * A Print represents a PhotoImage with a physical size to print it at.
 */
public class Print extends ImageDecorator {
	/** PrintWidth, PrintHeight are in inches for our US audience */
	private double printWidth, printHeight;
	
	public Print(double printWidth, double printHeight, PhotoImage target) {
		super(target);
		this.printWidth = printWidth;
		this.printHeight = printHeight;
	}

	@Override
	public String getDescription() {
		return target.getDescription() + " " + String.format("(%4.1f x %4.1f in)", getPrintWidth(), getPrintHeight());
	}

	public double getPrintWidth() {
		return printWidth;
	}

	public void setPrintWidth(double printWidth) {
		this.printWidth = printWidth;
	}

	public double getPrintHeight() {
		return printHeight;
	}

	public void setPrintHeight(double printHeight) {
		this.printHeight = printHeight;
	}
}
