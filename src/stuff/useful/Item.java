package stuff.useful;

import javafx.scene.image.Image;

public enum Item {
		
		BURGER("burger", "../resources/burger.png");
		
		private String name;
		private Image img;
		
		private Item(String name, String img) {
			this.name = name;
			this.img = new Image(img);
		}

}
