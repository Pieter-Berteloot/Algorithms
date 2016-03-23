package Exercise2;



public class AddandRemove {
	static int indexToAdd;

	
	public static void add(int[] winner, int[] loser){
		
		indexToAdd = ArrayHold.getLastElement(winner);
		
		winner[indexToAdd] = winner[0] ;
		winner[indexToAdd+1] = loser[0];
	
		
	}
	public static void remove(int[] winner, int[] loser){
		
		for(int i=0; i<winner.length-1; i++){ 
		     winner[i] = winner[i+1];
		}
		
		for(int i=0; i<loser.length-1; i++){ 
		     loser[i] = loser[i+1];
		}
		
	}
}
