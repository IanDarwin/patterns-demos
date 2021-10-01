package structure.adapter;

public class AdapterDemo {
	public static void main(String[] args) {
		LibAdapter lib = LibAdapter.getAdapter();
		lib.process(123, "Ian");
	}
}
