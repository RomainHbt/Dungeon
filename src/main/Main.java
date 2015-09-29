/**
 * Main class
 */

package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import exception.NotConformFileException;
import map.Dungeon;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Please give a level file !");
		} else {
			Dungeon dungeon;
			try {
				dungeon = new Dungeon(new BufferedReader(new FileReader(new File(args[0]))));
				dungeon.startGame();
			} catch (NotConformFileException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
