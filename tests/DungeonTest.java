import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import map.Dungeon;
import map.Room;

import org.junit.Before;
import org.junit.Test;


public class DungeonTest {
	
	protected Dungeon dungeon;

	@Before
	public void setUp() throws Exception {
		dungeon = new Dungeon(new BufferedReader(new FileReader(new File("levels/test1.lvl"))));
	}
	
	@Test
	public void initialRoomIsEntrance() {
		assertEquals("Entrance", dungeon.getPlayer().getCurrentRoom().getName());
	}
	
	@Test
	public void gameNotFinishedAtBeginning() {
		assertNotEquals("Exit", dungeon.getPlayer().getCurrentRoom().getName());
	}
	
	@Test
	public void movePlayer() {
		dungeon.interpretCommand("Go:Devant");
		assertEquals("Intersection", dungeon.getPlayer().getCurrentRoom().getName());
	}
	
	@Test
	public void gameLooseInATrap() {
		dungeon.interpretCommand("Go:Devant");
		dungeon.interpretCommand("Go:Gauche");
		assertTrue(dungeon.gameIsLost());
	}
	
	@Test
	public void gameWinInATrap() {
		dungeon.interpretCommand("Go:Devant");
		dungeon.interpretCommand("Go:Droite");
		assertTrue(dungeon.gameIsWon());
	}
	
	@Test
	public void returnAtEntrance() {
		dungeon.interpretCommand("Go:Devant");
		dungeon.interpretCommand("Go:Derriere");
		assertEquals("Entrance", dungeon.getPlayer().getCurrentRoom().getName());
	}

}
