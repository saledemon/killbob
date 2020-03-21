package stuff.deed;

import stuff.exception.CommandException;
import stuff.ui.UIController;

public abstract class CommandDeed implements Deed {
	
	private String name; // TODO -> replace with Command Enum
	private LineDeed lineDeed;

	public CommandDeed(String line, String name){
		lineDeed = new LineDeed(line);
		this.name = name;
	}

	@Override
	public void apply(UIController ui){
		try {
			this.applyCommand(ui);
			lineDeed.apply(ui);	
		} catch (CommandException e) {
			LineDeed exceptDeed = new LineDeed(e.getMessage());
			exceptDeed.apply(ui);
		}
	}

	protected abstract void applyCommand(UIController ui) throws CommandException;

	@Override
	public String toString(){
		return name+": "+lineDeed;
	}
	
}