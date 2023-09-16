package queue;

import java.util.ArrayList;
import java.util.List;


public class Queue extends Contenedor {
	
	public List<Contenedor> queue;
	
	Queue() {
		queue = new ArrayList<Contenedor>();
		this.queue.add(new NullElem());
	}
	
	

	public boolean isEmpty() 
	{ return this.queue.get(this.size()).isEmpty();}
	
	
	public Queue add( Object cargo ) {
		this.queue.add(1, new ExistingElem(cargo) );
		//System.out.print(this.queue);
		return this;
	};
	public Object take() {
		Object objeto = this.queue.get(this.size()).take();
		this.queue.remove(this.size());
		return objeto;
		
		
//		Contenedor removedItem = this.queue.get(this.size());
//		this.queue.remove(this.size());
//		return removedItem.content;
	};

	public Object head() {
	//System.out.print(this.queue.get(1).content);
    return this.queue.get(this.size()).head();
	};

	public int size() {
	return queue.size()-1;	
	};
	
 }
