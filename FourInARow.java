package algorithms;

import java.util.Scanner;

/**
 * 
 * Provides a board to play four in a row add checkers in turn with
 * addChecker(player, atColumn)
 * 
 */


public class FourInARow {

	private int rows = 6, columns = 7;
	private final int yellow = 1, red = -1, empty = 0;
	private int board[][] = new int[rows][columns];
	private int currentPlayer = yellow;

	/**
	 * Start with an empty board
	 */
	public FourInARow() {
		clearBoard();
	}

	private void clearBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = empty;
			}
		}
	}

	/**
	 * the current player adds a checker to the column of his choice, then the
	 * current player is switched
	 * 
	 * @param column
	 *            between 0 and 6
	 */
	public void addChecker(int column) {
		if (winnaar() == 0){
		
		if (column < 0 || column > 6)
			throw new IllegalArgumentException("Invalid board position");
		
		
			
		board[nextEmptySpot(0, column)][column] = currentPlayer;
		currentPlayer = -currentPlayer;
		
		}
		
		else System.out.println("Er is een winnaar:" + winnaarString());
	}

	/**
	 * checks the board for the first empty row of a given column
	 * 
	 * @param row
	 *            to check
	 * @param column
	 *            to check
	 * @return row index of first empty spot in a column
	 */
	private int nextEmptySpot(int row, int column) {
		if (board[row][column] == empty)
			return row;
		else
			return nextEmptySpot(row + 1, column);
	}
	

	public int winnaar(){
		
		int winnaar = 0;
	
		//horizontale winnaar
		
		for (int j = 0; j < columns; j++) {
			for (int i = 0; i < 3; i++){
				
				if(board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j] == 4 ){
					
					return 1;
				}
				
					if(board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j] == -4 ){
					
					return -1;
				}
				
			}
			
			
		}
		
		//vertikaal
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < 4; j++){
				
				if(board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3] == 4 ){
					
					return 1;
				}
				
				if(board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3] == -4 ){
					
					return -1;
				}
			}
		}
		
		//diagonaal links
		
		for (int j = 0; j < 4; j++) {
			for (int i = 3; i < 6; i++){
				
				if(board[i][j] + board[i-1][j+1] + board[i-2][j+2] + board[i-3][j+3] == 4 ){
					return 1;
				}
				
				if(board[i][j] + board[i-1][j+1] + board[i-2][j+2] + board[i-3][j+3] == -4 ){
					
					return -1;
				}
				
				}
				
			}
			
		
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++){
				

				if(board[i][j] + board[i+1][j+1] + board[i+2][j+2] + board[i+3][j+3] == 4 ){
					return 1;
				}
				
				if(board[i][j] + board[i+1][j+1] + board[i+2][j+2] + board[i+3][j+3] == -4 ){
					
					return -1;
				}
				
				}
				
			}
		return winnaar;
	}
	
	public String winnaarString(){
		
		String winnaar1 = "geen";
		
		if (winnaar() == 1){
			
			winnaar1 = "Winnaar Y";
			
		}
		
		if (winnaar() == -1){
			
			winnaar1 = "Winnaar R";
		}
		
		return winnaar1;
		
	}
	
	
	/**
	 * Gets the current board state
	 * @return the current state
	 */
	public int[][] getBoardState(){
		return board;
	}

	public String toString() {

		
		StringBuilder b = new StringBuilder("\n---------------\n|");
		if (winnaar() == 0){
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j < columns; j++) {
				switch (board[i][j]) {
				case yellow:
					b.append("Y");
					break;
				case red:
					b.append("R");
					break;
				case empty:
					b.append(" ");
					break;
				}
				b.append("|");
			}
			b.append("\n---------------\n");
			if (i != 0)
				b.append("|");
		}
		}

		return b.toString();
		
		
	}

	public static void main(String[] args) {
		FourInARow game = new FourInARow();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*** Four in a row ***");
		System.out.println("Enter column number between 0 and 6 to insert checker");
		System.out.print(game.toString());
		
		while(true){
			int column = scanner.nextInt();
			game.addChecker(column);
			System.out.print(game.toString());
		}
	}
	
	

}
