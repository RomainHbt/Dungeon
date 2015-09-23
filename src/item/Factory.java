package item;

import map.Door;

public class Factory {
	/**
	 * Make item by itemName and an attribute (efficiency to make weapon or the associated door to make a key)
	 * To make key: itemName = "key", attribute = associatedDoor
	 * To make weapon: itemName = "weapon", attribute = efficiency
	 * To make potion: itemName = "potion", attribute = efficiency
	 * @param itemName The class name which is instantiate
	 * @param attribute The special value need to instantiate each class
	 * @return The new Object on success or null if parameters are incorrect
	 */
	public static Item getItem(String itemName, Object attribute){
		switch(itemName){
		case "key":
			return new Key((Door) attribute);
		case "potion":
			return new Potion((int) attribute);
		case "weapon":
			return new Weapon((int) attribute);
			default:
				return null;
		}
	}
}