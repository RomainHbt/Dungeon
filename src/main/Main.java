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
		Dungeon dungeon;
		try {
			dungeon = new Dungeon(new BufferedReader(new FileReader(new File("levels/test3.lvl"))));
			//dungeon.showDungeon();
			dungeon.startGame();
		} catch (NotConformFileException | IOException e) {
			e.printStackTrace();
		}
	}

}
