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
		Dungeon dungeon = new Dungeon();
		try {
			dungeon.generateLevel(new BufferedReader(new FileReader(new File("levels/test1.lvl"))));
		} catch (NotConformFileException | IOException e) {
			e.printStackTrace();
		}
		//dungeon.showDungeon();
		dungeon.startGame();
	}

}
