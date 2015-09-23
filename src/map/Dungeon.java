package map;

import item.Factory;
import item.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Player;
import exception.NotConformFileException;

public class Dungeon {
	
	private Player player;
	private List<Room> rooms;
	private final Scanner scanner = new Scanner(System.in);
	
	public Dungeon(BufferedReader file) throws NotConformFileException, IOException{
		this.rooms = new ArrayList<Room>();
		this.generateLevel(file);
		this.player = new Player(this.getRoom("Entrance"), 10);
	}
	
	private void generateLevel(BufferedReader file) throws NotConformFileException, IOException{
		String line = file.readLine();
		if(!line.equals("# DUNGEON LEVEL CONFIG")){
			throw new NotConformFileException();
		}
		
		while((line = file.readLine()) != null){
			if(line.charAt(0) == '#') continue;
			if(line.charAt(0) == '-') break;
			Room r = new Room(line);
			this.rooms.add(r);
		}
		
		while((line = file.readLine()) != null){
			if(line.charAt(0) == '#') continue;
			if(line.charAt(0) == '-') break;
			String[] parts = line.split(",");
			new Door(parts[0], this.getRoom(parts[1]), this.getRoom(parts[1]), parts[2], parts[3]);
		}
		
		while((line = file.readLine()) != null){
			if(line.charAt(0) == '#') continue;
			if(line.charAt(0) == '-') break;
			String[] parts = line.split(",");
			Item i = Factory.getItem(parts[2]);
			
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
	
	public void interpretCommand(String command){
		String[] parts = command.split(":");
		switch(parts[0]){
			case "Describe":
				System.out.println(this.player.getCurrentRoom().toString());
				break;
			case "Go":
				if(parts.length >= 2){
					Door direction = this.player.getCurrentRoom().getAccessibleRooms().get(parts[1]);
					if(direction != null){
						direction.go(this.player);
					} else {
						System.out.println("Unknown direction.");
					}
					
				} else {
					System.out.println("Please, give a direction.");
				}
				break;
			case "Get":
				String itemName = parts[1];
				this.player.getCurrentRoom().getItems().takeItem(this.player.getInventory(), itemName);
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
	
	public void showDungeon(){
		for(Room r : this.rooms){
			System.out.println(r.toString());
		}
	}
}
