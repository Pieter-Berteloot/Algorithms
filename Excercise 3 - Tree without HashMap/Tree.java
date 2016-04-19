package Tree;

import java.util.ArrayList;

public class Tree {

	public ArrayList<Node> nodes = new ArrayList<Node>();
	public ArrayList<String> elements = new ArrayList<String>();
	public Node root;

	private ArrayList<Node> lastNodes = new ArrayList<Node>();

	public Tree() {
		this.root = new Node("root", null);
	}

	public void addElements(String e) {
		System.out.println("You have added " + e + " to elements.");
		elements.add(e);
	}

	public ArrayList<String> getElements() {
		return elements;
	}


	public Node getRoot() {
		return root;
	}

	public ArrayList<Node> getLastNodes() {

		return lastNodes;
	}

	public void makeTree(ArrayList<String> arrayList, Node parent) {

		for (String element : arrayList) {
			Node cursor = new Node(element, parent);
			parent.addChild(cursor);
			ArrayList<String> childrenArray = new ArrayList<String>();
			childrenArray.addAll(arrayList);
			childrenArray.remove(element);

			if (childrenArray.size() > 0) {
				makeTree(childrenArray, cursor);
			}

			else {
				lastNodes.add(cursor);
			}
		}
	}
}
