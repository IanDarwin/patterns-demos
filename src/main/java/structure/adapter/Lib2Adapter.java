package structure.adapter;

public class Lib2Adapter implements LibAdapter {

	Lib2 lib = new Lib2();

	public void process(int number, String name) {
		lib.handleData(number, name);
	}
}
