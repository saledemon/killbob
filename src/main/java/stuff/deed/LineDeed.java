package stuff.deed;

import stuff.ui.UIController;

public class LineDeed implements Deed {

	protected String line;

	public LineDeed(String line){
		this.line = line;
	}

	@Override
	public void apply(UIController ui){
		ui.appendLine(line);
	}

	@Override
	public String toString(){
		return line;
	}
}