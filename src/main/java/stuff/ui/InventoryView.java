package stuff.ui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import stuff.useful.Inventory;
import stuff.useful.Item;
import stuff.useful.ItemCounter;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class InventoryView extends HBox{
	
	public InventoryView(ObservableList<ItemCounter> counters) {
		super(10);
		setPrefHeight(100);
		setAlignment(Pos.CENTER_LEFT);
		setStyle("-fx-background-color: rgba(255, 0, 0, 0.5);");

		populateCells(counters);

		counters.addListener((ListChangeListener) (c -> update(c)));
	}

	private void update(Change<ItemCounter> c) {
		while(c.next()){
			if (c.wasAdded()){
				for (ItemCounter ic : c.getAddedSubList()){
					firstEmptyCell().set(ic);
				}
			} else if (c.wasRemoved()){
				for (ItemCounter ic : c.getRemoved()){
					InventoryCell cell = getCell(ic).reset();
					getChildren().remove(cell);
					getChildren().add(cell);
				}
			}
		}
	}

	private InventoryCell getCell(ItemCounter ic){
		for(Node node : getChildren()){
			if(node instanceof InventoryCell) {
				InventoryCell cell = (InventoryCell)node;
				if (cell.getItemCounter().equals(ic)) return cell;
			}
		}
		return null;
	}

	private InventoryCell firstEmptyCell(){
		for(Node node : getChildren()){
			if(node instanceof InventoryCell) {
				InventoryCell cell = (InventoryCell)node;
				if (cell.isEmpty()) return cell;
			}
		}
		return null;
	}


	private void populateCells(ObservableList<ItemCounter> counters){
		for(int i = 0 ; i < Inventory.INVENTORY_MAX_SIZE ; i++){	
			InventoryCell cell = new InventoryCell();

			if (i < counters.size()) {
				cell.set(counters.get(i));
			}

			getChildren().add(cell);
		}
	}


	private class InventoryCell extends StackPane {

		private Insets insets = new Insets(5);

		private ItemCounter counter;
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
			StackPane.setAlignment(img, Pos.CENTER);
			StackPane.setAlignment(nb, Pos.TOP_RIGHT);
			StackPane.setAlignment(name, Pos.BOTTOM_CENTER);


			setStyle("-fx-background-color: rgba(0, 125, 125, 0.75);");
			// for fun test purposes
			setOnMouseClicked(e -> counter.stack(1));
			getChildren().addAll(img, name, nb);
		}

		public void set(ItemCounter counter) {
			this.counter = counter;
			Item item = counter.getItem();
			img.setImage(item.getImage());
			name.setText(item.getName());
			nb.textProperty().bind(counter.numberProperty());
		}

		public InventoryCell reset(){
			counter = null;
			img.setImage(null);
			nb.textProperty().unbind();
			nb.setText("");
			name.setText("");
			return this;
		}

		public boolean isEmpty(){
			return counter == null;
		}

		public ItemCounter getItemCounter(){
			return counter;
		}

		@Override
		public String toString(){
			return nb.getText() + " " + name.getText();
		}

	}

}