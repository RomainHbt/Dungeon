package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import map.Dungeon;

import org.junit.Before;
import org.junit.Test;


public class DungeonMonsterTest {

	protected Dungeon dungeon;

	@Before
	public void setUp() throws Exception {
		dungeon = new Dungeon(new BufferedReader(new FileReader(new File("levels/test3.lvl"))));
	}
	
	@Test
	public void noMonsterInEntrance() {
		assertFalse(dungeon.getPlayer().getCurrentRoom().haveMonster());
	}
	
	@Test
	public void monsterInNextRoom() {
		dungeon.interpretCommand("Go:Devant");
		assertTrue(dungeon.getPlayer().getCurrentRoom().haveMonster());
	}
	
	@Test
	public void cantMoveWhenMonsterAlive() {
		dungeon.interpretCommand("Go:Devant");
		dungeon.interpretCommand("Go:Devant");
		assertEquals("Monster Room", dungeon.getPlayer().getCurrentRoom().getName());
	}

}
