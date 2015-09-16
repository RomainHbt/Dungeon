package item;

public class Key extends Item{
	private Chest associatedChest;
	
	public Key(Chest associatedChest){
		this.associatedChest = associatedChest;
	}
}
