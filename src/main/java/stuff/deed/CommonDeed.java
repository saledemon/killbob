package stuff.deed;

import stuff.exception.BufferException;
import stuff.ui.UIController;

public abstract class CommonDeed implements Deed {
	
	private CommandDeed cmdDeed;
	private LineDeed lineDeed;

	public CommonDeed(CommandDeed cmdDeed, LineDeed lineDeed){
		this.cmdDeed = cmdDeed;
		this.lineDeed = lineDeed;
	}

	@Override
	public void apply(UIController ui){
		cmdDeed.apply(ui);
		try {
			ui.buffer(lineDeed);
		} catch (BufferException e) {
			e.printStackTrace();
		}
		
	}

}