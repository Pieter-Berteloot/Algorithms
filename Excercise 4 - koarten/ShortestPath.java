import org.graphstream.algorithm.Dijkstra;

public class ShortestPath {

	/**
	 * Prints the shortest path by weight or carAmount
	 * 
	 * @param map
	 *            the map of the road
	 * @param from
	 *            from city
	 * @param to
	 *            to city
	 * @param type
	 *            shortest path by weight or carAmound
	 */
	public static void printShortestPath(Map map, String from, String to, String type) {

		Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, type);
		dijkstra.init(map.getGraph());
		dijkstra.setSource(map.getGraph().getNode(from));
		dijkstra.compute();
		System.out.println(dijkstra.getPath(map.getGraph().getNode(to)));
		dijkstra.clear();
	}

}