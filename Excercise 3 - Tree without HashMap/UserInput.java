package Tree;

import java.util.*;

public class UserInput {

	public ArrayList<String> elements = new ArrayList<String>();

	public static void main(String[] args) {

		Tree tree = new Tree();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in the Tree elements.");

		while (true) {
			String next = scanner.next();

			if ((next.equals("finish") || next.equals("Finish"))) {
				tree.makeTree(tree.getElements(), tree.getRoot());

				Combinations.printAllCombitnations(tree.getRoot());
				Permutations.printAllPermutations(tree.getLastNodes(), tree.getRoot());

			} else {
				tree.addElements(next);
			}
		}
	}
}
