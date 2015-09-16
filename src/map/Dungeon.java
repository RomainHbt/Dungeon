package map;

import entity.Player;

public class Dungeon {
	
	private Player player;
	
	public Dungeon(){
		// ---------------- MAP CONSTRUCTION --------------
		// Room generation
		
		
		// Doors generation
		
		
		// Player generation
		this.player = new Player(null, 10);
	}
	
	public void startGame(){
		do {
			
		} while(!this.gameIsFinished());
		
	}
	
	public void interpretCommand(){
		
	}
	
	public boolean gameIsFinished(){
		return false; // A MODIFIER
	}
	
	public boolean gameIsLost(){
		return false; // A MODIFIER
	}

	public boolean gameIsWon(){
		return false; // A MODIFIER
	}
}
