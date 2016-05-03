
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.ProxyPipe;
import org.graphstream.stream.file.FileSourceDGS;
import org.graphstream.ui.view.Viewer;

public class Map {
	private Graph g;

	public Map() {
		g = new SingleGraph("Map");
		addRoads();
		addAttributes();
	}

	public Graph getGraph() {
		return g;
	}

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

	private void addAttributes() {
		for (Node n : g)
			n.addAttribute("label", n.getId());

		for (Edge e : g.getEachEdge()) {
			e.addAttribute("label", "" + (int) e.getNumber("weight"));
			e.addAttribute("carAmount", 0);
		}
	}

	private void makeRoad(String node1, String node2, int weight) {
		if (g.getNode(node1) == null)
			g.addNode(node1);

		if (g.getNode(node2) == null)
			g.addNode(node2);

		g.addEdge(node1 + "-" + node2, node1, node2, true).addAttribute("weight", weight);
		g.addEdge(node2 + "-" + node1, node2, node1, true).addAttribute("weight", weight);
	}

	public void addCars(String road) {
		Edge edge = g.getEdge(road);

		edge.changeAttribute("carAmount", edge.getNumber("carAmount") + 1);
		edge.changeAttribute("weight", edge.getNumber("weight") + 1);
		edge.changeAttribute("label", "" + (int) edge.getNumber("weight"));
		System.out.println("Added 1k cars on road: " + edge.getId()) ;
	}

	public void addCarsToAll(int amount) {
		for (Edge e : g.getEachEdge()) {
			e.changeAttribute("carAmount", e.getNumber("carAmount") + amount);
			e.changeAttribute("weight", e.getNumber("weight") + amount);
			e.changeAttribute("label", "" + (int) e.getNumber("weight"));
			System.out.println("added " + amount * 1000 + " cars to " + e.getId());
		}
	}

	public static void main(String[] args) {

		Map map = new Map();
		Simulate s = new Simulate(map);

		// css
		String css = "edge.important {size: 3px; fill-mode: dyn-plain;fill-color: blue, green, red;shape: cubic-curve; }"
				+ "node { size: 10px; }" + "edge { fill-color: grey;size: 2px"
				+ ";stroke-mode: plain; stroke-color: black; " + "stroke-width: 1px;" + "shape: flow; }";
		map.getGraph().addAttribute("ui.stylesheet", css);

		// viewer
		Viewer viewer = map.getGraph().display();

		// proxyPipe so we can update our viewer
		ProxyPipe pipe = viewer.newViewerPipe();
		pipe.addAttributeSink(map.getGraph());

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
				System.out.println("Type the amound of cars (in k) you want to add to all roads");

				String inputInt = scanner.next();
				map.addCarsToAll(Integer.parseInt(inputInt));
				s.simulateMap();
				pipe.pump();
				break;

			case "b":
				System.out.println("Type the Road you want to add 1k cars to. Example: Brugge-Gent");
				String inputRoad = scanner.next();
				map.addCars(inputRoad);
				s.simulateMap();
				pipe.pump();
				break;

			case "c":
				System.out.println("from city:");
				String from = scanner.next();
				System.out.println("to city:");
				String to = scanner.next();
				System.out.println("Calculate shortest route by weight or carAmount");
				String type = scanner.next();
				ShortestPath.printShortestPath(map, from, to, type);
			}
		}
	}
}
