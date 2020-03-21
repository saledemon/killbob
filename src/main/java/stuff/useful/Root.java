package stuff.useful;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Root implements Node<Line> {
	
	private List<Line> lines = new ArrayList<>();

	@Override
	public void attach(Line n) {
		if (!(n instanceof Line)) throw new IllegalArgumentException("Given Node must be of type Line.");
		
		lines.add((Line)n);
	}
	
	public String shallowString() {
		String shallowString = "";
		int i = 1;
		
		for (Line l : lines) {
			shallowString += "\nLine "+i+" : "+l.getText();
			i++;
		}
		
		return shallowString;
	}

	/**
	 * Returns a view of all the lines in the <code>Root</code>.
	 * @params includeAnswers <code>true</code> to include the answers into the output.
	 * <code>false</code> to only include the lines.  
	 */
	public String deepString() {
		String deepString = "";
		for(Line line : lines) {
			
			deepString += deepenString("", line, 0)+"\n---------------\n";
			
		}
		
		
		return deepString;
	}
	
	
	private String deepenString(String deepString, Line line, int indent) {
		
		String tabs = calcIndentation(indent);
		
		if (line.isTerminal()) {
			
			deepString += tabs+"Line : "+line.getText()+"\n";
			
			for(Answer ans : line.getAnswers()) {
				deepString += tabs+"  "+"Answer : "+ans.getText()+"\n";
			}
			
			return deepString;
		}
		
		deepString += tabs+"Line : "+line.getText()+"\n";
		
		for(Answer ans : line.getAnswers()) {
			deepString += tabs+"  "+"Answer : "+ans.getText()+"\n";
			
			if(ans.getLine() != null) {
				deepString += deepenString("", ans.getLine(), indent+2);
			}
		}
		
		return deepString;
	}
	
	
	private String calcIndentation(int indent) {
		StringBuilder tabs = new StringBuilder("");
		IntStream.range(0, indent).forEach(e -> tabs.append("  "));
		return tabs.toString();
	}

	public List<Line> getLines(){
		return lines;
	}
}
