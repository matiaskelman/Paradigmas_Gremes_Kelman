package Nemo;

import java.util.List;

public class DepthOne extends Depth {

	DepthOne(){}

	@Override
	public void releaseCapsule() {}

	@Override
	public void decreaseDeepness(List<Depth> list) {list.remove(list.size() - 1);}

	@Override
	public void increaseDeepness(List<Depth> list) {list.add(new DepthDangerousForCapsule());}
}
