/**
 * Class which represent a Monster Entity
 */
package entity;

import map.Room;

public class Monster extends Entity{

	public Monster(Room room, int life, String name) {
		super(room, life, name);
	}
}
