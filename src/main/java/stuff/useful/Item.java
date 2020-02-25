package stuff.useful;

import javafx.scene.image.Image;

public enum Item {
	
	BURGER("burger", "hamberger.jpg"),
	FISH("fish", "fish.png"),
	BALLOON("balloon", "balloon.png");
	
	private String name;
	private Image img;
	
	private Item(String name, String img) {
		this.name = name;
		this.img = new Image(img);
	}
	
	public String getName() {
		return name;
	}

	public Image getImage() {
		return img;
	}

}
