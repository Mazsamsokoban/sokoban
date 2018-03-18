package sokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Game {
	//private ArrayList<Maze> maze;+
	private Maze currentLevel;
	static Outputter op = new Outputter();
	public Game() {
		Game.op.makeCall(null);
		System.out.print("Game()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Game()");
	}
	public void startGame() {
		op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "()");
		currentLevel = new Maze();
		op.put(currentLevel, "m");
		op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "()");
	}
	
	public void endGame() {
	}
	
	void inputHandler(int choice) {
		switch(choice) {
		case 1:
			executeCase1();
			break;
		case 2:
			executeCase2();
			break;
		case 3:
			executeCase3();
			break;
		case 4:
			executeCase4();
			break;
		case 5:
			executeCase5();
			break;
		case 6:
			executeCase6();
			break;
		case 7:
			executeCase7();
			break;
		case 8:
			executeCase8();
			break;
		case 9:
			executeCase9();
			break;
		case 10:
			executeCase10();
			break;
		case 11:
			executeCase11();
			break;
		case 12:
			executeCase12();
			break;
		case 13:
			executeCase13();
			break;
		case 14:
			executeCase14();
			break;
		case 15:
			executeCase15();
			break;
		case 0: 
			System.exit(0);
			break;
		default:
			System.out.println("Nincs ilyen menüpont!");
		}
	}
	
	void executeCase1() {
		
	}
	
	void executeCase2() {
		
	}
	
	void executeCase3() {
		
	}
	
	void executeCase4() {
		
	}
	
	void executeCase5() {
		
	}
	
	void executeCase6() {
		
	}
	
	void executeCase7() {
		
	}
	
	void executeCase8() {
		
	}
	
	void executeCase9() {
		
	}
	
	void executeCase10() {
		
	}
	
	void executeCase11() {
		
	}
	
	void executeCase12() {
		
	}
	
	void executeCase13() {
		
	}
	
	void executeCase14() {
		
	}
	
	void executeCase15() {
		
	}
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		Game.op.put(game, "game");
		/*op.makeCall(game);
		System.out.print("startGame()");*/
		
		game.startGame();
		
		while(true) {
			System.out.println(
					"\n1. Raktárépület létrehozása\r\n" + 
					"2. Inicializálás\r\n" + 
					"3. Munkás mozog\r\n" + 
					"\t3.1. Léphet a célhelyre ? I/N\r\n" + 
					"4. Munkás lép csapóajtóra \r\n" + 
					"\t4.1. Nyitva van a csapóajtó ? I/N\r\n" + 
					"\t4.2. Ha nincs, akkor rá tud lépni? I/N\r\n" + 
					"5. Timer lépteti a munkást\r\n" + 
					"6. Munkás dobozt tol\r\n" + 
					"\t6.1. Lehet arra a helyre mozgatni ? I/N\r\n" + 
					"7. Doboz dobozt tol\r\n" + 
					"\t7.1. Lehet arra a helyre mozgatni ? I/N\r\n" + 
					"8. Dobozt munkást tol\r\n" + 
					"\t8.1. Átmozgatható arra a helyre ? I/N\r\n" + 
					"9. Kapcsoló vált\r\n" + 
					"10. Csapóajtó vált\r\n" + 
					"\t10.1. Nyitva van az ajtó ? I/N\r\n" + 
					"\t10.2. Van rajta valami ? I/N\r\n" + 
					"11. Munkás beleesik egy lyukba\r\n" + 
					"12. Láda beleesik egy lyukba\r\n" + 
					"13. Láda beér a célhelyre\r\n" + 
					"\t13.1. Az eredeti tulaj tolta be ? I/N\r\n" + 
					"\t13.2. Volt már tulajdonosa ? I/N\r\n" + 
					"14. Munkás eltolása \r\n" + 
					"\t14.1. Átmozgatható arra a helyre ? I/N\r\n" + 
					"15. Játék vége \r\n" + 
					"\t15.1. Maradt még legalább 2 munkás ? I/N\r\n" + 
					"\t15.1. Helyükre kerültek a dobozok ? I/N\r\n" + 
					"\n0 Kilépés\n"+
					"\nAdja meg a választott menüpont sorszámát!\n");
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String choice ;
			
			choice = br.readLine();
			
			int intChoice;
			try {
				if (choice.length() > 2) 
					System.out.println("Hibas input");
				else {
					
					intChoice = Integer.parseInt(choice);
					game.inputHandler(intChoice);
					
				}
					
			}catch(NumberFormatException e) {
				System.out.println("Hibas Input");
			}
		}
	}
}
