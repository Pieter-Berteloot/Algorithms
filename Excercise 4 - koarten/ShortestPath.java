import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Path;

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
	public static Path printShortestPath(Map map, String from, String to, String type) {

		Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, type);
		dijkstra.init(map.getGraph());
		dijkstra.setSource(map.getGraph().getNode(from));
		dijkstra.compute();
		return dijkstra.getPath(map.getGraph().getNode(to));
	}
}