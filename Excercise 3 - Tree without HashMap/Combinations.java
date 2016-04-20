package Tree;

public class Combinations {

	/**
	 * Print all the Combinations possible with the given elements
	 * @param root	the root of your tree
	 */
	public static void printAllCombitnations(Node root) {
		System.out.println("-----------------------------------------------");
		System.out.println("Calculating all Combinations:");
		for (Node selectedNode : root.getChildren()) {

			String combination = selectedNode.getIdentifier();

			for (Node selectedNode2 : selectedNode.getChildren()) {
				System.out.println(combination + selectedNode2.getIdentifier());
			}
		}
	}
}
