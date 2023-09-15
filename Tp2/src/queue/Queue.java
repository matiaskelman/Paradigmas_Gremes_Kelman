package queue;

import java.util.ArrayList;
import java.util.List;


public class Queue extends Contenedor {
	
	public List<Contenedor> objects;// = new ArrayList<>(List.of(createNullElem()));
	
	//objects.add(new NullElem());
	Queue() {
		objects = new ArrayList<Contenedor>();
		add(new NullElem());
	}
	
	

  public boolean isEmpty() { return this.objects.get(0).isEmpty();}//objects.get((objects.size())-1).isEmpty();}
// 							 return objects.getIndex(objects.length()-1).isEmpty();
  
	public Queue add( Object cargo ) {
		objects.add(new ExistingElem(cargo) );
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
	
	public Contenedor createNullElem() {
		return new NullElem();
	}
 }
