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
	private String doorId;
	private Key key;
	
	@Before
	public void setUp() throws Exception {
		doorId = "3";
		key = new Key("3");
	}
	
	@Test
	public void Keytest() {
		assertEquals(door, key.getDoorId());
	}
	
	@Test
	public void canBeUsed(){
		assertTrue(key.canBeUsed(door));
	}
}
