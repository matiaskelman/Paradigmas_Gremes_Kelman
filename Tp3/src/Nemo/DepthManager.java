package Nemo;

import java.util.ArrayList;
import java.util.List;

public class DepthManager {
	private List<Depth> depth;

	DepthManager() {
		depth = new ArrayList<Depth>();
		this.depth.add(new DepthZero());
	}

	public void descend() {this.depth.get(this.size()).increaseDeepness(this.depth);}

	public void ascend() {this.depth.get(this.size()).decreaseDeepness(this.depth);}

	public void releaseCapsule() {this.depth.get(this.size()).releaseCapsule();}

	public int size() {return depth.size() - 1;}
}
