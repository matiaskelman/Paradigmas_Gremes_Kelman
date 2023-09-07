package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	public List<Object> queues = new ArrayList<>();

  public boolean isEmpty() { return queues.isEmpty(); }

	public Queue add( Object  cargo ) {
		queues.add( cargo );
		return this;
	}

	public Object take() {
		queues.remove(0);
		return null;
	}

	public Object head() {

    return null;
	}

	public int size() {

		return 0;
	}

}
