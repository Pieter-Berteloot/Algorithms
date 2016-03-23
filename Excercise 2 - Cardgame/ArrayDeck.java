package Exercise2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayDeck {
	
	static int[] deckPlayer1 = new int[54];
	static int[] deckPlayer2 = new int[54];
	


	
	static void shuffleDeck(int[] ar) {

		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}
	
	public static void splitDeck(int[] ar) {
		
		for (int j = 0; j < ar.length/2; j++) {
			deckPlayer1[j] = ar[j];
		}
		
		for (int j = 26; j < ar.length; j++) {
			deckPlayer2[j-26] = ar[j];
		}
	


	}
	
	
	

}
