package Tree;

import java.util.ArrayList;

public class Node {

	private String identifier;
	private ArrayList<Node> children;
	private Node parent;

	/**
	 * @param identifier 	the name you want to give the Node
	 * @param parent 		the parent of this Node
	 */
	public Node(String identifier, Node parent) {
		this.identifier = identifier;
		children = new ArrayList<Node>();
		this.parent = parent;
	}

	/**
	 * @return	the name of this Node
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @return the Array children of this Node
	 */
	public ArrayList<Node> getChildren() {
		return children;
	}

	/**
	 * @param child	 an other Node as child of this Node
	 */
	public void addChild(Node child) {
		children.add(child);
	}

	/**
	 * @return	a Node parent
	 */
	public Node getParent() {
		return parent;
	}
}
