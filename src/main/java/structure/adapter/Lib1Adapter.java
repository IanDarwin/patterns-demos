package structure.adapter;

public class Lib1Adapter implements LibAdapter {

	Lib1 lib = new Lib1();

	public void process(int number, String name) {
		lib.doSomething(name, number);
	}

}
