package stuff.useful;

public class Player extends Inventory {

	private BobScene currentBobScene = new BobScene("src/main/java/stuff/bobscenes/start.xml");

	public BobScene getBobScene(){
		return currentBobScene;
	}

}
