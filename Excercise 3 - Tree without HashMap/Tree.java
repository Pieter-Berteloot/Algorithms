package Tree;

import java.util.ArrayList;

public class Tree {

	public ArrayList<Node> nodes = new ArrayList<Node>();
	public ArrayList<String> elements = new ArrayList<String>();
	public Node root;

	private ArrayList<Node> lastNodes = new ArrayList<Node>();

	/**
	 * Creates a new tree and makes the first Node: Root
	 * 
	 */
	public Tree() {
		this.root = new Node("root", null);
	}

	/**
	 * Add a String element to the elements array
	 * 
	 * @param e
	 */
	public void addElements(String e) {
		System.out.println("You have added " + e + " to elements.");
		elements.add(e);
	}

	/**
	 * @return the ArrayList elements
	 */
	public ArrayList<String> getElements() {
		return elements;
	}

	/**
	 * @return the tree Root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @return the ArrayList with the lastNodes
	 */
	public ArrayList<Node> getLastNodes() {
		return lastNodes;
	}

	/**
	 * @param addElements
	 *            the Array of remaining elements you want to add to your tree
	 * @param parent
	 *            the parent node for which you want to add a child
	 */
	public void makeTree(ArrayList<String> addElements, Node parent) {

		for (String element : addElements) {
			Node child = new Node(element, parent);
			parent.addChild(child);

			// create new array so we can delete the element that we already
			// added to our tree
			ArrayList<String> childrenArray = new ArrayList<String>();
			childrenArray.addAll(addElements);
			childrenArray.remove(element);
			if (childrenArray.size() > 0) {
				makeTree(childrenArray, child); // Recursive call
			}

			else {
				lastNodes.add(child);
			}
		}
	}
}
