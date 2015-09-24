import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import item.Key;

import org.junit.Before;
import org.junit.Test;


public class ItemTest {
	private String doorId;
	private Key key;
	
	@Before
	public void setUp() throws Exception {
		doorId = "3";
		key = new Key(doorId);
	}
	
	@Test
	public void Keytest() {
		assertEquals(doorId, key.getDoorId());
	}
	
	@Test
	public void canBeUsed(){
		assertTrue(key.canBeUsed(doorId));
		assertFalse(key.canBeUsed("5"));
	}
}
