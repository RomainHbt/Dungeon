package map;

import item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

	private Map<String, Door> accessibleRooms;
	private List<Item> items;
	private String name;
	
	public Room(String name){
		this.name = name;
		this.items = new ArrayList<>();
		this.accessibleRooms = new HashMap<>();
	}

	public Map<String, Door> getAccessibleRooms() {
		return accessibleRooms;
	}

	public List<Item> getItems() {
		return items;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean addItem(Item i){
		return items.add(i);
	}
	
	public boolean removeItem(Item i){
		return items.remove(i);
	}
	
	public boolean addDoor(String position, Door door){
		return accessibleRooms.put(position, door) != null;
	}
	
}
