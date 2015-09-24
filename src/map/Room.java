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
		res+= "Items :\n" + this.items.toString();
		return res;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
