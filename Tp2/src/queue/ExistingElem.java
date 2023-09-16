package queue;

public class ExistingElem extends Queue {
	
	ExistingElem(Object newContent) {
		
		this.content = newContent;
	}
	
	public Object head() {
		
		return null;
		}
	public Object take() {
		System.out.print(this.queue);
		this.queue.remove(this.size());
		System.out.print(this.queue);
		return this.content;
		
	}
	@Override
	public boolean isEmpty() {
		
		return false;
	}
}
