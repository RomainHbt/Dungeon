package item;


public class Key extends Item{
	private String associatedDoorId;
	
	/**
	 * Build a new key associated to the associatedDoorId
	 * @param associatedDoor The door associate to the new key
	 */
	public Key(String associatedDoorId){
		this.associatedDoorId = associatedDoorId;
	}
	
	/**
	 * Test if the this key can open the door references by the associatedDoorId
	 * @param doorId The id of the door you want to test
	 * @return True if this key can open the door, false otherwise
	 */
	public boolean canBeUsed(String doorId){
		return doorId.equals(associatedDoorId);
	}
	
	public String getDoorId(){
		return associatedDoorId;
	}
	
	public void setDoor(String doorId){
		this.associatedDoorId = doorId;
	}

	@Override
	public int hashCode() {
		return associatedDoorId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (associatedDoorId == null) {
			if (other.associatedDoorId != null)
				return false;
		} else if (!associatedDoorId.equals(other.associatedDoorId))
			return false;
		return true;
	}
	
	
}
