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
		if(p.getCurrentRoom() == this.exit){
			p.setCurrentRoom(entrance);
		} else {
			switch(type){
				case "close":
					if(false){
						p.setCurrentRoom(exit);
					} else {
						System.out.println("You need a key to open the door !");
					}
					break;
				case "normal":
					p.setCurrentRoom(exit);
					break;
				default:
					p.setCurrentRoom(exit);
					break;
			}
		}
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
	
	

}
