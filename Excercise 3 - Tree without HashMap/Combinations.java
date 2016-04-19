package Tree;

public class Combinations {

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
