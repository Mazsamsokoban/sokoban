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
	
	//elkezdi a j�t�kot, l�trehozza a rakt�r�p�letet
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
	
	//befejezi a j�t�kot, ha a felt�telek teljes�lnek
	public void endGame() {
		op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "()");
		op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "()");
	}
	
	//men�rendszer ki�r�sa �s v�laszt�s kezel�se
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String choice ;
		
		System.out.println("KILLER SOKOBAN j�t�k" + 
						"\nMazsam csapat" + 
						"\n2018.03.21." +
						"\n\nAz inicializ�ci�hoz nyomjon ENTER-t!"
		);
		br.readLine();
		
		Tester tester = new Tester();
		Game game = new Game();
		game.tester = tester;
		Game.op.put(game, "game");
		game.startGame();
		
		System.out.println("\n\nA men�be val� tov�bbl�p�shez nyomjon ENTER-t!\n");
		br.readLine();
		
		
		while(true) {
			System.out.println(
					"\n1. Munk�s mozog\r\n" + 
					"\t1.1. L�phet a c�lhelyre ? I/N\r\n" + 
					"2. Munk�s l�p csap�ajt�ra \r\n" + 
					"\t2.1. Nyitva van a csap�ajt� ? I/N\r\n" + 
					"\t2.2. Ha nincs, akkor r� tud l�pni? I/N\r\n" + 
					"3. Timer l�pteti a munk�sokat\r\n" + 
					"4. Munk�s dobozt tol\r\n" + 
					"\t4.1. Lehet arra a helyre mozgatni ? I/N\r\n" + 
					"5. Doboz dobozt tol\r\n" + 
					"\t5.1. Lehet arra a helyre mozgatni ? I/N\r\n" + 
					"6. Dobozt munk�st tol\r\n" + 
					"\t6.1. �tmozgathat� arra a helyre ? I/N\r\n" + 
					"7. Kapcsol� v�lt\r\n" + 
					"8. Csap�ajt� v�lt\r\n" + 
					"\t8.1. Nyitva van az ajt� ? I/N\r\n" + 
					"\t8.2. Van rajta valami ? I/N\r\n" + 
					"9. L�da beleesik egy lyukba\r\n" + 
					"10. Munk�s beleesik egy lyukba\r\n" +
					"11. L�da be�r a c�lhelyre\r\n" + 
					"\t11.1. Az eredeti tulaj tolta be ? I/N\r\n" + 
					"\t11.2. Volt m�r tulajdonosa ? I/N\r\n" + 
					"12. L�da elhagyja a c�lhelyet\r\n" + 
					"13. L�da falnak �tk�zik\r\n" + 
					"14. J�t�k v�ge \r\n" + 
					"\t14.1. Maradt m�g legal�bb 2 munk�s ? I/N\r\n" + 
					"\t14.2. Hely�kre ker�ltek a dobozok ? I/N\r\n" + 
					"\n0 Kil�p�s\n"+
					"\nAdja meg a v�lasztott men�pont sorsz�m�t!\n");
			
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
