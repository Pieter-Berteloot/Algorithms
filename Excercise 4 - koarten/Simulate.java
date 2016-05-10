import org.graphstream.graph.Edge;

public class Simulate {

	private Map map;
	private static int addWeightOnFirstAccident = 30;
	private static int addWeightOnMoreAccident = 50;

	public Simulate(Map map) {
		this.map = map;
	}

	/**
	 * Simulates if there has been an accident on the road
	 * 
	 * @param e
	 *            the road
	 * @return boolean if there has been an accident
	 */
	private boolean simulateAccident(Edge e) {

		int carAmount = (int) e.getNumber("carAmount");
		if (Math.random() < (0.001 * carAmount)) {
			e.addAttribute("ui.class", "accident");
			return true;
		} else
			return false;
	}

	/**
	 * Adds weight to the road if there has been an accident
	 * 
	 * @param e
	 *            the road
	 */
	private void addWeightonAccident(Edge e) {

		if (simulateAccident(e) == true) {

			if ( e.getNumber("amoundOfAccidents") == 0){
				e.changeAttribute("weight", e.getNumber("weight") + addWeightOnFirstAccident);
				System.out.println("Accident on: " + e.getId() + " +30 weight");
			}
			else{
				e.changeAttribute("weight", e.getNumber("weight") + addWeightOnMoreAccident);
				System.out.println("Accident on: " + e.getId() + " +50 weight");
			}

			e.addAttribute("label", "" + (int) e.getNumber("weight"));
			e.changeAttribute("amoundOfAccidents", e.getNumber("amoundOfAccidents") + 1);

			while (simulateAccident(e) == true) {
				e.changeAttribute("weight", e.getNumber("weight") + addWeightOnMoreAccident);
				e.addAttribute("label", "" + (int) e.getNumber("weight"));
				System.out.println("Accident on: " + e.getId() + " +50 weight");
				e.changeAttribute("amoundOfAccidents", e.getNumber("amoundOfAccidents") + 1);
			}
		}
	}

	/**
	 * simulates all the roads on the map for accidents
	 */
	public void simulateMap() {
		
		for (Edge e : map.getGraph().getEachEdge()) {
			addWeightonAccident(e);
		}
	}

}
