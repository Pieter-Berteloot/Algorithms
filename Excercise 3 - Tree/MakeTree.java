package Tree;

public class MakeTree {
	public static void main(String[] args) {

		Tree tree = new Tree();

		tree.addNode("root", null);
		tree.addNode("A", "root");
		tree.addNode("B", "root");
		tree.addNode("C", "root");
		tree.addNode("D", "A");
		tree.addNode("E", "A");
		tree.addNode("F", "B");
		tree.addNode("G", "B");
		tree.addNode("H", "C");
		tree.addNode("I", "C");

		tree.addNode("J", "D");
		tree.addNode("K", "E");
		tree.addNode("L", "F");
		tree.addNode("M", "G");
		tree.addNode("N", "H");
		tree.addNode("O", "I");

		tree.display("root", 0);

		System.out.println("");
		System.out.println("All permutations: ");
		tree.printAllPermutations();
	}

}