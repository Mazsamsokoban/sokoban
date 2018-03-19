package sokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Game {
	//private ArrayList<Maze> maze;+
	public Tester tester;
	private Maze currentLevel;
	static Outputter op = new Outputter();
	
	
	public Game() {
		Game.op.makeCall(null);
		System.out.print("Game()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Game()");
	}
	
	//elkezdi a játékot, létrehozza a raktárépületet
	public void startGame() {
		op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "()");
		currentLevel = new Maze();
		currentLevel.tester = tester;
		currentLevel.setGame(this);
		op.put(currentLevel, "m");
		tester.m = currentLevel;
		currentLevel.init();
		op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "()");
	}
	
	//befejezi a játékot, ha a feltételek teljesülnek
	public void endGame() {
		op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "()");
		op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "()");
	}
	
	//menürendszer kiírása és választás kezelése
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String choice ;
		
		System.out.println("KILLER SOKOBAN játék" + 
						"\nMazsam csapat" + 
						"\n2018.03.21." +
						"\n\nAz inicializációhoz nyomjon ENTER-t!"
		);
		br.readLine();
		
		Tester tester = new Tester();
		Game game = new Game();
		game.tester = tester;
		Game.op.put(game, "game");
		game.startGame();
		
		System.out.println("\n\nA menübe való továbblépéshez nyomjon ENTER-t!\n");
		br.readLine();
		
		
		while(true) {
			System.out.println(
					"\n1. Munkás mozog\r\n" + 
					"\t1.1. Léphet a célhelyre ? I/N\r\n" + 
					"2. Munkás lép csapóajtóra \r\n" + 
					"\t2.1. Nyitva van a csapóajtó ? I/N\r\n" + 
					"\t2.2. Ha nincs, akkor rá tud lépni? I/N\r\n" + 
					"3. Timer lépteti a munkásokat\r\n" + 
					"4. Munkás dobozt tol\r\n" + 
					"\t4.1. Lehet arra a helyre mozgatni ? I/N\r\n" + 
					"5. Doboz dobozt tol\r\n" + 
					"\t5.1. Lehet arra a helyre mozgatni ? I/N\r\n" + 
					"6. Dobozt munkást tol\r\n" + 
					"\t6.1. Átmozgatható arra a helyre ? I/N\r\n" + 
					"7. Kapcsoló vált\r\n" + 
					"8. Csapóajtó vált\r\n" + 
					"\t8.1. Nyitva van az ajtó ? I/N\r\n" + 
					"\t8.2. Van rajta valami ? I/N\r\n" + 
					"9. Láda beleesik egy lyukba\r\n" + 
					"10. Munkás beleesik egy lyukba\r\n" +
					"11. Láda beér a célhelyre\r\n" + 
					"\t11.1. Az eredeti tulaj tolta be ? I/N\r\n" + 
					"\t11.2. Volt már tulajdonosa ? I/N\r\n" + 
					"12. Láda elhagyja a célhelyet\r\n" + 
					"13. Láda falnak ütközik\r\n" + 
					"14. Játék vége \r\n" + 
					"\t14.1. Maradt még legalább 2 munkás ? I/N\r\n" + 
					"\t14.2. Helyükre kerültek a dobozok ? I/N\r\n" + 
					"\n0 Kilépés\n"+
					"\nAdja meg a választott menüpont sorszámát!\n");
			
			choice = br.readLine();
			
			int intChoice;
			try {
				if (choice.length() > 2) 
					System.out.println("Hibas input");
				else {
					
					intChoice = Integer.parseInt(choice);
					tester.inputHandler(intChoice);
					
				}
					
			}catch(NumberFormatException e) {
				System.out.println("Hibas Input");
			}
		}
	}
}
