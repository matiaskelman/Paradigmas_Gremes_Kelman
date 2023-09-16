package queue;

import java.util.List;

public class ExistingElem extends Element {
	
	ExistingElem(Object newContent) {this.content = newContent;} 
	
	@Override
	public Object head() {return this.content;}
	
	@Override
	public Object take(List<Element> list) {
		list.remove(list.size()-1);
		return this.content;
	}
	
	@Override
	public boolean isEmpty() {return false;}
}
