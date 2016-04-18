package Tree;


public class MakeTree {
	

	
	public static void main(String[] args) {


		Tree tree = new Tree();	
		DisplayTree displayTree = new DisplayTree();
		
		tree.addNode("root");
		tree.addNode("A", "root");
		tree.addNode("B", "root");
		tree.addNode("C", "root");
		
		tree.addNode("D", "A");
		tree.addNode("E", "A");
		tree.addNode("F", "B");
		tree.addNode("G", "B");
		tree.addNode("H", "C");
		tree.addNode("I", "C");

		tree.addNode("J", "G");
		tree.addNode("K", "G");
		


		displayTree.display(tree, "root", 0);

		
		System.out.println("");
		System.out.println("All permutations: ");
		
		Permutations permu = new Permutations();
		permu.printAllPermutations(tree);
		
		
	}

}