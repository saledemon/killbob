package stuff.useful;

public class Answer implements Node<Line> {

	
	private String answer;
	private Line line;
	
	public Answer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public void attach(Line n) {
		if (n == null) throw new NullPointerException();
		if (!(n instanceof Line)) throw new IllegalArgumentException("Given Node must be of type Line.");
		
		this.line = (Line)n;
	}
	
	public String getText() {
		return answer;
	}
	
	public Line getLine() {
		return line;
	}

}
