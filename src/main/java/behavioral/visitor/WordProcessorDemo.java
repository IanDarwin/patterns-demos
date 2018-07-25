package behavioral.visitor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.darwinsys.formatting.Fmt;

public class WordProcessorDemo {

	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<>();
		nodes.add(new TextNode("My Thesis Dissertation"));
		nodes.add(new TextNode("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
		nodes.add(new ImageNode("ian-pro-headshot.png", "Ian May Not Be As Advertised"));

		out = new PrintWriter(System.out);
		for (Node n : nodes) {
			n.accept(draftPrinterVisitor);
		}
		out.flush();
		
		Visitor wordCountVisitor = new WordCountVisitor();
		for (Node n : nodes) {
			n.accept(wordCountVisitor);
		}
		System.out.printf("The document has approximately %d words%n", ((WordCountVisitor) wordCountVisitor).getWordCount());
	}
	
	static PrintWriter out;

	static Visitor draftPrinterVisitor = new Visitor() {
		@Override
		public void visitTextNode(TextNode textNode) {
			String[] lines = { textNode.getText() };
			Fmt.format(Stream.of(lines), out);
		}

		@Override
		public void visitImageNode(ImageNode imageNode) {
			String caption = imageNode.caption != null ? imageNode.caption.getText() : "no caption";
			System.out.printf("Image: name='%s', caption='%s'%n", imageNode.fileName, caption);
		}
		
	};
}
