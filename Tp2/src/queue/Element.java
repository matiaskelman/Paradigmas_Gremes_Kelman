package queue;

import java.util.List;

abstract class Element {
	
	public Object content;

	public abstract boolean isEmpty();

	public abstract Object take(List<Element> list);

	public abstract Object head();
}
