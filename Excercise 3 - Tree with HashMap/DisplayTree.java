package Tree;

import java.util.ArrayList;

	public class DisplayTree {
	
	public void display(Tree tree, String identifier, int depth) {
		
		String space = "";
		int i = 0;
		ArrayList<String> children = tree.nodes.get(identifier).getChildren();

		if (depth == 0) {
			System.out.println(tree.nodes.get(identifier).getIdentifier());
		} else {

			while (i < depth) {
				space += "----";
				i++;
			}

			System.out.println(space + tree.nodes.get(identifier).getIdentifier());
		}
		depth++;
		for (String child : children) {
			this.display(tree, child, depth);
		}
	}

}
