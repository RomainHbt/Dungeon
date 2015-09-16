package entity;

import map.Room;

public abstract class Entity{
	
	private Room currentRoom;
	private int lifePoints;
	
	public Entity(Room room, int life){
		this.currentRoom = room;
		this.lifePoints = life;
	}
	
}
