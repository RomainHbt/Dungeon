package item;

public class Potion extends Item{
	private Integer lifeRestored;
	
	public Potion(Integer lifeRestored){
		this.lifeRestored = lifeRestored;
	}
	
	public Integer getLifeRestored() {
		return lifeRestored;
	}

	public void setLifeRestored(Integer lifeRestored) {
		this.lifeRestored = lifeRestored;
	}

}
