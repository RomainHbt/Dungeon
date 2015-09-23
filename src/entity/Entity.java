package entity;

import java.util.Random;

import special.Inventory;
import map.Room;

public abstract class Entity{
	private static Random rand;
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
	
	/**
	 * Set attack on target
	 * Use weapon if inventory include one
	 * Normal attack is between 0-3 life point damage
	 * Weapon attack is between 2-4 life point damage
	 * @param target
	 */
	public void attack(Entity target){
		if(this.inventory.isEmpty()){
			target.setDamage(rand.nextInt(4));
		}else if(this.inventory.exist("Sword")){
			target.setDamage(2 + rand.nextInt(3));
		}
	}
	
	public void setDamage(int lifeLost){
		this.lifePoints -= lifeLost;
	}
	
	public boolean isAlive(){
		return lifePoints > 0;
	}
}
