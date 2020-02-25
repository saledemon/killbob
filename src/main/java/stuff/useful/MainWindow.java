package stuff.useful;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class MainWindow extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			Inventory inv = new Inventory();
			inv.pick(Item.BURGER, 2);
			inv.pick(Item.FISH, 5);
			inv.pick(Item.BALLOON, 5);
			inv.pick(Item.BURGER, 4);

			System.out.println(inv);

			ImageView view = new ImageView(Item.BURGER.getImage());
			
			//InventoryView view = new InventoryView(inv.getItems());
			BorderPane root = new BorderPane(view);
			
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	}

}
