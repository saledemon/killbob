package stuff.useful;

import java.util.ArrayList;
import java.util.List;

import stuff.deed.Deed;
import stuff.exception.WTFException;

public class Line implements Node<Answer> {

		private String text;
		private Deed deed;
		private List<Answer> answers = new ArrayList<>();

		public Line(String line){
			this.text = line;
		}
		
		public Line(String line, Deed deed) {
			this(line);
			this.deed = deed;
		}

		@Override
		public void attach(Answer n) {
			if (n == null) throw new NullPointerException();
			if (!(n instanceof Answer)) throw new IllegalArgumentException("Given Node must be of type Answer.");
			
			answers.add((Answer)n);
		}

		public String getText() {
			return text;
		}

		public List<Answer> getAnswers() {
			return answers;
		}
		
		public Line getLine(Answer answer) {
			return getLine(answer.getText());
		}
		
		public Line getLine(String answerText) {
			for(Answer ans : answers) {
				if (ans.getText().equals(answerText)) {
					return ans.getLine();
				}
			}
			
			throw new IllegalArgumentException(answerText+" was not found in Line.");
		}
		
		public Deed getDeed() {
			return deed;
		}
		
		/**
		 * Utilitary method to get the text of every children line.
		 * @param l Line to traverse
		 * @return A representation of it's direct children
		 */
		public String shallowString(boolean includeThisLine) {
			String shallowString = includeThisLine ? "Line : "+this.getText() : "";
			
			for (Answer ans : this.getAnswers()) {
				shallowString += "\n  Answer : "+ans.getText();
				
				if(ans.getLine() != null) {
					shallowString += "\n    Line : "+ans.getLine().getText();
				}
			}
			
			return shallowString;
		}
		
		public String shallowAnswers(boolean includeThisLine) {
			String shallowAnswers = this.getText()+"\n";
			
			for(Answer ans : answers) {
				shallowAnswers += "Answer : "+ans.getText()+"\n";
			}
			
			return shallowAnswers;
		}
		
		public String shallowLines() {
			String shallowLines = "";
			
			for(Answer ans : answers) {
				shallowLines += "Line : "+ans.getLine().getText()+"\n";
			}
			
			return shallowLines;
		}
		
		
		public boolean isTerminal() {
			if (answers.size() == 0) {
				return true;
			}
			
			for(Answer ans : answers) {
				if (ans.getLine() != null) {
					return false;
				}
			}
			
			return true;
		}
		
		public static Root asRoot(Line line) {
			Root root = new Root();
			root.attach(line);
			return root;
		}

	}