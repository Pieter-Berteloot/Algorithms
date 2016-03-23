package Exercise2;

public class ArrayHold {

	// the hold array
	static int[] hold = new int[52]; 
	
	/**
	 * Adds 2 equal cards to the hold deck
	 * @param a the number of the cards
	 */
	public static void addCardsToHold(int a){
		
		hold[getLastElement(hold)] = a;
		hold[getLastElement(hold)] = a;
		
	}

	
	/**
	 * Returns the index of the first element that is equal to 0 in an array
	 * @param ar the array
	 * @return	the index of the first 0 in the array
	 */
	public static int getLastElement(int[] ar){
		
		int b = 0;

		for (int i = 0; ar[i] != 0; i++) {
			
			b++;
		}
		
		return b;
	}
	
	
	/**
	 * adds all the hold cards to the winning deck
	 * @param ar	the winning deck
	 */
	public static void addHoldToDeck(int[] ar){
		
		while (hold[0] != 0){
			
			ar[getLastElement(ar)] =  hold[getLastElement(hold)-1];
			hold[getLastElement(hold)-1] = 0;	
			
		}

	}
}
