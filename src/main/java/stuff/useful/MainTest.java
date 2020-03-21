package stuff.useful;


public class MainTest {
	
	public static void main(String[] args) {
		BobScene bob = new BobScene("src/main/java/stuff/bobscenes/start.xml");	
		
		System.out.println(bob.getRoot().deepString());
	}

}