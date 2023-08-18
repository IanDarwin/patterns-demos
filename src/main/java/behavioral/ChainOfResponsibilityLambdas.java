package behavioral;

import java.util.function.*;

/**
 * Change of Responsibility, simple example using lambdas
 * that are public static so testable independently.
 * @author Adapted from an example by Richard Warburton
 */
public class ChainOfResponsibilityLambdas {
	static UnaryOperator<String> headerProcessing = 
		(String text) -> "From Raoul, Richard: " + text;
		  
	static UnaryOperator<String> spellCheckerProcessing = 
		(String text) -> text.replaceAll("lamda", "lambda"); 

	static UnaryOperator<String> uploadProcessing = 
		(String text) -> { System.out.println("Uploading: " + text); return text; };

	public static void main(String[] args) {
		Function<String, String> pipeline = headerProcessing
				.andThen(spellCheckerProcessing)
				.andThen(uploadProcessing);

		String result = pipeline.apply("Aren't lamdas really cool?!!");
	}
}

