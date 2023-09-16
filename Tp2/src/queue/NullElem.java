package queue;

import java.util.List;

public class NullElem extends Element {
	
	Error errorMessage = new Error("Queue is empty");
	
	@Override
	public Object take(List<Element> list) {throw errorMessage;}
	
	@Override
	public Object head() {throw errorMessage;}

	@Override
	public boolean isEmpty() {return true;}
	
}
