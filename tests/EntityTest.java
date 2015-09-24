import static org.junit.Assert.*;
import item.Weapon;

import org.junit.Before;
import org.junit.Test;

import entity.Entity;
import entity.Monster;
import entity.Player;


public class EntityTest {
	private Entity player;
	private Entity monster;
	
	@Before
	public void setUp() throws Exception {
		player = new Player(null, 10);
		monster = new Monster(null, 10);
	}

	@Test
	public void fightTest() {
		Entity.fight(player, monster);
		assertTrue( (player.isAlive() && !monster.isAlive()) || (!player.isAlive() && monster.isAlive()));
	}
	
	@Test
	public void weaponFightTest(){
		player.getInventory().addItem("Weapon", new Weapon(7));
		Entity.fight(player, monster);
		assertTrue( (player.isAlive() && !monster.isAlive()) || (!player.isAlive() && monster.isAlive()));
	}
}
