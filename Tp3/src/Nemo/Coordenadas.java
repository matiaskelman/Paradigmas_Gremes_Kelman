package Nemo;

public class Coordenadas {
	int x;
	int y;

	public Coordenadas(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void moverX(int mover) {
		this.x = this.x + mover;
	}

	public void moverY(int mover) {
		this.y = this.y + mover;
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
