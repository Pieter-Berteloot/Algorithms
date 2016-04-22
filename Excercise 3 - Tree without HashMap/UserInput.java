package Tree;

import java.util.*;

public class UserInput {

	public ArrayList<String> elements = new ArrayList<String>();

	public static void main(String[] args) {

		Tree tree = new Tree();
		Scanner input = new Scanner(System.in);
		System.out.println("Type in the Tree elements. Type finish when ready");

		/**
		 * Allows the user to input elements when finished, the combinations and
		 * permutations will be printed.
		 */

		while (true) {

			String stringInput = input.nextLine();
			if ((stringInput.equals("finish") || stringInput.equals("Finish"))) {
				tree.makeTree(tree.getElements(), tree.getRoot());

				Permutations.printAllPermutations(tree.getLastNodes(), tree.getRoot());
				System.out.println("Type combinations to calculate the combinations");
			
				System.out.println("Enter the amound of elements you want to calculate the Combinations.");
				while (input.hasNextInt()) {
					Combinations.printAllCombinations(tree.getLastNodes(), tree.getRoot(), input.nextInt(),
							tree.getElements().size());
				
			}} else {

				tree.addElements(stringInput);

			}
		}
	}
}
