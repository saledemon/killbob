package stuff.useful;

public class ItemCounter {
	
	private int number;
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
		this.number = number;
		this.item = item;
	}
	
	public void unstackAll() {
		unstack(this.number);
	}
	
	public int unstack(int number) {
		return this.number -= number;
	}
	
	public int stack(int number) {
		return this.number += number;
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
		return number;
	}
 
	public String toString() {
		return number+"~"+item.getName();
	}
	
}
