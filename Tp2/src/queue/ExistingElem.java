package queue;

public class ExistingElem extends Queue {
	
	ExistingElem(Object newContent) {
		
		this.content = newContent;
	}
	
	public Object head() {
		
		return null;
		}
	public Object take() {
		return this.content;
		
	}
	@Override
	public boolean isEmpty() {
		
		return false;
	}
}
