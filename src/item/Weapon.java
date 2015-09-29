/**
 * Class which represent a Weapon Item
 */

package item;

public class Weapon extends Item{
	private int efficiency;
	
	public Weapon(int efficiency){
		this.efficiency = efficiency;
	}
	
	public int getEfficiency(){
		return this.efficiency;
	}
}
