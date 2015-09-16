import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import item.Potion;

import org.junit.Before;
import org.junit.Test;

import special.Inventory;


public class InventoryTest {
	Inventory inventory;
	Potion potion;
	
	@Before
	public void setUp() throws Exception {
		inventory = new Inventory();
		potion = new Potion(3);
		
		inventory.addItem("potion", potion);
	}

	@Test
	public void getItem() {
		assertEquals(potion, inventory.getItem("potion"));
	}
}
