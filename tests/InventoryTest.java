import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import item.Potion;

import org.junit.Before;
import org.junit.Test;

import special.Inventory;


public class InventoryTest {
	Inventory inventory, inventoryBis;
	Potion potion;
	
	@Before
	public void setUp() throws Exception {
		inventory = new Inventory();
		inventoryBis = new Inventory();
		potion = new Potion(3);
	}
	
	@Test
	public void addItem(){
		inventory.addItem("potion", potion);
		assertEquals(false, inventory.isEmpty());
	}
	@Test
	public void getItem() {
		inventory.addItem("potion", potion);
		assertEquals(potion, inventory.getItem("potion"));
	}
	
	@Test
	public void isEmpty(){
		assertEquals(true, new Inventory().isEmpty());
	}
	
	@Test
	public void exist(){
		inventory.addItem("test", new Potion(5));
		assertEquals(true, inventory.exist("test"));
	}
	
	@Test
	public void takeItem(){
		inventory.takeItem(inventoryBis, "potion");
		assertEquals(true, inventory.isEmpty());
	}
	
	@Test
	public void remove(){
		inventoryBis.removeItem("potion");
		assertEquals(true, inventoryBis.isEmpty());
	}
}
