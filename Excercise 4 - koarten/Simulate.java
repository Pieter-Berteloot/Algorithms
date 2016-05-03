import org.graphstream.graph.Edge;

public class Simulate {

	private Map map;
	public Simulate(Map map) {
		this.map = map;
	}

	private boolean simulateAccident(Edge e) {

		int carAmount = (int) e.getNumber("carAmount");
		if (Math.random() < (0.001 * carAmount)) {
			e.addAttribute("ui.class", "important");
			return true;
		} else
			return false;
	}

	private void addWeightonAccident(Edge e) {

		if (simulateAccident(e) == true) {
			e.changeAttribute("weight", e.getNumber("weight") + 30);
			e.addAttribute("label", "" + (int) e.getNumber("weight"));
			System.out.println("Accident on: " + e.getId() + " +30 weight");
			
			while (simulateAccident(e) == true) {
				e.changeAttribute("weight", e.getNumber("weight") + 50);
				e.addAttribute("label", "" + (int) e.getNumber("weight"));
				System.out.println("Accident on: " + e.getId() + " +50 weight");
			}
		}
	}

	public void simulateMap() {

		for (Edge e : map.getGraph().getEachEdge()) {
			addWeightonAccident(e);
		}
	}

}
