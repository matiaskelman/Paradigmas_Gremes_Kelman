package Nemo;

import java.util.List;

public class DepthOne extends Depth {

	DepthOne(){}

	@Override
	public Object releaseMissile() {
		return true;
	}

	@Override
	public Object ascend(List<Depth> list) {
		list.remove(list.size() - 1);
		return this.content;
	}
}
