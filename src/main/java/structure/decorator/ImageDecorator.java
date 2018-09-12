package structure.decorator;

public abstract class ImageDecorator extends PhotoImage {
	protected PhotoImage target;
	
	public ImageDecorator(PhotoImage target) {
		this.target = target;
	}
	
	@Override
	public String getDescription() {
		return target.getDescription();
	}
	
	@Override
	public String toString() {
		return getDescription();
	}
}
