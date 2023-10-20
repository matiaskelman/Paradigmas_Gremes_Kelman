package Nemo;

import java.util.ArrayList;
import java.util.List;

public class DepthManager {
	public List<Depth> depth;

	DepthManager() {
		depth = new ArrayList<Depth>();
		this.depth.add(new DepthZero());
	}

	public DepthManager descend() {
		this.depth.add(this.size() + 1, new DepthDeep());
		return this;
	}

	public Object ascend() {
		return this.depth.get(this.size()).ascend(this.depth);
	}

	public Object releaseMissile() {
		return this.depth.get(this.size()).releaseMissile();
	}

	public int size() {
		return depth.size() - 1;
	}

}
