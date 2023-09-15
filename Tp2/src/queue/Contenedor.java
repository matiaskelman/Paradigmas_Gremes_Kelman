package queue;

abstract class Contenedor {
	
	public abstract boolean isEmpty();

	public abstract Object take();

	public abstract Object head();
}