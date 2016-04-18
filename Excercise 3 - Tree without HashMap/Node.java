package Tree;

import java.util.ArrayList;

public class Node {


	private String identifier;
	private int depth;
	private ArrayList<String> children;

	public Node(String a, int depth) {
		identifier = a;
		children = new ArrayList<String>();
		this.depth = depth;
	}

	public String getIdentifier() {
		return identifier;
	}

	public ArrayList<String> getChildren() {
		return children;

	}

	public void addChild(String identifier) {
		children.add(identifier);
	}

	public int getDepth(){
		
		return depth;
	}
}
