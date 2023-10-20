package Nemo;

import java.util.List;


public class DepthDeep extends Depth {
	
	Error errorMessage = new Error("Queue is empty");
	
	@Override
	public Object take(List<Element> list) {throw errorMessage;}
	
	@Override
	public Object head() {throw errorMessage;}

	@Override
	public boolean isEmpty() {return true;}

	@Override
	public Object take(List<Element> list) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
