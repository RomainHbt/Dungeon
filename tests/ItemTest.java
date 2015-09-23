import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import item.Key;
import item.Weapon;
import map.Door;
import map.Room;

import org.junit.Before;
import org.junit.Test;


public class ItemTest {
	private Door door;
	private Key key;
	
	@Before
	public void setUp() throws Exception {
		door = new Door(null, new Room("room1"), new Room("room2"), "test", "key");
		key = new Key(door);
	}
	
	@Test
	public void Keytest() {
		assertEquals(door, key.getDoor());
	}
	
	@Test
	public void canBeUsed(){
		assertTrue(key.canBeUsed(door));
	}
}
