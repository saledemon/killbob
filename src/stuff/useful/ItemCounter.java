package stuff.useful;

public class ItemCounter {
	
	private int number;
	private Item item;
	
	/**
	 * Initialize un compteur d'item à 1.
	 * @param item
	 */
	public ItemCounter(Item item) {
		this(1, item);
	}
	
	/**
	 * Initialize un compteur d'item au nombre spécifié
	 * 
	 * @param number
	 * @param item
	 */
	public ItemCounter(int number, Item item) {
		this.number = number;
		this.item = item;
	}
	
	public void dropAll() {
		drop(number);
	}
	
	public void drop(int number) {
		this.number -= number;
	}
	
	public void stack(int number) {
		this.number += number;
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
	
}
