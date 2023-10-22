package Nemo;

import java.util.List;

public class DepthZero extends Depth {

	public static String ERROR_MESSAGE = "Nemo can not go up any further";
	
	@Override
	public void decreaseDeepness(List<Depth> list) {throw new RuntimeException(ERROR_MESSAGE);}

	@Override
	public void increaseDeepness(List<Depth> list) {list.add(new DepthOne());}

	@Override
	public void releaseCapsule() {}
}
