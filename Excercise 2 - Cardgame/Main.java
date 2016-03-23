package Exercise2;


import java.util.Scanner;


public class Main {

	private static int stappen;
	private static int[] deckPlayer1;
	private static int[] deckPlayer2 ;
	
	private static int[] deckOfCards = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8,
			8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13 };
	
	

	public static void newGame(){
		
		ArrayDeck.shuffleDeck(deckOfCards);
		ArrayDeck.splitDeck(deckOfCards);
		
		deckPlayer1 = ArrayDeck.deckPlayer1;
		deckPlayer2 = ArrayDeck.deckPlayer2;
	}
	
	
	private static void checkWinner() {

		
		int number1 = deckPlayer1[0];
		int number2 = deckPlayer2[0];

		
		//Als de getallen niet gelijk zijn
		if (number1 != number2) {

		
			if (number1 > number2) {
				
				// Als er nog kaarten op in hold zitten moetten deze bij het winnende deck komen
				if (ArrayHold.getLastElement(ArrayHold.hold) != 0) {
					
					AddandRemove.add(deckPlayer1 , deckPlayer2);
					ArrayHold.addHoldToDeck(deckPlayer1);
					AddandRemove.remove(deckPlayer1,deckPlayer2);
					
				}

				else {
					
					AddandRemove.add(deckPlayer1 , deckPlayer2);
					AddandRemove.remove(deckPlayer1,deckPlayer2);
				}
			}

			else {

				if (ArrayHold.getLastElement(ArrayHold.hold) != 0) {
					
					AddandRemove.add(deckPlayer2 , deckPlayer1);
					ArrayHold.addHoldToDeck(deckPlayer2);
					AddandRemove.remove(deckPlayer2,deckPlayer1);
					
				}

				else {
					
					AddandRemove.add(deckPlayer2 , deckPlayer1);
					AddandRemove.remove(deckPlayer2,deckPlayer1);
				}
			}
		}

		else {
			ArrayHold.addCardsToHold(number1);
			AddandRemove.remove(deckPlayer1,deckPlayer2);
		}
	}

	private static void print() {

		System.out.println("stappen: " + stappen);
		System.out.println("Deck Player 1: ");

		

		for (int i = 0; i < ArrayHold.getLastElement(deckPlayer1) ; i++) {
			System.out.print(deckPlayer1[i] + " ");
		}
		
		System.out.println();

		System.out.println("Deck Player 2: ");
		
		
		for (int i = 0; i < ArrayHold.getLastElement(deckPlayer2); i++) {
		System.out.print(deckPlayer2[i] + " ");
		}
		
	
		
		
		
		System.out.println();
		stappen++;

	}
	
	public static void whenGameEnds(){
		


		while (ArrayHold.getLastElement(deckPlayer1) > 0 && ArrayHold.getLastElement(deckPlayer2) > 0)
		{
			checkWinner();
			stappen++;
		}
		
		
	}

	public static void main(String args[]) {

		newGame();
		checkWinner();
		print();


		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input = scanner.next();
			switch (input) {
			case "q":
				checkWinner();
				print();
				break;
			
			
			case "s":
				whenGameEnds();
				System.out.println("Game ends after: " + stappen + " steps");
				break;
		}}}}
	
