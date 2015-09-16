package map;

import entity.Player;

public class Dungeon {
	
	private Player player;
	
	public Dungeon(){
		// ---------------- MAP CONSTRUCTION --------------
		// Room generation
		Room exit = new Room("Exit");
		Room entrance = new Room("Entrance");
		
		// Doors generation
		
		
		// Player generation
		this.player = new Player(entrance, 10);
	}
	
	public Player getPlayer() {
		return player;
	}

	public void startGame(){
		do {
			
		} while(!this.gameIsFinished());
		
	}
	
	public void interpretCommand(){
		
	}
	
	public boolean gameIsFinished(){
		return gameIsLost() || gameIsWon();
	}
	
	public boolean gameIsLost(){
		return player.getCurrentRoom().getName().equals("Trap") || player.getLifePoints() == 0;
	}

	public boolean gameIsWon(){
		return player.getCurrentRoom().getName().equals("Exit");
	}
}
