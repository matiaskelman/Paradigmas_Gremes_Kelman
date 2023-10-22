package Nemo;

import java.util.List;

public class DepthDangerousForCapsule extends Depth {
	public static String ERROR_MESSAGE = "Submarine has been destroyed";

	@Override
	public void decreaseDeepness(List<Depth> list) {list.remove(list.size() - 1);}

	@Override
	public void increaseDeepness(List<Depth> list) {list.add(new DepthDangerousForCapsule());}

	@Override
	public void releaseCapsule() {throw new RuntimeException(ERROR_MESSAGE);}

}
