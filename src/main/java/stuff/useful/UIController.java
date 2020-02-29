package stuff.useful;

import stuff.deed.Deed;
import stuff.exception.BufferException;
import java.lang.NullPointerException;

public class UIController {
	
	private MainWindow window;
	private Deed buffer = null; //encapsulate in a class in order to make a multi-deed buffer FIFO

	public UIController(MainWindow window){
		this.window = window;
	}

	public void execute(Deed deed){
		deed.apply(this);
	}

	public void appendLine(String line){
		System.out.println(line);
	}

	/**
	* TODO multi-deed buffer FIFO
	*/
	public void buffer(Deed deed) throws BufferException{
		if (isBuffered()) throw new BufferException("Buffer is not empty, WTH is wrong with you ???");
		if (deed == null) throw new NullPointerException("You fuck thwat trying to pass me an empty deed!");
		buffer = deed;
	}

	public boolean isBuffered(){
		return buffer != null;
	}

	public Player getPlayer(){
		return window.getPlayer();
	}

	public BobScene getBobScene(){
		return getPlayer().getBobScene();
	}
	
}