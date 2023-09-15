package queue;

abstract class Contenedor {
	
//	public Object contenido = 0;
//	
//	Contenedor(Object contenido) {
//		this.contenido = contenido;
//	};
	
	public abstract boolean isEmpty();

	public abstract Object take();

	public abstract Object head();
}
