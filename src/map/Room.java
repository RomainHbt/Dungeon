package map;

import item.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import special.Inventory;

public class Room {

	private Map<String, Door> accessibleRooms;
	private Inventory items;
	private String name;
	
	public Room(String name){
		this.name = name;
		this.items = new Inventory();
		this.accessibleRooms = new HashMap<>();
	}

	public Map<String, Door> getAccessibleRooms() {
		return accessibleRooms;
	}

	public Inventory getItems() {
		return items;
	}
	
	public String getName() {
		return name;
	}
	
	public Collection<Door> listDoors(){
		return this.accessibleRooms.values();
	}
	
	public void addItem(String name, Item i){
		items.addItem(name, i);
	}
	
	public boolean addDoor(String position, Door door){
		return accessibleRooms.put(position, door) != null;
	}

	@Override
	public String toString() {
		String res = "----------\nRoom Name : "+this.name+"\n";
		res+= "Accessible doors :\n";
		for (String door : this.accessibleRooms.keySet()) {
			res += "\t- "+door+" -> "+this.accessibleRooms.get(door).getExit().getName()+"\n";
		}
		return res;
	}
	
}
