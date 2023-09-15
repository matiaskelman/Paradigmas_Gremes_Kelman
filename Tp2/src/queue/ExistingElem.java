package queue;

public class ExistingElem extends Contenedor {
	
	public Object content;
	
	ExistingElem(Object newContent) {
		
		this.content = newContent;
	}
	
	public Object head() {
		
		return null;
		}
	public Object take() {
		
		return null;
		
	}
	@Override
	public boolean isEmpty() {
		
		return false;
	}
}
