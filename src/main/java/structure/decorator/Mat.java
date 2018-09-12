package structure.decorator;

public class Mat extends ImageDecorator {
	String color;
	
	public Mat(PhotoImage target, String color) {
		super(target);
		this.color = color;
	}

	@Override
	public String getDescription() {
		return target.getDescription() + ", Matted(" + color + ")";
	}

}
