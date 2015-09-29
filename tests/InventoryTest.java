import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import item.Item;
import item.Potion;
import item.Weapon;

import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import special.Inventory;
import entity.Entity;
import entity.Player;


public class InventoryTest {
	Inventory inventory, emptyInventory;
	Potion potion;
	
	@Before
	public void setUp() throws Exception {
		inventory = new Inventory();
		emptyInventory = new Inventory();
		potion = new Potion(3);
		inventory.addItem("potion", potion);

	}
	
	@Test
	public void addItemTest(){
		emptyInventory.addItem("potion", potion);
		assertFalse(emptyInventory.isEmpty());
	}
	
	@Test
	public void getItemTest() {
		assertEquals(potion, inventory.getItem("potion"));
	}
	
	@Test
	public void isEmptyTest(){
		assertTrue(emptyInventory.isEmpty());
	}
	
	@Test
	public void existTest(){
		assertTrue(inventory.exist("potion"));
		assertFalse(emptyInventory.exist("potion"));
	}
	
	@Test
	public void takeItemTest(){
		inventory.takeItem(emptyInventory, "potion");
		assertTrue(inventory.isEmpty());
		assertFalse(emptyInventory.isEmpty());
	}
	
	@Test
	public void removeTest(){
		inventory.removeItem("potion");
		assertTrue(inventory.isEmpty());
	}
	
	@Test
	public void usePotionTest(){
		Entity player = new Player(null, 10, null);
		inventory.usePotion(player, "potion");
		assertTrue(player.getLifePoints() > 10);
		assertEquals(null, inventory.getItem("potion"));
	}
	
	@Test
	public void getWeaponTest(){
		Item weapon = new Weapon(5);
		inventory.addItem("weapon", weapon);
		Entry<String, Item> entry = inventory.getWeapon();
		assertTrue(entry.getValue() instanceof Weapon);
	}
}
