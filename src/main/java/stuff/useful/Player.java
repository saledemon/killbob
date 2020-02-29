package stuff.useful;

public class Player extends Inventory {

	private BobScene currentBobScene = new BobScene();

	public BobScene getBobScene(){
		return currentBobScene;
	}

}
