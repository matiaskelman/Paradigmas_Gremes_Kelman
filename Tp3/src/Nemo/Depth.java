package Nemo;

import java.util.List;

abstract class Depth {

	public Object content;

	public abstract Object ascend(List<Depth> list);

	public abstract Object releaseMissile();
	
}
