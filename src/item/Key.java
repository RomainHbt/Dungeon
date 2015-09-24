package item;

import map.Door;

public class Key extends Item{
	private String associatedDoorId;
	
	public Key(String associatedDoor){
		this.associatedDoorId = associatedDoor;
	}
	
	public boolean canBeUsed(String doorId){
		return doorId.equals(associatedDoorId);
	}
	
	public String getDoorId(){
		return associatedDoorId;
	}
	
	public void setDoor(String doorId){
		this.associatedDoorId = doorId;
	}
}
