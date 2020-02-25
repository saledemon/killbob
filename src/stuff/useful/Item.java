package stuff.useful;

import javafx.scene.image.Image;

public enum Item {
	
	BURGER("burger", "images/hamberger.jpg"),
	FISH("fish", "images/fish.png"),
	BALLOON("balloon", "images/ballon.png");
	
	private String name;
	private Image img;
	
	private Item(String name, String img) {
		this.name = name;
		
		this.img = new Image(img);
	}
	
	public String getName() {
		return name;
	}

	public Image getImg() {
		return img;
	}

}
