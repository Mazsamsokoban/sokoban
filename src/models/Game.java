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
 * A j�t�kot ir�ny�t� oszt�ly
 */

public class Game {
	/**
	 * A j�t�kot tesztel� oszt�ly
	 */
	public Tester tester;
	/**
	 * A rakt�r�p�let
	 */
	private Maze currentLevel;
	/**
	 * A szkeletonhoz haszn�lt oszt�ly (a protot�pushoz most nem kell)
	 */
	static Outputter op = new Outputter();
	
	
	public Game() {
	}
	
	/**
	 * Elkezdi a j�t�kot, l�trehozza a rakt�r�p�letet
	 */
	public void startGame() {
		//currentLevel = new Maze();
		//currentLevel.tester = tester;
		currentLevel.setGame(this);
		tester.m = currentLevel;
		currentLevel.init();
	}
	
	//befejezi a j�t�kot, ha a felt�telek teljes�lnek
	public void endGame() {
	}
	
	/**
	 * A men�rendszer ki�r�sa �s v�laszt�s kezel�se
	 */
	/*public static void main(String[] args) throws IOException {
		String command;
		
		Scanner scanner = new Scanner(System.in);
		Scanner fileScanner = null;
		
		System.out.println("KILLER SOKOBAN j�t�k" + 
						"\nMazsam csapat"
		);
		
		
		Tester tester = new Tester();
		Game game = new Game();
		game.tester = tester;
		
		boolean validChoice = false;
		boolean exit = false;
		String choice = null;
		
		System.out.println("F�jlb�l beolvasva vagy manu�lisan szeretne tesztelni? (file/man)");
		while(!validChoice) {
			
			choice = scanner.nextLine();
			
			if(choice.equals("file") || choice.equals("man")) 
				validChoice = true;
			else
				System.out.println("Nincs ilyen lehet�s�g, v�lasszon �jra! (file/man)");
				
		}
		
		if(choice.equals("file")) {
			while(!exit) {
				System.out.println("\nAdja meg a tesztf�jl nev�t! (test_x.txt) (Kil�p�s: exit)");
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
							String line = fileScanner.nextLine();					//parancsok v�grehajt�sa f�jlb�l
							System.out.println(line);
							notxt = fileName.substring(0, fileName.length()-4);
							exit = tester.processCommand(line, notxt);
						}
						String outputFile = "test_" + notxt.split("_")[1] + "_result.txt";
						System.out.println("A teszt kimenete a " + outputFile+ " f�jlban tal�lhat�.");
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
			while(!exit) {					//parancsok v�grehajt�sa standard inputr�l
				
				System.out.println("Adjon meg egy parancsot! (Kil�p�s: exit)");
				
				command = scanner.nextLine();
				
				exit = tester.processCommand(command, null);
			}
		}
		if (scanner !=null) scanner.close();
		if (fileScanner!= null) fileScanner.close();
		
	}*/
}
