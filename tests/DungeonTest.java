import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import map.Dungeon;

import org.junit.Before;
import org.junit.Test;


public class DungeonTest {
	
	protected Dungeon dungeon;

	@Before
	public void setUp() throws Exception {
		dungeon = new Dungeon();
	}

	@Test
	public void initialRoomIsEntrance() {
		fail("Not yet implemented");
	}
	
	@Test
	public void gameNotFinishedAtBeginning() {
		assertFalse(dungeon.getPlayer().getCurrentRoom().getName().equals("Exit"));
	}
	
	@Test
	public void gameStartAtEntrance() {
		assertFalse(dungeon.getPlayer().getCurrentRoom().getName().equals("Entrance"));
	}

}
