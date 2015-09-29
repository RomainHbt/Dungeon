package entity;

import item.Item;
import item.Weapon;

import java.util.Random;
import java.util.Map.Entry;

import map.Room;
import special.Inventory;

public abstract class Entity{
	private final static Random rand = new Random();
	private String name;
	private Room currentRoom;
	private int lifePoints;
	private Inventory inventory;
	
	/**
	 * Constructor of Entity
	 * @param room The room where the player is
	 * @param life The number of life point of the player
	 */
	public Entity(Room room, int life, String entityName){
		this.currentRoom = room;
		this.lifePoints = life;
		this.inventory = new Inventory();
		this.name = entityName;
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
	
	public String getName() {
		return name;
	}
	
	/**
	 * Do attack on target
	 * Use weapon if inventory include one
	 * Normal attack is between 0-3 life point damage
	 * Weapon attack is between 0-weapon efficiency life point damage
	 * @param target
	 */
	public int attack(Entity target){
		Entry<String, Item> weapon = this.inventory.getWeapon();
		int damagePoint = 0;
		if(weapon == null){
			damagePoint = rand.nextInt(4);
			target.setDamage(damagePoint);
			System.out.println(this.getName()+" has removed "+damagePoint+" life(s) point to "+ target.getName()+".");
		}else{
			damagePoint = rand.nextInt( ((Weapon) (weapon.getValue())).getEfficiency()) + 1;
			target.setDamage(damagePoint);
			System.out.println(this.getName()+" has removed "+damagePoint+" life(s) point to "+ target.getName()+".");
		}
		
		return damagePoint;
	}
	
	public void setDamage(int lifeLost){
		this.lifePoints -= lifeLost;
	}
	
	/**
	 * Check if entity still have life point
	 * @return true if this entity have more than 0 life point, false otherwise
	 */
	public boolean isAlive(){
		return lifePoints > 0;
	}
	
	/**
	 * Make player fight against monster. They each play once and player start the fight
	 * @param player
	 * @param monster
	 * @return true while player is alive
	 */
	public static boolean fight(Entity player, Entity monster){
		if(monster.isAlive() && player.isAlive()){
			player.attack(monster);
			if(monster.isAlive())
				monster.attack(player);
		}
		System.out.println(player.getName() + " has " + player.getLifePoints() + "life point.");
		System.out.println(monster.getName() + " has " + monster.getLifePoints() + "life point.");
		return player.isAlive();
	}
}
