package behavioral.visitor.file;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Example Visitor pattern applied to listing directories, using standard java.nio classes.
 * Here the "nodes" are actual filesystem nodes (represented by "inodes" in the Unix/Linux sense)
 * @author Ian Darwin
 */
public class FileVisitorDemo {

	public static void main(String[] args) throws IOException {
		
		// Set the starting path
		Path startingPath = Paths.get(".");

		// Instantiate the Visitor object
		FileVisitor<Path> visitor;
		visitor = new TrivialListerVisitor();
		// visitor = new IndentingFileVisitor();

		// Use the built-in walkFileTree client to visit all directory,file nodes
		Files.walkFileTree(startingPath, visitor);
	}
}
