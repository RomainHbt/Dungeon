package map;

import entity.Player;

public class Door {
	
	private String id;
	private Room exit;
	private Room entrance;
	private String type;
	
	public Door(String id, Room entrance, Room exit, String type, String position){
		this.id = id;
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
					if(p.getInventory().getItem("Cle de la porte") != null){
						p.getInventory().removeItem("Cle de la porte");
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
	
	

}
