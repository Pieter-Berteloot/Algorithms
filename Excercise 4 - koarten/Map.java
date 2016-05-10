import java.util.Scanner;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class Map {
	private Graph g;

	public Map() {
		g = new SingleGraph("Map");
		addRoads();
		addAttributes();
	}

	/**
	 * @return Graph g
	 */
	public Graph getGraph() {
		return g;
	}

	/**
	 * Makes a road between 2 nodes
	 * 
	 * @param node1
	 *            from city
	 * @param node2
	 *            to city
	 * @param weight
	 *            the weight of the road
	 */
	private void makeRoad(String node1, String node2, int weight) {
		if (g.getNode(node1) == null)
			g.addNode(node1);

		if (g.getNode(node2) == null)
			g.addNode(node2);

		g.addEdge(node1 + "-" + node2, node1, node2, true).addAttribute("weight", weight);
		g.addEdge(node2 + "-" + node1, node2, node1, true).addAttribute("weight", weight);
	}

	/**
	 * calls makeRoad for all the roads
	 */
	private void addRoads() {
		makeRoad("Brugge", "Kortrijk", 56);
		makeRoad("Brugge", "Gent", 50);
		makeRoad("Brugge", "Antwerpen", 95);
		makeRoad("Gent", "Antwerpen", 60);
		makeRoad("Gent", "Brussel", 50);
		makeRoad("Brussel", "Antwerpen", 44);
		makeRoad("Brussel", "Leuven", 30);
		makeRoad("Brussel", "Bergen", 78);
		makeRoad("Brussel", "Waver", 30);
		makeRoad("Waver", "Namen", 40);
		makeRoad("Namen", "Bergen", 75);
		makeRoad("Namen", "Luik", 65);
		makeRoad("Namen", "Neufchateau", 90);
		makeRoad("Neufchateau", "Aarlen", 37);
		makeRoad("Neufchateau", "Luik", 110);
		makeRoad("Bergen", "Kortrijk", 83);
		makeRoad("Hasselt", "Luik", 53);
		makeRoad("Leuven", "Hasselt", 59);
		makeRoad("Leuven", "Luik", 82);
	}

	/**
	 * Adds a label with the name to all nodes Adds a label with the weight of
	 * the roads Adds an attribute that counts how many cars there are on the
	 * road
	 */
	private void addAttributes() {
		for (Node n : g)
			n.addAttribute("label", n.getId());

		for (Edge e : g.getEachEdge()) {
			e.addAttribute("label", "" + (int) e.getNumber("weight"));
			e.addAttribute("carAmount", 0);
			e.addAttribute("amoundOfAccidents", 0);
		}
	}

	/**
	 * Adds 1k cars to a road, adds 1 to carAmount and weight.
	 * 
	 * @param road
	 *            the road you want to add 1k cars
	 *            
	 * @return The road on which you added 1k cars
	 */
	public String addCars(String road) {
		Edge edge = g.getEdge(road);

		edge.changeAttribute("carAmount", edge.getNumber("carAmount") + 1);
		edge.changeAttribute("weight", edge.getNumber("weight") + 1);
		edge.changeAttribute("label", "" + (int) edge.getNumber("weight"));

		return "Added 1k cars on road: " + edge.getId();
	}

	/**
	 * Adds an amount of cars to all roads
	 * 
	 * @param amount
	 *            amount of cars
	 * 
	 * @return String added how much cars were added to all roads
	 */
	public String addCarsToAll(int amount) {
		for (Edge e : g.getEachEdge()) {
			e.changeAttribute("carAmount", e.getNumber("carAmount") + amount);
			e.changeAttribute("weight", e.getNumber("weight") + amount);
			e.changeAttribute("label", "" + (int) e.getNumber("weight"));
		}

		return "added " + amount * 1000 + " to all roads ";
	}

	/**
	 * User input We start with no cars on the roads
	 * 
	 */
	public static void main(String[] args) {

		Map map = new Map();
		Simulate s = new Simulate(map);
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

		// css for display
		String css = "edge.accident {size: 3px; fill-mode: dyn-plain;fill-color: red;}" + "node { size: 10px; }"
				+ "edge { fill-color: grey; size: 2px; shape: cubic-curve; }";
		map.getGraph().addAttribute("ui.stylesheet", css);

		// viewer
		Viewer viewer = map.getGraph().display();

		// scanner
		System.out.println("------------------Welcome to Hoehel Koarten---------------");
		System.out.println("------Option: [a]: Add amound of cars to all roads");
		System.out.println("------Option: [b]: Add 1k cars to a road");
		System.out.println("------Option: [c]: Calculate the ShortestPath");
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input = scanner.next();

			switch (input) {

			case "a":
				System.out.println("Type the amount of cars (in k) you want to add to all roads");

				String inputInt = scanner.next();
				System.out.println(map.addCarsToAll(Integer.parseInt(inputInt)));
				s.simulateMap();
				break;

			case "b":
				System.out.println("Type the Road you want to add 1k cars to. Example: Brugge-Gent");
				String inputRoad = scanner.next();
				System.out.println(map.addCars(inputRoad));
				s.simulateMap();
				break;

			case "c":
				System.out.println("from city:");
				String from = scanner.next();
				System.out.println("to city:");
				String to = scanner.next();
				System.out.println("Calculate shortest route by weight or carAmount");
				String type = scanner.next();
				System.out.println(ShortestPath.printShortestPath(map, from, to, type));
			}
		}
	}
}