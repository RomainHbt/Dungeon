package map;

import entity.Player;

public class Door {
	
	private Room exit;
	private Room entrance;
	private String type;
	
	public Door(Room entrance, Room exit, String type, String position){
		this.exit = exit;
		this.entrance = entrance;
		this.type = type;
		entrance.addDoor(position, this);
		exit.addDoor("Derriere", this);
	}
	
	public void go(Player p){
		p.setCurrentRoom(exit);
	}

}
