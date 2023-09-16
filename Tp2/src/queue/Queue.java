package queue;

import java.util.ArrayList;
import java.util.List;


public class Queue {
	
	public List<Element> elements;
	
	Queue() {
		elements = new ArrayList<Element>();
		this.elements.add(new NullElem());
	}

	public boolean isEmpty() {return this.elements.get(this.size()).isEmpty();}
	
	public Queue add( Object cargo ) {
		this.elements.add(1, new ExistingElem(cargo) );
		return this;
	}
	
	public Object take() {return this.elements.get(this.size()).take(this.elements);}

	public Object head() {return this.elements.get(this.size()).head();}

	public int size() {return elements.size()-1;}
	
 }
