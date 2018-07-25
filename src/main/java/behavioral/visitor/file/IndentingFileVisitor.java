package behavioral.visitor.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/** 
 * A simple indentation-based directory tree lister.
 * Works, but since it's depth-first, entries in a directory may (depending on 
 * the underlying filesystem) appear after the contents of one of its subdirectories.
 * To fix this might involve a stack of List<Path> that is created in preVisitDirectory(),
 * added to in visitFile(), and printed out in postVisitDirectory(). This would be somewhat
 * beyond what's needed to show the operation of the SimpleFileVistor.
 */
class IndentingFileVisitor extends SimpleFileVisitor<Path> {
	int indent = 0;
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println(dir);
		indent += 4;
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		for (int i = 0; i < indent; i++) {
			System.out.print(' ');
		}
		System.out.println(file.getFileName());
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		indent -= 4;
		return FileVisitResult.CONTINUE;
	}
}
