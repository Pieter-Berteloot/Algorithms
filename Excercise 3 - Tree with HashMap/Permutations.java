package Tree;

public class Permutations {
	
	public void printAllPermutations(Tree excistingTree) {

		Tree tree = excistingTree;
		String a = "root";

		int x = 0;
		int y = 0;
		int z = 0;

		String permutations = "";

		while (x < tree.getChildren(a).size()) {

			String b = tree.getChildrenOnIndex(a, x);
			permutations += b;

			while (y < tree.getChildren(b).size()) {

				String c = tree.getChildrenOnIndex(b, y);
				permutations += " " + c;

				while (z < tree.getChildren(c).size()) {

					String d = tree.getChildrenOnIndex(c, z);
					permutations += " " + d;
					System.out.println(permutations);

					permutations = b + " " + c;

					z++;
				}
				z = 0;
				permutations = b;
				y++;
				System.out.println("");
			}
			permutations = "";

			x++;

			y = 0;
		}
	}
}
	

	