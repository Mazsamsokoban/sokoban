package models;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



/**
 * A játékot irányító osztály
 */

public class Game {
	/**
	 * A játékot tesztelõ osztály
	 */
	public Tester tester;
	/**
	 * A raktárépület
	 */
	private Maze currentLevel;
	/**
	 * A szkeletonhoz használt osztály (a prototípushoz most nem kell)
	 */
	static Outputter op = new Outputter();
	
	
	public Game() {
	}
	
	/**
	 * Elkezdi a játékot, létrehozza a raktárépületet
	 */
	public void startGame() {
		//currentLevel = new Maze();
		//currentLevel.tester = tester;
		currentLevel.setGame(this);
		tester.m = currentLevel;
		currentLevel.init();
	}
	
	//befejezi a játékot, ha a feltételek teljesülnek
	public void endGame() {
	}
	
	/**
	 * A menürendszer kiírása és választás kezelése
	 */
	/*public static void main(String[] args) throws IOException {
		String command;
		
		Scanner scanner = new Scanner(System.in);
		Scanner fileScanner = null;
		
		System.out.println("KILLER SOKOBAN játék" + 
						"\nMazsam csapat"
		);
		
		
		Tester tester = new Tester();
		Game game = new Game();
		game.tester = tester;
		
		boolean validChoice = false;
		boolean exit = false;
		String choice = null;
		
		System.out.println("Fájlból beolvasva vagy manuálisan szeretne tesztelni? (file/man)");
		while(!validChoice) {
			
			choice = scanner.nextLine();
			
			if(choice.equals("file") || choice.equals("man")) 
				validChoice = true;
			else
				System.out.println("Nincs ilyen lehetõség, válasszon újra! (file/man)");
				
		}
		
		if(choice.equals("file")) {
			while(!exit) {
				System.out.println("\nAdja meg a tesztfájl nevét! (test_x.txt) (Kilépés: exit)");
				String fileName = scanner.nextLine();
				if(fileName.equals("exit"))
					exit = true;
				else {
					try {
						File testFile = new File(fileName);
						fileScanner = new Scanner(testFile);
						System.out.println("A kiadott parancsok:");
						String notxt = null;
						while(fileScanner.hasNext()) {
							String line = fileScanner.nextLine();					//parancsok végrehajtása fájlból
							System.out.println(line);
							notxt = fileName.substring(0, fileName.length()-4);
							exit = tester.processCommand(line, notxt);
						}
						String outputFile = "test_" + notxt.split("_")[1] + "_result.txt";
						System.out.println("A teszt kimenete a " + outputFile+ " fájlban található.");
						String expectedFile = "test_" + notxt.split("_")[1] + "_expected.txt";
						tester.compareWithExpected(outputFile, expectedFile);
						
					}
					catch(FileNotFoundException e) {
						System.out.println("Nincs ilyen teszteset.");
					}
				}
			}
		}
		else {
			while(!exit) {					//parancsok végrehajtása standard inputról
				
				System.out.println("Adjon meg egy parancsot! (Kilépés: exit)");
				
				command = scanner.nextLine();
				
				exit = tester.processCommand(command, null);
			}
		}
		if (scanner !=null) scanner.close();
		if (fileScanner!= null) fileScanner.close();
		
	}*/
}
