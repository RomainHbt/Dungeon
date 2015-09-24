package special;

import item.Item;
import item.Key;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
	
	/**
	 * @param itemName The item you want to test.
	 * @return true if the item is in the inventory, false otherwise.
	 */
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
	
	/**
	 * Use to have a Collection of all item in the inventory
	 * @return A Collection of all item
	 */
	public Collection<Item> getValues(){
		return this.items.values();
	}
	
	public List<Key> getKeys(){
		List<Key> keyList = new ArrayList<>();
		for (Item item : this.getValues()) {
			if(item instanceof Key)
				keyList.add((Key) item);
		}
		
		return keyList;
	}
}
