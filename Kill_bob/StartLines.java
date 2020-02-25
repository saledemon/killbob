package Kill_bob;

public enum StartLines {
Q0("Hi there."),
Q1("I'm Bob. Who are you?"),
A11("I... I don't know."),
A12("Poopy mc-fart"),
Q21("Oh my. It seems you have fallen on your head. You know what "
            + "always seems to help in situations like these?"),
Q22("haha, very funny. I think you could use something. Do you know what I mean?"),
A21("No"),
A22("Your mom"),
Q31("Having fun!! So what do you say we swing by the aquarium or the attraction parc?"),
Q32("Ok smartass, its seems you're just about mature enough for an attraction parc or an aquarium."
		+ " What do you say?"),
A31("Sure. I do like fish. I think..."),
Q41("Alright, the aquarium it is!!"),
A32("Lets go to the attraction parc!! ... aparently I'm a bit of an adrenaline junkie"),
Q42("Well ok then, lets head to the attraction parc!");

	private String sentence;
	
	StartLines(String line) {
		this.sentence = line;
	}
	
	public String getLine() {
		return sentence;
	}

}
