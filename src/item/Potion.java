package item;

public class Potion extends Item{
	private int lifeRestored;
	
	/**
	 * Build a new potion
	 * @param lifeRestored The efficiency of the potion
	 */
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
