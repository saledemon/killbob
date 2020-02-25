package stuff.useful;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends ArrayList<ItemCounter> {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * TODO Make inventory load from save file.
	 */
	public Inventory() {
		
	}
	
	@Override
	public int indexOf(ItemCounter o) {
		
		
		return super.indexOf(o);
	}
	
	public void stack(Item item, int number) {
		int index = items.inde
	}

	public void pick(ItemCounter... item) {
	
		for(ItemCounter i : item) {
			if (contains(i)) {
				stack(i.getItem(), i.getNumber());
			} else {
				add(i);
			}
		}
	}

}
