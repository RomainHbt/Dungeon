package item;

public class Potion extends Item{
	private int lifeRestored;
	
	public Potion(int lifeRestored){
		this.lifeRestored = lifeRestored;
	}
	
	public int getLifeRestored() {
		return lifeRestored;
	}

	public void setLifeRestored(int lifeRestored) {
		this.lifeRestored = lifeRestored;
	}

}
