package Nemo;

public class Coordinates {
	int x;
	int y;

	public Coordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Coordinates moveX(int move) {
		this.x = this.x + move;
		return this;
	}

	public Coordinates moveY(int move) {
		this.y = this.y + move;
		return this;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
