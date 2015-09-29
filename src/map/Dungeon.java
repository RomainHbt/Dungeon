/**
 * The game's core class. This class interpret commands and manages the game
 */

package map;

import item.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Entity;
import entity.Monster;
import entity.Player;
import exception.NotConformFileException;

public class Dungeon {

	private Player player;
	private List<Room> rooms;
	private List<Door> doors;
	private final Scanner scanner = new Scanner(System.in);
	
	/**
	 * Create and generate a Dungeon
	 * @param file Configuration file for the generation
	 * @throws NotConformFileException The configuration file is not conform (follow the pattern)
	 * @throws IOException File not found
	 */
	public Dungeon(BufferedReader file) throws NotConformFileException, IOException{
		this.rooms = new ArrayList<Room>();
		this.generateLevel(file);
		this.player = new Player(this.getRoom("Entrance"), 10, "Joueur");
	}
	
	/**
	 * Generate the level via the file
	 * @param file Configuration file for the generation
	 * @throws NotConformFileException The configuration file is not conform (follow the pattern)
	 * @throws IOException File not found
	 */
	private void generateLevel(BufferedReader file) throws NotConformFileException, IOException{
		String line = file.readLine();
		if(!line.equals("# DUNGEON LEVEL CONFIG")){
			throw new NotConformFileException("The first line is not \"# DUNGEON LEVEL CONFIG\"");
		}
		
		while((line = file.readLine()) != null){
			if(line.charAt(0) == '#') continue;
			if(line.charAt(0) == '-') break;
			Room r = new Room(line.trim());
			this.rooms.add(r);
		}
		
		while((line = file.readLine()) != null){
			if(line.charAt(0) == '#') continue;
			if(line.charAt(0) == '-') break;
			String[] parts = line.split(",");
			new Door(parts[0].trim(), this.getRoom(parts[1].trim()), this.getRoom(parts[2].trim()), parts[3].trim(), parts[4].trim());
		}
		
		while((line = file.readLine()) != null){
			if(line.charAt(0) == '#') continue;
			if(line.charAt(0) == '-') break;
			String[] parts = line.split(",");

			Item i = Item.getItem(parts[2].trim(), parts[3].trim());
			this.getRoom(parts[1].trim()).addItem(parts[0].trim(), i);
		}
		
		while((line = file.readLine()) != null){
			if(line.charAt(0) == '#') continue;
			if(line.charAt(0) == '-') break;
			String[] parts = line.split(",");

			Monster m = new Monster(this.getRoom(parts[0].trim()), Integer.parseInt(parts[1].trim()), "Monstre");
			this.getRoom(parts[0].trim()).setMonster(m);
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Room getRoom(String name){
		for(Room r : rooms){
			if(r.getName().equals(name)) return r;
		}
		return null;
	}
	
	public Door getDoor(String id){
		for(Door d : doors){
			if(d.getId().equals(id)) return d;
		}
		return null;
	}

	/**
	 * Launch the game
	 */
	public void startGame(){
		do {
			System.out.println("You are in "+ player.getCurrentRoom().getName());
			System.out.println("What do you want to do?");
			System.out.print("> ");
			interpretCommand(this.scanner.nextLine());
		} while(!this.gameIsFinished());
		
		System.out.println("You are in "+ player.getCurrentRoom().getName());
		if(this.gameIsWon()){
			System.out.println("Congratulations, you win!");
		} else {
			System.out.println("Sorry, you loose :(");
		}
	}
	
	/**
	 * Interpret the command passed in argument
	 * @param command Command to be treated
	 */
	public void interpretCommand(String command){
		String[] parts = command.split(":");
		String itemName = (parts.length == 1) ? null : parts[1];
		Room playerRoom = this.player.getCurrentRoom();
		switch(parts[0]){
			case "Inventory":
				System.out.println("My inventory :\n"+this.player.getInventory().toString());
				break;
			case "Describe":
				System.out.println(playerRoom.toString());
				break;
			case "Use":
				if(this.player.getInventory().exist(itemName)){
					this.player.getInventory().usePotion(this.player, itemName);
				} else {
					System.out.println("The item isn't in your inventory !");
				}
				break;
			case "Fight":
				if(playerRoom.haveMonster()){
					Entity.fight(getPlayer(), playerRoom.getMonster());
					if(!playerRoom.getMonster().isAlive()){
						System.out.println("The monster is dead !");
						playerRoom.setMonster(null);
					}
				} else {
					System.out.println("There is no monster in this room ...");
				}
				break;
			case "Go":
				if(!playerRoom.haveMonster()){
					if(parts.length >= 2){
						Door direction = playerRoom.getAccessibleRooms().get(parts[1]);
						if(direction != null){
							direction.go(this.player);
						} else {
							System.out.println("Unknown direction.");
						}
						
					} else {
						System.out.println("Please, give a direction.");
					}
				} else {
					System.out.println("There is a monster in this room, you can't move !");
				}
				break;
			case "Get":
				playerRoom.getItems().takeItem(this.player.getInventory(), itemName);
				System.out.println(itemName+" picked up !");
				break;
			default:
				System.out.println("Unknown command.");
				break;
		}
		System.out.println();
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
