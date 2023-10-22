package Nemo;

import java.util.List;

abstract class Depth {

	public abstract void decreaseDeepness(List<Depth> list);

	public abstract void increaseDeepness(List<Depth> list);

	public abstract void releaseCapsule();
	
}
