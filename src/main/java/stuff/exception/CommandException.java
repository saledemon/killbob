package stuff.exception;

import java.lang.Exception;


public class CommandException extends Exception {
	
	public CommandException(String msg){
		super(msg);
	}
	
}