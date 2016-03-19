package Exercise2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	private static int stappen;
	static int[] deckPlayer1;
	static int[] deckPlayer2;

	static int[] deckOfCards = { 1,1,1,1,
			2,2,2,2,
			3,3,3,3,
			4,4,4,4,
			5,5,5,5,
			6,6,6,6,
			7,7,7,7,
			8,8,8,8,
			9,9,9,9,
			10,10,10,10,
			11,11,11,11,
			12,12,12,12,
			13,13,13,13};
	
	static ArrayList<Integer> deckPlayer1List = new ArrayList<Integer>();
	static ArrayList<Integer> deckPlayer2List = new ArrayList<Integer>();

		
	static void arrayToListPlayer1(int[] ar){
		
		 for (int i = 0; i < deckPlayer1.length; i++)
		    {
			 	deckPlayer1List.add(deckPlayer1[i]);
		    }
		
		
	}
	
	static void arrayToListPlayer2(int[] ar){
		
		 for (int i = 0; i < deckPlayer2.length; i++)
		    {
			 	deckPlayer2List.add(deckPlayer2[i]);
		    }
		
		
	}
			
	
  static void shuffleDeck(int[] ar)
  {
    
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
  
  
  public static void splitDeck(int[] ar)
  {

	  deckPlayer1 = Arrays.copyOfRange(ar, 0, ar.length/2);
	  deckPlayer2 = Arrays.copyOfRange(ar, ar.length/2, ar.length);
	
  }
  
  
  public static void checkWinner(){
	  
	  int number1 = deckPlayer1List.get(0);
	  int number2 = deckPlayer2List.get(0);
	  
	  if(number1 > number2){
		  
		  addAndRemove(deckPlayer1List, deckPlayer2List);
		  
	  }
	  
	  else{
		  addAndRemove(deckPlayer2List, deckPlayer1List);
		  
	  }
	  
  }
  
  private static void addAndRemove(ArrayList<Integer> list1, ArrayList<Integer> list2){
	  
	  //list 1 is winner
	  
	  
	  list1.add(list2.get(0));
	  list1.add(list1.get(0));
	  list1.remove(0);
	  list2.remove(0);
	  
  }
  
  public static void print() {
	  
	  System.out.println("stappen: " + stappen);
  System.out.println("Deck Player 1: ");
  
  
  for (int i = 0; i < deckPlayer1List.size(); i++)
  {
    System.out.print(deckPlayer1List.get(i) + " ");
  }
  System.out.println();
  
  
  System.out.println("Deck Player 2: ");
  for (int i = 0; i < deckPlayer2List.size(); i++)
  {
    System.out.print(deckPlayer2List.get(i) + " ");
  }
  System.out.println();
  stappen++;
  
  }
  
  

  
  public static void main(String args[])
  {

    shuffleDeck(deckOfCards);
    splitDeck(deckOfCards);
    arrayToListPlayer1(deckPlayer1);
    arrayToListPlayer2(deckPlayer2);
    checkWinner();
  
    

    
	Scanner scanner = new Scanner(System.in);


	while (true) {
		String input = scanner.next();
		switch (input) {
		case "q":
			checkWinner();
			print();
			break;
		
		
			case "s":
		while (deckPlayer1List.size() > 0 ) {
			checkWinner();
			print();
		}
		

		break;
	}
	}
    
  }
  
}