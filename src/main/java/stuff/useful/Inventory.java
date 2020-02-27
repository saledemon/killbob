package stuff.useful;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Inventory {

	private static final long serialVersionUID = 1L;
	public static final int INVENTORY_MAX_SIZE = 10;
	private ObservableList<ItemCounter> items = FXCollections.observableList(new ArrayList<ItemCounter>(INVENTORY_MAX_SIZE));
	
	
	 // TODO Make inventory load from save file.
	 
	public Inventory() {
	}
	
	public int indexOf(Item o) {
		int idx = -1;
		for (int i = 0; i < items.size() ; i++) {
			if (items.get(i).getItem().equals(o)) {
				idx = i;
			}
		}
		return idx;
	}
	
	public void pick(Item item, int number) {
		int index = indexOf(item);
		if(index >= 0){
			items.get(index).stack(number);
		} else {
			stretchInventory(new ItemCounter(item, number));
		}
	}

	/**
	* If item is not contained in inventory, simply ignores the drop request.
	*/
	public void drop(Item item, int number) {
		int index = indexOf(item);
		if(index >= 0){
			int numberLeft = items.get(index).unstack(number);
			if (numberLeft <= 0) {
				items.remove(index);
			}
		}
	}

	private void stretchInventory(ItemCounter item) {
		if (items.size() >= INVENTORY_MAX_SIZE) System.out.println("Iventory is full, you dumb duck!");
		else items.add(item);
	}

	public ObservableList getItems(){
		return items;
	}

	@Override
	public String toString() {
		return items.toString();
	}

}