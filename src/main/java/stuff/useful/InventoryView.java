package stuff.useful;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;

public class InventoryView extends HBox{

	private InventoryCell[] cells;
	
	public InventoryView(ObservableList<ItemCounter> items) {
		super();

		cells = new InventoryCell[Inventory.INVENTORY_MAX_SIZE];

		update(items);

		//items.addListener((ListChangeListener<Change<ItemCounter>> c) -> update(c.getList()));
		getChildren().addAll(cells);
	}

	private void update(ObservableList<ItemCounter> items){
		for(int i = 0 ; i < items.size() ; i++){
			cells[i].set(items.get(i).getItem(), items.get(i).getNumber());
		}

		System.out.println("cells:"+cells);
	}


	private class InventoryCell extends StackPane {


		private ImageView img = new ImageView();
		private Label nb = new Label();
		private Label name = new Label();

		public void set(Item item, int number) {
			img.setImage(item.getImage());
			name.setText(item.getName());
			nb.setText(""+number);

			getChildren().addAll(img, name, nb);
		}

		@Override
		public String toString(){
			return name.getText() + "" + img.getImage() + " " + nb.getText();
		}

	}

}