package entity;

import item.Weapon;

import java.util.Random;

import map.Room;
import special.Inventory;

public abstract class Entity{
	private static Random rand;
	private Room currentRoom;
	private int lifePoints;
	private Inventory inventory;
	
	/**
	 * Constructor of Entity
	 * @param room The room where the player is
	 * @param life The number of life point of the player
	 */
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
	
	public Inventory getInventory(){
		return this.inventory;
	}
	
	/**
	 * Set attack on target
	 * Use weapon if inventory include one
	 * Normal attack is between 0-3 life point damage
	 * Weapon attack is between 0-weapon efficiency life point damage
	 * @param target
	 */
	public void attack(Entity target){
		if(!this.inventory.exist("Sword")){
			target.setDamage(rand.nextInt(4));
		}else{
			target.setDamage(rand.nextInt( ((Weapon)inventory.getItem("Wepon")).getEfficiency()) + 1);
		}
	}
	
	public void setDamage(int lifeLost){
		this.lifePoints -= lifeLost;
	}
	
	public boolean isAlive(){
		return lifePoints > 0;
	}
	
	/**
	 * Make player fight against monster. The player begin attack.
	 * @param player
	 * @param monster
	 * @return true if player win, false otherwise
	 */
	public static boolean fight(Entity player, Entity monster){
		while(player.isAlive() && monster.isAlive()){
			player.attack(monster);
			if(monster.isAlive())
				monster.attack(player);
		}
		return player.isAlive();
	}
}
