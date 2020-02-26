package stuff.useful;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class InventoryView extends HBox{

	private InventoryCell[] cells = new InventoryCell[Inventory.INVENTORY_MAX_SIZE];
	
	public InventoryView(ObservableList<ItemCounter> counters) {
		super(10);
		setPrefHeight(100);
		setAlignment(Pos.CENTER_LEFT);
		setStyle("-fx-background-color: rgba(255, 0, 0, 0.5);");

		populateCells(counters);

		//counters.addListener((ListChangeListener) (c -> update(c.getAdded(), c.getRemoved())));
		getChildren().addAll(cells);
	}

	private void update(ItemCounter[] added, ItemCounter[] removed) {
		//TODO
	}


	private void populateCells(ObservableList<ItemCounter> counters){
		for(int i = 0 ; i < cells.length ; i++){	
			cells[i] = new InventoryCell();
			

			if (i < counters.size()) {
				cells[i].set(counters.get(i));
			}

			System.out.println(i+" cells:"+cells[i]);
		}
	}


	private class InventoryCell extends StackPane {

		private Insets insets = new Insets(5);

		private ImageView img = new ImageView();
		private Label nb = new Label();
		private Label name = new Label();

		public InventoryCell() {
			super();
			setPrefWidth(100);
			setPrefHeight(100);
			HBox.setMargin(this, insets);
			img.setFitWidth(80);
			img.setCache(true);
			img.setPreserveRatio(true);
		}

		public void set(ItemCounter counter) {
			Item item = counter.getItem();
			img.setImage(item.getImage());
			name.setText(item.getName());
			nb.textProperty().bind(counter.numberProperty());

			getChildren().addAll(img, name, nb);
		}

		@Override
		public String toString(){
			return nb.getText() + " " + name.getText();
		}

	}

}