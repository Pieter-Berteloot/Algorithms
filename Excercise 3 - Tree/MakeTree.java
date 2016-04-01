package Tree;

public class MakeTree {
    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.addNode("root", null);
        tree.addNode("A1", "root");
        tree.addNode("B1", "root");
        tree.addNode("C1", "root");
        tree.addNode("B2", "A1");
        tree.addNode("C2", "A1");
        tree.addNode("A2", "B1");
        tree.addNode("C2", "B1");
        tree.addNode("A2", "C1");
        tree.addNode("B2", "C1");


        tree.display("root", 0);
        
        System.out.println("");
        System.out.println("--test get children from A1:");
        tree.getChildren("A1");
        
        System.out.println("");
        System.out.println("--test get children from A1 on index 1:");
        tree.getChildrenOnIndex("A1", 1);
    }
    
    
}