package special;

import item.Item;
import item.Key;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Inventory{
	private Map<String, Item> items;
	
	public Inventory(){
		items = new HashMap<>();
	}
	
	/**
	 * Build an Inventory with all object of items
	 * @param items The list of object you want to add
	 */
	public Inventory(Map<String, Item> items) {
		this.items = items;
	}
	
	/**
	 * Move the item corresponding to itemName from this to destination
	 * The item moved is remove from this
	 * @param destination The inventory you want to put the item
	 * @param itemName The item you want to move
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
	
	/**
	 * Generate a String with all names Item separate with \t
	 */
	public String toString(){
		String res = "";
		for (String key : items.keySet()) {
			res += key + "\t";
		}
		return res.length()>0 ? res.substring(0, res.lastIndexOf('\t')) : res;
	}
	
	/**
	 * Use to have a Collection of all item in the inventory
	 * @return A Collection of all item
	 */
	public Collection<Item> getValues(){
		return this.items.values();
	}
	
	/**
	 * @return all the key of the inventory in a List
	 */
	public List<Key> getKeys(){
		List<Key> keyList = new ArrayList<>();
		for (Entry<String, Item> entry : this.items.entrySet()) {
			if(entry.getValue() instanceof Key)
				keyList.add((Key) entry.getValue());
		}
		
		return keyList;
	}
}
