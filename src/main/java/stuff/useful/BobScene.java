package stuff.useful;

import javafx.geometry.Point2D;
import stuff.deed.LineDeed;

public class BobScene {

	private Root root = new Root();
	private BobSceneLoader loader;
	
	//for fun test purpouses
	protected LineDeed switchToKitchen = new LineDeed("You have successfully switched to kitchen.");

	public BobScene(String xml) {
		loader = new BobSceneLoader(this, xml);
		this.root = loader.parseXml();
	}

	

	public void addItem(Item added, Item on){
		addItem(added, coords(on));
	}

	// TODO -> add to the Item list and then notify MainWindow to update content (ObservableList / Map ?)
	public void addItem(Item added, Point2D coords){
		System.out.println(added+" was added to scene at "+coords);
	}

	// TODO -> get the coords of the item on screen (idk how still) --> Zach could do this
	public Point2D coords(Item item){
		return new Point2D(0, 0);
	}
	
	public Root getRoot() {
		return root;
	}
	
}
