package stuff.useful;

import java.util.ArrayList;

public class Inventory extends ArrayList<ItemCounter> {

	private static final long serialVersionUID = 1L;
	
	
	 // TODO Make inventory load from save file.
	 
	public Inventory() {
		
	}
	
	@Override
	public int indexOf(Object o) {
		if(o instanceof Item) {
			for (int i = 0; i < this.size() ; i++) {
				if (get(i).getItem().equals(o)) {
					return i;
				}
			}
		}
		return super.indexOf(o);
	}
	
	public void pick(Item item, int number) {
		int index = indexOf(item);
		if(index > 0) get(index).stack(number);
		else {
			add(new ItemCounter(number, item));
		}
		
	}

	public void pick(ItemCounter... item) {
		for(ItemCounter i : item) {
			if (contains(i)) {
				pick(i.getItem(), i.getNumber());
			} else {
				add(i);
			}
		}
	}

}

//because there should be 50 lines rather than 49