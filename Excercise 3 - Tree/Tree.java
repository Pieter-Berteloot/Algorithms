package Tree;

import java.util.ArrayList;
import java.util.HashMap;


public class Tree {

    private HashMap<String, Node> nodes;


    public Tree() {
        this.nodes = new HashMap<String, Node>();
    }


    public HashMap<String, Node> getNodes() {
        return nodes;
    }

    public Node addNode(String identifier, String parent) {
        Node node = new Node(identifier);
        nodes.put(identifier, node);

        if (parent != null) {
            nodes.get(parent).addChild(identifier);
        }

        return node;
    }
    
    public void getChildren(String identifier) {
    	
    	ArrayList<String> children = nodes.get(identifier).getChildren();
    	System.out.println(children);
    }
    
    public void getChildrenOnIndex(String identifier, int index){
    	
    	ArrayList<String> children = nodes.get(identifier).getChildren();
    	System.out.println(children.get(index));
    	
    }

    public void display(String identifier, int depth) {
    	String space = "";
    	int i = 0;
        ArrayList<String> children = nodes.get(identifier).getChildren();

        if (depth == 0) {
            System.out.println(nodes.get(identifier).getIdentifier());
        } else {
            
        	while (i < depth) {
        		
        		space += "----";
				i++;
			}
        	
            System.out.println(space + nodes.get(identifier).getIdentifier());
        }
        depth++;
        for (String child : children) {

            // Recursive call
            this.display(child, depth);
        }
    }}
