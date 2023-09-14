package queue;

import java.util.ArrayList;
import java.util.List;


public class Queue {
	
	public List<Contenedor> queues = new ArrayList<>();
	
	

  public boolean isEmpty() { return (this.queues.isEmpty()); }

  
	public Queue add( Object  cargo ) {
		queues.add( cargo );
		return this;
	}

	public Object take() {
		Object lastElem = "";
		try {
		lastElem = head();
		this.queues.remove(0);
		}
		catch( Exception e ) {
				e.printStackTrace();
	
		}
		return lastElem;
	}

	public Object head() {
		
    return queues.get(0);
	}

	public int size() {
	return queues.size();	
	}
}
abstract class Contenedor {
	
	public Object take() {
		
	}
}
abstract class ContenedorVacio extends Contenedor {
	
	public Object take() {return "this list is empty";}
	
	public Object head() {return "this list is empty";}
	
}
abstract class ContenedorLleno extends Contenedor {
	
	public Object head() {
		
		}
	
}
