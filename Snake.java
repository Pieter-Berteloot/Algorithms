package SnakeGame;

import java.util.Scanner;
import java.util.Random;

public class Snake {

	private final int empty = 0, tekenBody = 1, tekenHead = 2, tekenFood = 3;
	private int rows = 7, columns = 10, score = 0;;
	private int board[][] = new int[rows][columns];
	private Position<Integer, Integer> head = new Position<Integer, Integer>(3, 4);
	private List<Position<Integer, Integer>> snake = new List<Position<Integer, Integer>>(head);
	private Position<Integer, Integer> food = new Position<Integer, Integer>(3, 3);

	public Snake() {
		clearBoard();
		board[head.y][head.x] = 2;
		board[food.y][food.x] = 3;
	}

	private void clearBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = empty;
			}
		}
	}

	public int[][] getBoardState() {
		return board;
	}

	public void links() {

		if (head.x > 0) {
			head.x--;
			if (head.x.equals(snake.head().get().x) && head.y.equals(snake.head().get().y)) {
				beweging(snake.head().get().x + 1, head.y);
			} else {
				beweging(snake.head().get().x, snake.head().get().y);
			}
		} else {
			System.out.println("Game over");
			System.exit(0);
		}

	}

	public void rechts() {
		if (head.x < columns - 1) {
			head.x++;

			if (head.x.equals(snake.head().get().x) && head.y.equals(snake.head().get().y)) {
				beweging(snake.head().get().x - 1, head.y);
			} else {
				beweging(snake.head().get().x, snake.head().get().y);
			}
		} else {
			System.out.println("Game over");
			System.exit(0);
		}

	}

	public void onder() {
		if (head.y > 0) {
			head.y--;

			if (head.x.equals(snake.head().get().x) && head.y.equals(snake.head().get().y)) {
				beweging(snake.head().get().x, head.y + 1);
			} else {
				beweging(snake.head().get().x, snake.head().get().y);
			}
		} else {
			System.out.println("Game over");
			System.exit(0);
		}
	}

	public void boven() {
		if (head.y < rows - 1) {
			head.y++;
			if (head.x.equals(snake.head().get().x) && head.y.equals(snake.head().get().y)) {
				beweging(snake.head().get().x, head.y - 1);
			} else {
				beweging(snake.head().get().x, snake.head().get().y);
			}
		} else {
			System.out.println("Game over");
			System.exit(0);
		}

	}

	private void newFood() {
		Random rn = new Random();
		food.x = rn.nextInt(columns - 1);
		food.y = rn.nextInt(rows - 1);

		if (snake.contains(new Position<Integer, Integer>(food.x, food.y)) || (head.x == food.x && head.y == food.y)) {
			newFood();
		}

		else {
			board[food.y][food.x] = tekenFood;
		}
	}

	public void beweging(int oldX, int oldY) {

		if (snake.contains(new Position<Integer, Integer>(head.x, head.y))) {
			System.out.println("Game over");
			System.exit(0);
			return;
		}

		if (food.x == head.x && food.y == head.y) {
			score++;
			newFood();
			snake.prepend(new Node<Position<Integer, Integer>>(new Position<Integer, Integer>(oldX, oldY)));
			board[oldY][oldX] = tekenBody;
		}

		else {

			board[oldY][oldX] = empty;
		}

		Node<Position<Integer, Integer>> cursor = snake.head();

		while (cursor.next() != null) {
			cursor.set(cursor.next().get());
			cursor = cursor.next();
			board[cursor.get().y][cursor.get().x] = tekenBody;
		}

		Position<Integer, Integer> newP = new Position<Integer, Integer>(head.x, head.y);
		board[head.y][head.x] = tekenHead;
		cursor.set(newP);
	}

	public String toString() {
		StringBuilder stringB = new StringBuilder("\n---------------------\n|");
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j < columns; j++) {
				switch (board[i][j]) {

				case tekenBody:
					stringB.append("X");
					break;

				case tekenHead:
					stringB.append("O");
					break;

				case tekenFood:
					stringB.append("#");
					break;

				case empty:
					stringB.append(" ");
					break;
				}
				stringB.append("|");
			}
			stringB.append("\n---------------------\n");
			if (i != 0)
				stringB.append("|");
		}
		stringB.append("\n-------Score:" + score + "-------\n");
		return stringB.toString();
	}

	public static void main(String[] args) {
		Snake game = new Snake();

		Scanner scanner = new Scanner(System.in);

		System.out.println("--------Snake--------");
		System.out.print(game.toString());

		while (true) {
			String input = scanner.next();
			switch (input) {
			case "q":
				game.links();
				System.out.print(game.toString());
				break;
			case "d":
				game.rechts();
				System.out.print(game.toString());
				break;
			case "z":
				game.boven();
				System.out.print(game.toString());
				break;
			case "s":
				game.onder();
				System.out.print(game.toString());
				break;
			}
		}
	}
}
