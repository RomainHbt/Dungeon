package tests;
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
		player = new Player(null, 10, "player");
		monster = new Monster(null, 10, "monster");
		player.getInventory().addItem("weapon", new Weapon(5));
	}

	@Test
	public void attackTest(){
		int damage = player.attack(monster);
		assertEquals(damage, 10 - monster.getLifePoints());
		damage = monster.attack(player);
		assertEquals(damage, 10 - player.getLifePoints());
	}
}
