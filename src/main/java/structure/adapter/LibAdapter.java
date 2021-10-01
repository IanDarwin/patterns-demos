package structure.adapter;

public interface LibAdapter {

	public void process(int num, String name);

	static LibAdapter getAdapter() {
		if (Math.random() > 0.5) {
			return new Lib1Adapter();
		} else {
			return new Lib2Adapter();
		}
	}

}
