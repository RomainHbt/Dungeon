package special;

import item.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory{
	private Map<String, Item> items;
	
	
	
	public Inventory(){
		items = new HashMap<>();
	}
	
	public Inventory(Map<String, Item> items) {
		this.items = items;
	}
	
	
	
	
	public void takeItem(Inventory destination, String itemName){
		destination.addItem(itemName, items.get(itemName));
		items.remove(itemName);
	}
	
	public void addItem(String itemName, Item item){
		items.put(itemName, item);
	}
	
	public Item getItem(String itemName){
		return items.get(itemName);
	}
}
