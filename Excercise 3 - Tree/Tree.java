package Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class Tree {

	private HashMap<String, Node> nodes;

	public Tree() {
		this.nodes = new HashMap<String, Node>();
	}

	public HashMap<String, Node> getNodes() {
		return nodes;
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

	///////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////// Permutations//////////////////////////////////////////////



	public void printAllPermutations() {
		String a = "root";
		int x = 0;
		int y = 0;
		int z = 0;

		String permutations = "";

		while (x < getChildren(a).size()) {

			String b = getChildrenOnIndex(a, x);
			permutations += b;

			while (y < getChildren(b).size()) {

				String c = getChildrenOnIndex(b, y);
				permutations += " " + c;

				while (z < getChildren(c).size()) {

					String d = getChildrenOnIndex(c, z);
					permutations += " " + d;
					System.out.println(permutations);

					permutations = b + " " + c;

					z++;
				}
				z = 0;
				permutations = b;
				y++;
				System.out.println("");
			}
			permutations = "";

			x++;

			y = 0;

		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////

	public void display(String identifier, int depth) {
		String space = "";
		int i = 0;
		ArrayList<String> children = nodes.get(identifier).getChildren();

		if (depth == 0) {
			System.out.println(nodes.get(identifier).getIdentifier());
		} else {

			while (i < depth) {
				space += "----";
				i++;
			}

			System.out.println(space + nodes.get(identifier).getIdentifier());
		}
		depth++;
		for (String child : children) {

			// Recursive call
			this.display(child, depth);
		}
	}
}
