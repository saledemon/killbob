package stuff.useful;

import javafx.scene.image.Image;

public enum Item {
	
	BURGER("burger", "hamberger.jpg"),
	FISH("fish", "fish.png"),
	LAKE("lake", "hell.jptamere"),
	BALLOON("balloon", "balloon.png");
	
	private String path = "src/main/resources/";
	private String name;
	private Image img;
	
	private Item(String name, String img) {
		this.name = name;
		this.img = new Image(path+img);
	}
	
	public String getName() {
		return name;
	}

	public Image getImage() {
		return img;
	}

	@Override
	public String toString(){
		return name;
	}

}
