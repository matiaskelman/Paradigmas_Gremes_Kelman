package Nemo;

import java.util.List;

public class DepthDeep extends Depth {

	private Error errorMessage = new Error("Can not release missile form this depth");

	DepthDeep() {}

	@Override
	public Object ascend(List<Depth> list) {
		list.remove(list.size() - 1);
		return this.content;
	}

	@Override
	public Object releaseMissile() {
		{
			throw errorMessage;
		}
	}
}
