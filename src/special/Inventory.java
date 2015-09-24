package special;

import item.Item;

import java.util.Collection;
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
	
	/**
	 * Move the item corresponding to itemName from this to destination
	 * The item moved is remove from this
	 * @param destination
	 * @param itemName
	 */
	public void takeItem(Inventory destination, String itemName){
		destination.addItem(itemName, items.remove(itemName));
	}
	
	public void addItem(String itemName, Item item){
		items.put(itemName, item);
	}
	
	public Item getItem(String itemName){
		return items.get(itemName);
	}
	
	public boolean exist(String itemName){
		return items.get(itemName) != null;
	}
	
	public boolean isEmpty(){
		return items.isEmpty();
	}
	
	public void removeItem(String itemName){
		items.remove(itemName);
	}
	
	public String toString(){
		String res = "";
		for (String key : items.keySet()) {
			res += key + "\t";
		}
		return res;
	}
	
	public Collection<Item> getValues(){
		return this.items.values();
	}
}
