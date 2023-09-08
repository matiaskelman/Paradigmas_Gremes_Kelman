package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	public List<Object> queues = new ArrayList<>();
	
	

  public boolean isEmpty() { return (this.queues.isEmpty()); }

  
	public Queue add( Object  cargo ) {
		queues.add( cargo );
		return this;
	}

	public Object take() {
		Object lastElem = head();
		this.queues.remove(0);
		return lastElem;
	}

	public Object head() {
		
    return queues.get(0);
	}

	public int size() {
	return queues.size();	
	}
}
