package visitor;

/** 
 * Visitors have to know how to visit every main kind of Node;
 */
public abstract class Visitor {

	public abstract void visitTextNode(TextNode textNode);

	public abstract void visitImageNode(ImageNode imageNode);
	
	// And so on for TableNode, SectionNode, VideoNode, etc.

}
