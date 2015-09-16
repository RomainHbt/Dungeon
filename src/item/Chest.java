package item;

public class Chest extends Item{
	private Key associatedKey;
	
	public Chest(Key associatedKey){
		this.associatedKey = associatedKey;
	}
}
