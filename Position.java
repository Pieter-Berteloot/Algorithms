package SnakeGame;

public class Position<A, B> {
	public A x;
	public B y;

	public Position(A x, B y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Position<?, ?>) {
			Position<A, B> that = (Position<A, B>) obj;
			return (that.x == this.x && that.y == this.y);
		}
		return false;
	}

}