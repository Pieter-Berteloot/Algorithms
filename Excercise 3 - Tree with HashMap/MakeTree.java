package Tree;


public class MakeTree {
	

	
	public static void main(String[] args) {

		Tree tree = new Tree();	
		DisplayTree displayTree = new DisplayTree();
		
		tree.addNode("root", null);
		tree.addNode("A", "root");
		tree.addNode("B", "root");
		tree.addNode("C", "root");
		tree.addNode("B ", "A");
		tree.addNode("C ", "A");
		tree.addNode("A ", "B");
		tree.addNode("C  ", "B");
		tree.addNode("A  ", "C");
		tree.addNode("B  ", "C");

		tree.addNode("C   ", "B ");
		tree.addNode("B   ", "C ");
		tree.addNode("C    ", "A ");
		tree.addNode("A   ", "C  ");
		tree.addNode("A    ", "B  ");
		tree.addNode("B    ", "A  ");

		displayTree.display(tree, "root", 0);

		
		System.out.println("");
		System.out.println("All permutations: ");
		
		Permutations permu = new Permutations();
		permu.printAllPermutations(tree);
	}

}