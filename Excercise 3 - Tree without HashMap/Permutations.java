package Tree;

import java.util.ArrayList;

public class Permutations {

	/**
	 * print all the permutations of the given elements
	 * 
	 * @param root
	 *            the root of the tree
	 * @param lastNodes
	 *            the last Nodes of the given tree
	 * 
	 */

	public static void printAllPermutations(ArrayList<Node> lastNodes, Node root) {
		System.out.println("-----------------------------------------------");
		System.out.println("Calculating all Permutations:");

		for (Node selectedNode : lastNodes) {
			StringBuilder str = new StringBuilder("");

			while (selectedNode != root) {
				str.append(selectedNode.getIdentifier());
				selectedNode = selectedNode.getParent();
			}
			System.out.println(str.reverse());
		}
	}
}
