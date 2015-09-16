package entity;

import map.Room;

public abstract class Entity{
	
	private Room currentRoom;
	private int lifePoints;
	
	public Entity(Room room, int life){
		this.currentRoom = room;
		this.lifePoints = life;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	
}
