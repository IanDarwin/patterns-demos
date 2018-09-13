package structure.decorator;

public class Mat extends ImageDecorator {
	String color;
	
	public Mat(String color, PhotoImage target) {
		super(target);
		this.color = color;
	}

	@Override
	public String getDescription() {
		return target.getDescription() + ", Matted(" + color + ")";
	}

}
