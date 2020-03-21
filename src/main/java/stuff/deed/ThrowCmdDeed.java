package stuff.deed;

import stuff.useful.Item;
import stuff.exception.CommandException;
import stuff.ui.UIController;

public class ThrowCmdDeed extends CommandDeed {
	
	private Item thrown;
	private Item at;

	public ThrowCmdDeed(Item thrown, Item at){
		super(at+" is deeply hurt by the "+thrown, "throw");
		this.thrown = thrown;
		this.at = at;
	}

	@Override
	protected void applyCommand(UIController ui) throws CommandException{
		if (ui.getPlayer().drop(thrown, 1)) {
			ui.getBobScene().addItem(thrown, at);
		} else {
			throw new CommandException("No "+thrown+" to be thrown.\nLook at yourself, this is shameful.");
		}
	}
	
}
