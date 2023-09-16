package queue;

public class NullElem extends Contenedor {
	
	
	@Override
	public Object take() {throw new RuntimeException("Queue is empty");}
	
	@Override
	public Object head() {throw new RuntimeException("Queue is empty");}

	@Override
	public boolean isEmpty() { return true;}
	
}
