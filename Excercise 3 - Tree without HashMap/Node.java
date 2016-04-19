package Tree;

import java.util.ArrayList;

public class Node {

	private String identifier;
	private ArrayList<Node> children;
	private Node parent;

	public Node(String a, Node parent) {
		identifier = a;
		children = new ArrayList<Node>();
		this.parent = parent;
	}

	public String getIdentifier() {
		return identifier;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void addChild(Node child) {
		children.add(child);
	}

	public Node getParent() {
		return parent;
	}
}
