package queue;

import java.util.ArrayList;
import java.util.List;


public class Queue extends Contenedor {
	
	public List<Object> objects = new ArrayList<>();
	Queue() {
		//queues.add(new ContenedorVacio());
		};
	
	

  public boolean isEmpty() { return (this.objects.isEmpty()); }

  
	public Queue add( Object  cargo ) {
		objects.add( cargo );
		return this;
	};

	public Object take() {
		Object lastElem = "";
		try {
		lastElem = head();
		this.objects.remove(0);
		}
		catch( Exception e ) {
				e.printStackTrace();
	
		}
		return lastElem;
	};

	public Object head() {
		
    return objects.get(0);
	};

	public int size() {
	return objects.size();	
	};
}
