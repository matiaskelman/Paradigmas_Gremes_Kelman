package Nemo;

import java.util.List;

public class DepthSurface extends Depth {
	
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
