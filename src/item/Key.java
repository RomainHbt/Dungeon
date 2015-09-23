package item;

import map.Door;

public class Key extends Item{
	private Door associatedDoor;
	
	public Key(Door associatedDoor){
		this.associatedDoor = associatedDoor;
	}
	
	public boolean canBeUsed(Door door){
		return door == associatedDoor;
	}
	
	public Door getDoor(){
		return associatedDoor;
	}
	
	public void setDoor(Door door){
		this.associatedDoor = door;
	}
}
