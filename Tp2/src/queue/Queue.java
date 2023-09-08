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
		queues.clear();
		return this;
	}

	public Object head() {

    return null;
	}

	public int size() {

		return 0;
	}
}
