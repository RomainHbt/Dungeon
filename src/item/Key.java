package item;


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
