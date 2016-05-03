
import java.util.Scanner;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.ProxyPipe;

import org.graphstream.ui.view.Viewer;

public class Map {
	public Graph g;

	public Map() {
		g = new SingleGraph("Map");
		addRoads();
		addAttributes();
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
		if (g.getNode(node1) == null) {
			g.addNode(node1);
		}
		if (g.getNode(node2) == null) {
			g.addNode(node2);
		}

		g.addEdge(node1 + "-" + node2, node1, node2, true).addAttribute("weight", weight);
		g.addEdge(node2 + "-" + node1, node2, node1, true).addAttribute("weight", weight);
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

	public void addCars(String road) {
		Edge edge = g.getEdge(road);

		edge.changeAttribute("carAmount", edge.getNumber("carAmount") + 1);
		edge.changeAttribute("weight", edge.getNumber("weight") + 1);
		edge.changeAttribute("label", "" + (int) edge.getNumber("weight"));
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
		map.getGraph().addAttribute("ui.quality");

		// viewer
		Viewer viewer = map.getGraph().display();
		System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

		// proxyPipe so we can update our viewer
		ProxyPipe pipe = viewer.newViewerPipe();
		pipe.addAttributeSink(map.getGraph());

		// add 5000 cars to all roads
		map.addCarsToAll(5);

		// scanner
		Scanner input = new Scanner(System.in);
		while (true) {
			String stringInput = input.nextLine();
			map.addCars(stringInput);
			s.simulateMap();
			pipe.pump();
		}
	}
}
