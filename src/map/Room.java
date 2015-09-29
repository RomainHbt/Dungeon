/**
 * Principal object for the dungeon. A room can have items, doors and a monster.
 */

package map;

import item.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import special.Inventory;
import entity.Monster;

public class Room {

	private Map<String, Door> accessibleRooms;
	private Inventory items;
	private String name;
	private Monster monster;
	
	/**
	 * Create a new Room
	 * @param name Room's name
	 */
	public Room(String name){
		this.name = name;
		this.items = new Inventory();
		this.accessibleRooms = new HashMap<>();
		this.monster = null;
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
	
	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
	public boolean haveMonster(){
		return monster != null;
	}

	public Collection<Door> listDoors(){
		return this.accessibleRooms.values();
	}
	
	/**
	 * Add an item in the room
	 * @param name Item's name
	 * @param i Item to be added
	 */
	public void addItem(String name, Item i){
		items.addItem(name, i);
	}
	
	/**
	 * Add a door in the room
	 * @param position Door's position in the room
	 * @param door Door to be added
	 * @return true if the door is added, false if not
	 */
	public boolean addDoor(String position, Door door){
		return accessibleRooms.put(position, door) != null;
	}

	@Override
	public String toString() {
		String res = "----------\nRoom Name : "+this.name+"\n";
		if(this.haveMonster()){
			res += "There is a Monster in this room !\n";
		}
		res+= "Accessible doors :\n";
		for (String door : this.accessibleRooms.keySet()) {
			res += "\t- "+door+"\n";
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
