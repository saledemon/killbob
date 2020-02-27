package stuff.useful;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;

public class MainWindow extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			Inventory inv = new Inventory();
			inv.pick(Item.BURGER, 2);
			inv.pick(Item.FISH, 5);
			inv.pick(Item.BURGER, 4);
			
			Button but = new Button("Add Balloon");
			but.setOnAction(e -> inv.pick(Item.BALLOON, 1));

			Button but1 = new Button("Remove Burger");
			but1.setOnAction(e -> inv.drop(Item.BURGER, 1));

			TextArea area = new TextArea("Hello");
			area.setPrefHeight(300);
			InventoryView view = new InventoryView(inv.getItems());
			VBox root = new VBox(10);
			root.setFillWidth(true);
			root.getChildren().addAll(but, but1, area, view);
			VBox.setVgrow(area, Priority.ALWAYS);

			
			Scene scene = new Scene(root,1000,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());hgfchgfcgfcgfc
			primaryStage.setScene(scene);
			primaryStage.show();
	}

}
