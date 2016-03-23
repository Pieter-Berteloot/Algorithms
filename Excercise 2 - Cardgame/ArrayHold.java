package Exercise2;

public class ArrayHold {

	static int[] hold = new int[52]; 
	
	public static void addCardsToHold(int a){
		
		hold[getLastElement(hold)] = a;
		hold[getLastElement(hold)] = a;
		
	}
	
	public static int getLastElement(int[] ar){
		
		int b = 0;

		for (int i = 0; ar[i] != 0; i++) {
			
			b++;
		}
		
		return b;
	}
	
	
	
	public static void addHoldToDeck(int[] ar){
		
		while (hold[0] != 0){
			
			ar[getLastElement(ar)] =  hold[getLastElement(hold)-1];
			hold[getLastElement(hold)-1] = 0;	
			
		}

	}
}
