package map;

import item.Item;
import item.Key;
import entity.Player;

public class Door {
	
	private String id;
	private Room exit;
	private Room entrance;
	private String type;
	private boolean unlocked;
	
	public Door(String id, Room entrance, Room exit, String type, String position){
		this.id = id;
		this.exit = exit;
		this.entrance = entrance;
		this.type = type;
		if(type.equals("normal")){
			this.unlocked = true;
		} else {
			this.unlocked = false;
		}
		entrance.addDoor(position, this);
		exit.addDoor("Derriere", this);
	}
	
	public void go(Player p){
		if(p.getCurrentRoom() == this.exit){
			p.setCurrentRoom(entrance);
		} else {
			if(this.unlocked){
				p.setCurrentRoom(exit);
			} else {
				switch(type){
					case "close":
						if(this.haveKey(p)){
							this.unlocked = true;
							p.setCurrentRoom(exit);
						} else {
							System.out.println("You need a key to open the door !");
						}
						break;
				}
			}
		}
	}
	
	public String getId(){
		return id;
	}

	public Room getExit() {
		return exit;
	}

	public Room getEntrance() {
		return entrance;
	}

	public String getType() {
		return type;
	}
	
	private boolean haveKey(Player p){
		
		for(Key k : p.getInventory().getKeys()){
			System.out.println(k.toString());
			if(k.canBeUsed(id)) return true;
		}
		return false;
	}

}
