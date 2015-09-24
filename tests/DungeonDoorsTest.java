import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import item.Key;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import map.Dungeon;

import org.junit.Before;
import org.junit.Test;


public class DungeonDoorsTest {
	
	protected Dungeon dungeon;

	@Before
	public void setUp() throws Exception {
		dungeon = new Dungeon(new BufferedReader(new FileReader(new File("levels/test2.lvl"))));
	}
	
	@Test
	public void doorIsLoocked() {
		dungeon.interpretCommand("Go:Devant");
		dungeon.interpretCommand("Go:Droite");
		assertEquals("Intersection", dungeon.getPlayer().getCurrentRoom().getName());
	}
	
	@Test
	public void playerHaveKey() {
		dungeon.interpretCommand("Go:Devant");
		dungeon.interpretCommand("Go:Gauche");
		dungeon.interpretCommand("Get:Cle");
		assertEquals(new Key("3"), dungeon.getPlayer().getInventory().getItem("Cle"));
	}
	
	@Test
	public void gameWinWithDoor() {
		dungeon.interpretCommand("Go:Devant");
		dungeon.interpretCommand("Go:Gauche");
		dungeon.interpretCommand("Get:Cle");
		dungeon.interpretCommand("Go:Derriere");
		dungeon.interpretCommand("Go:Droite");
		assertTrue(dungeon.gameIsWon());
	}

}
