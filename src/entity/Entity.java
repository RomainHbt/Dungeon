package entity;

import special.Inventory;
import map.Room;

public abstract class Entity{
	private Room currentRoom;
	private int lifePoints;
	private Inventory inventory;
	
	public Entity(Room room, int life){
		this.currentRoom = room;
		this.lifePoints = life;
		this.inventory = new Inventory();
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
	
	public void attack(Entity target){
		
	}
	
	public boolean isAlive(){
		return lifePoints > 0;
	}
}
