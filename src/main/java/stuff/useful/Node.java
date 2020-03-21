package stuff.useful;

public interface Node<T extends Node<?>> {
	
	public void attach(T n);

}
