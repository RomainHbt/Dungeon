package special;

import item.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory{
	private Map<String, Item> items;
	
	public Map<String, Item> getItems() {
		return items;
	}

	public void setItems(Map<String, Item> items) {
		this.items = items;
	}

	public Inventory(){
		items = new HashMap<>();
	}
	
	public Inventory(Map<String, Item> items) {
		this.items = items;
	}
	
}
