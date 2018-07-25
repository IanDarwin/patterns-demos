package behavioral.visitor;

public interface Node {
	abstract void accept(Visitor v);
}
