package Nemo;

public class Coordenadas {
	int x;
	int y;
	int z;

	public Coordenadas(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void descend() {
		this.z = this.z - 1;
	}

	public void ascend() {
		if (this.z >= 0) {

		} else {
			this.z = this.z + 1;
		}
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

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
}
