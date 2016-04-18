package Tree;

import java.util.ArrayList;

public class Tree<E> {

    private E data;
	public ArrayList<Node> nodes = new ArrayList<Node>();
	public ArrayList<E> elements = new ArrayList<E>(); 
	
	public Tree() {

	}
	

	public Node getNodeFromIdentifier(String identifier) {

		boolean nodeFound = false;
		int i = 0;
		Node node = null;

		while (nodeFound == false) {
			if (i < nodes.size()) {
				String nodeIdentifier = nodes.get(i).getIdentifier();

				if (nodeIdentifier == identifier) {
					nodeFound = true;
					node = nodes.get(i);
					return node;

				} else {

					i++;
					
				}
			}
		}
		return node;
	}
	
	public void addElements(E e){
		
		elements.add(e);
	}
	

	public Node addNode(String identifier) {

		Node node = new Node(identifier, 0);
		nodes.add(node);
		return node;

	}

	public void addNode(String identifier, String parent) {

		Node nodeParent = getNodeFromIdentifier(parent);

		Node node = new Node(identifier, nodeParent.getDepth() + 1);
		nodes.add(node);
		nodeParent.addChild(identifier);

	}

	public ArrayList<String> getChildren(String identifier) {

		Node node = getNodeFromIdentifier(identifier);

		ArrayList<String> children = node.getChildren();
		return children;
	}

	public String getChildrenOnIndex(String identifier, int index) {

		Node node = getNodeFromIdentifier(identifier);
		ArrayList<String> children = node.getChildren();

		return children.get(index);
	}
}
