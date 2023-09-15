package queue;

abstract class Contenedor {
	
	public Object content;

	public abstract boolean isEmpty();

	public abstract Object take();

	public abstract Object head();
}
