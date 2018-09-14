package structure.decorator;

import java.io.*;

public class IOStreamsDemo {
	class FileProvider { File getFile() { return new File("README.adoc"); }}
	FileProvider foo;
	
	void demo() throws Exception {
		BufferedReader is = new BufferedReader(new FileReader("some filename here"));
		PrintWriter pout = new PrintWriter(new FileWriter("output filename here"));
		LineNumberReader lrdr = new LineNumberReader(new FileReader(foo.getFile()));
	}
}
