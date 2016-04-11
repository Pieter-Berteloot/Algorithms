package Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class Tree {

	public HashMap<String, Node> nodes;

	public Tree() {
		this.nodes = new HashMap<String, Node>();
	}

	public Node addNode(String identifier, String parent) {
		Node node = new Node(identifier);
		nodes.put(identifier, node);

		if (parent != null) {
			nodes.get(parent).addChild(identifier);
		}

		return node;
	}

	public ArrayList<String> getChildren(String identifier) {

		ArrayList<String> children = nodes.get(identifier).getChildren();
		return children;
	}

	public String getChildrenOnIndex(String identifier, int index) {

		ArrayList<String> children = nodes.get(identifier).getChildren();

		return children.get(index);
	}
}
