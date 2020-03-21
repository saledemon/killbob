package stuff.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.geometry.Point2D;

import stuff.deed.*;
import stuff.useful.Item;
import stuff.useful.Player;


public class MainWindow extends Application {

	private Player player = new Player(); // TODO -> Init player form file
	private UIController controller = new UIController(this);
	
	@Override
	public void start(Stage primaryStage) throws Exception {

			player.pick(Item.BURGER, 2);
			player.pick(Item.FISH, 5);
			player.pick(Item.BURGER, 4);
			
			Button throwBut = new Button("Throw Balloon");
			throwBut.setOnAction(e -> controller.execute(new ThrowCmdDeed(Item.BALLOON, Item.LAKE)));

			Button but = new Button("Add Balloon");
			but.setOnAction(e -> player.pick(Item.BALLOON, 1));

			Button but1 = new Button("Remove Burger");
			but1.setOnAction(e -> player.drop(Item.BURGER, 1));

			TextArea area = new TextArea("Hello");
			area.setPrefHeight(300);
			InventoryView view = new InventoryView(player.getItems());
			VBox root = new VBox(10);
			root.setFillWidth(true);
			root.getChildren().addAll(but, but1, throwBut, area, view);
			VBox.setVgrow(area, Priority.ALWAYS);

			
			Scene scene = new Scene(root,1000,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());hgfchgfcgfcgfc
			primaryStage.setScene(scene);
			primaryStage.show();
	}


	public Player getPlayer(){
		return player;
	}
}
