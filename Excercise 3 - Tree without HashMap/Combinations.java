package Tree;

import java.util.ArrayList;

public class Combinations {

	/**
	 * Print all the Combinations possible with the given elements
	 * 
	 * @param lastNodes
	 *            the last Nodes of the given tree
	 * @param root
	 *            the root of the tree
	 * @param combination
	 *            Elements the amount of combination elements
	 * @param totalElements
	 *            the total elements in the tree
	 */

	public static void printAllCombinations(ArrayList<Node> lastNodes, Node root, int combinationElements,
			int totalElements) {
		System.out.println("-----------------------------------------------");
		System.out.println("Calculating all Combinations:");
		StringBuilder lastString = new StringBuilder("");
		StringBuilder str = new StringBuilder("");

		for (Node selectedNode : lastNodes) {
			int depth = 0;
			str.setLength(0);

			while (selectedNode != root) {
				if (totalElements - depth <= combinationElements) {
					str.append(selectedNode.getIdentifier());
				}
				depth++;
				selectedNode = selectedNode.getParent();
			}
			str.reverse();

			if (str.toString().equals(lastString.toString())) {
			} else {
				System.out.println(str);
			}

			lastString.setLength(0);
			lastString.append(str);

		}
	}

}
