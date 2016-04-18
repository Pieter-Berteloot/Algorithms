package Tree;

import java.util.ArrayList;

	public class DisplayTree {
	
	public void display(Tree tree, String identifier, int depth) {
		
		String space = "";
		int i = 0;
		ArrayList<String> children = tree.getChildren(identifier);

		if (depth == 0) {
			Node node = tree.getNodeFromIdentifier(identifier);
			System.out.println(node.getIdentifier());
		} else {

			while (i < depth) {
				space += "----";
				i++;
			}
			Node node = tree.getNodeFromIdentifier(identifier);
			System.out.println(space + node.getIdentifier());

		}
		depth++;
		for (String child : children) {
			this.display(tree, child, depth);
		}
	}
}
