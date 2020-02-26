package stuff.useful;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItemCounter {
	
	private final IntegerProperty number = new SimpleIntegerProperty();
	private final StringProperty strNumber = new SimpleStringProperty();
	private Item item;
	
	/**
	 * Initialize un compteur d'item à 1.
	 * @param item
	 */
	public ItemCounter(Item item) {
		this(item, 1);
	}
	
	/**
	 * Initialize un compteur d'item au nombre spécifié
	 * 
	 * @param number
	 * @param item
	 */
	public ItemCounter(Item item, int number) {
		this.number.addListener((obs, oldV, newV) -> strNumber.setValue(""+newV));
		this.number.setValue(number);
		this.item = item;
	}
	
	public void unstackAll() {
		unstack(number.getValue());
	}
	
	public int unstack(int number) {
		return stack(-number);
	}
	
	public int stack(int number) {
		this.number.setValue(this.number.getValue() + number);
		return this.number.getValue();
	}
	
	public Item getItem() {
		return item;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ItemCounter) {
			return item.equals(((ItemCounter)obj).getItem());
		}
		return super.equals(obj);
	}

	public int getNumber() {
		return number.getValue();
	}
 
	public String toString() {
		return number.getValue()+"~"+item.getName();
	}

	public StringProperty numberProperty(){
		return strNumber;
	}
	
}
