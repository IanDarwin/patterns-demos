package structure.decorator;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamDemo {
	
	static Pattern regex = Pattern.compile("^[A-Z]");

	public static void main(String[] args) {
		Stream.of("Red", "Yellow", "Blue", "book")
			.filter(regex.asPredicate())
			.sorted()
			.forEach(System.out::println);
		
		// The boring, verbose way.
		Stream<String> tempStream1 = Stream.of("Red", "Yellow", "Blue", "book");
		Stream<String> tempStream2 = tempStream1.filter(regex.asPredicate());
		Stream<String> tempStream3 = tempStream2.sorted();
		tempStream3.forEach(System.out::println);
	}

}
