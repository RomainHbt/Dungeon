import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import item.Potion;

import org.junit.Before;
import org.junit.Test;

import special.Inventory;


public class InventoryTest {
	Inventory potionInventory, emptyInventory;
	Potion potion;
	
	@Before
	public void setUp() throws Exception {
		potionInventory = new Inventory();
		emptyInventory = new Inventory();
		potion = new Potion(3);
		potionInventory.addItem("potion", potion);

	}
	
	@Test
	public void addItemTest(){
		emptyInventory.addItem("potion", potion);
		assertFalse(emptyInventory.isEmpty());
	}
	
	@Test
	public void getItemTest() {
		assertEquals(potion, potionInventory.getItem("potion"));
	}
	
	@Test
	public void isEmptyTest(){
		assertTrue(emptyInventory.isEmpty());
	}
	
	@Test
	public void existTest(){
		assertTrue(potionInventory.exist("potion"));
		assertFalse(emptyInventory.exist("potion"));
	}
	
	@Test
	public void takeItemTest(){
		potionInventory.takeItem(emptyInventory, "potion");
		assertTrue(potionInventory.isEmpty());
		assertFalse(emptyInventory.isEmpty());
	}
	
	@Test
	public void removeTest(){
		potionInventory.removeItem("potion");
		assertTrue(potionInventory.isEmpty());
	}
	
	@Test
	public void toStringTest(){
		assertEquals("potion", potionInventory.toString());
		assertEquals("", emptyInventory.toString());
		potionInventory.addItem("potion2", new Potion(4));
		assertEquals("potion3\tpotion2\tpotion", potionInventory.toString());
	}
}
