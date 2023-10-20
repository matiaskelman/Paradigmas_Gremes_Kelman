package Nemo;

import java.util.List;

public class DepthZero extends Depth {
	
	Error errorMessage = new Error("Nemo can not go up");
	
	@Override
	public Object ascend(List<Depth> list) {
		throw errorMessage;
	}
	
	@Override
	public Object releaseMissile() {return true;}
	
}
