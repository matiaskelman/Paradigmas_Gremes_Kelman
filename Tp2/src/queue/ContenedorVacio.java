package queue;

public class ContenedorVacio extends Queue {
	
	
	@Override
	public Object take() {return "this list is empty";}
	
	@Override
	public Object head() {return "this list is empty";}

	@Override
	public boolean isEmpty() { return true; }
	
}