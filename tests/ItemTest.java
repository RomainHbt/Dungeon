import static org.junit.Assert.assertEquals;
import item.Key;
import map.Door;
import map.Room;

import org.junit.Before;
import org.junit.Test;


public class ItemTest {
	private Door door;
	private Key key;
	
	@Before
	public void setUp() throws Exception {
		door = new Door(new Room("room1"), new Room("room2"), "test", "key");
		key = new Key(door);
	}
	
	@Test
	public void Keytest() {
		assertEquals(door, key.getDoor());
	}
}
