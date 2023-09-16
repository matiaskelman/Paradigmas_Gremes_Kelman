package queue;

public class NullElem extends Contenedor {
	
	Error errorMessage = new Error("Queue is empty");
	@Override
	public Object take() {throw errorMessage;}
	
	@Override
	public Object head() {throw errorMessage;}

	@Override
	public boolean isEmpty() { return true;}
	
}
