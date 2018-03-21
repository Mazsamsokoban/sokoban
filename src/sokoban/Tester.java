package sokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//tesztelõ osztály a viselkedések bemutatására
public class Tester {
	Outputter op;
	Game game;
	Maze m;
	Field f0; 
	Field f1; 
	Field f2; 
	Field f3; 
	Field f4;
	Field f5;
	Field f6;
	Field f7;
	Field f8;
	Field f9;
	Field f10;
	Field f11;
	Field f12;
	Field f13;
	Field f14;
	Field f15;
	Field f16;
	Field bfield1;
	Worker w;
	Worker w1;
	Worker w2;
	Timer t;
	Switch sw;
	SwitchableHole sh;
	Hole hole1;
	Hole hole2;
	BoxField bfield;
	Obstacle obs;
	Box box0;
	Box box1;
	Box box2;
	Box box3;
	Box box4;
	Box box5;
	Box box6;
	Box box7;
	
		
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	
	
	//a felhasználó választása szerinti szekvencia
	void inputHandler(int choice) throws IOException {
		
		
		switch(choice) {
		case 1:
			System.out.println("\nWorker Moves\n");
			executeWorkerMoves();
			break;
		case 2:
			System.out.println("\nWorker Steps On SwitchableHole\n");
			executeWorkerStepsOnSwitchableHole();
			break;
		case 3:
			System.out.println("\nTimer Makes Workers Step\n");
			executeTimerMakesWorkerStep();
			break;
		case 4:
			System.out.println("\nWorker Pushes Box\n");
			executeWorkerPushesBox();
			break;
		case 5:
			System.out.println("\nBox Pushes Box\n");
			executeBoxPushesBox();
			break;
		case 6:
			System.out.println("\nBox Pushes Worker\n");
			executeBoxPushesWorker();
			break;
		case 7:
			System.out.println("\nSwitch Changes\n");
			executeSwitchChanges();
			break;
		case 8:
			System.out.println("\nSwitchableHoleSwitches\n");
			executeSwitchableHoleSwitches();
			break;
		case 9:
			System.out.println("\nBox Falls Into Hole\n");
			executeBoxFallsIntoHole();
			break;
		case 10:
			System.out.println("\nWorker Steps Into Hole\n");
			executeWorkerStepsIntoHole();
			break;
		case 11:
			System.out.println("\nBox Reaches BoxField\n");
			executeBoxReachesBoxField();
			break;
		case 12:
			System.out.println("\nBox Leaves BoxField\n");
			executeBoxLeavesBoxField();
			break;
		case 13:
			System.out.println("\nBox Pumps Into Obstacle\n");
			executeBoxPumpsIntoObstacle();
			break;
		case 14:
			System.out.println("\nEnd Game\n");
			executeEndGame();
			break;
		case 0: 
			System.exit(0);
			break;
		default:
			System.out.println("Nincs ilyen menüpont!");
		}
		System.out.println("\n\nA menübe való visszatéréshez nyomjon meg egy gombot, majd ENTER-t!");
		
		br.readLine();
	}
	
	
	//a menüpontok szerinti szekvenciák
	//1
	void executeWorkerMoves() {
		m.init();
		Field fi = (Field) w.field.GetNeighbor(Direction.Up);
		fi.ChangeDebug();
		clear();
		w.Move(Direction.Up);
	}
	//2
	void executeWorkerStepsOnSwitchableHole() {
		m.init();
		clear();
		w.Move(Direction.Right);
	}
	//3
	void executeTimerMakesWorkerStep() {
		m.init();
		clear();
		t.Tick();
	}
	//4
	void executeWorkerPushesBox() {
		m.init();
		
		Field fi = (Field) w.field.GetNeighbor(Direction.Left).GetNeighbor(Direction.Left);
		fi.ChangeDebug();
		
		clear();
		w.Move(Direction.Left);
		fi.ChangeDebug();
	}
	//5
	void executeBoxPushesBox() {
		m.init();
		
		Field fi = (Field) w.field.GetNeighbor(Direction.Down).GetNeighbor(Direction.Down).GetNeighbor(Direction.Down);
		fi.ChangeDebug();
		
		clear();
		w.Move(Direction.Down);
		fi.ChangeDebug();
	}
	//6
	void executeBoxPushesWorker() {
		m.init();
		
		Field fi = (Field) w1.field.GetNeighbor(Direction.Down).GetNeighbor(Direction.Down).GetNeighbor(Direction.Down);
		fi.ChangeDebug();
		
		clear();
		w1.Move(Direction.Down);
		fi.ChangeDebug();
	}
	//7
	void executeSwitchChanges() {
		m.init();
		clear();
		sw.Accept(box3);
	}
	//8
	void executeSwitchableHoleSwitches() {
		m.init();
		clear();
		sw.Change();
	}
	//9
	void executeBoxFallsIntoHole() {
		m.init();
		clear();
		w1.Move(Direction.Right);
	}
	//10
	void executeWorkerStepsIntoHole() {
		m.init();
		clear();
		w1.Move(Direction.Left);
	}
	//11
	void executeBoxReachesBoxField() {
		m.init();
		executeBoxLeavesBoxField();
		w2.field.Remove();
		box6.d = Direction.Left;
		clear();
		bfield.Accept(box6);
	}
	
	//12
	void executeBoxLeavesBoxField() {
		m.init();
		clear();
		w2.Move(Direction.Right);
	}
	
	void executeBoxPumpsIntoObstacle() {
		m.init();
		clear();
		w2.Move(Direction.Left);
	}
	
	void executeEndGame() throws IOException {
		m.init();
		clear();
		m.CheckEndOfGame();
	}
	
	//univerzális képernyõtörlés :D
	void clear() {
		for(int i = 0; i< 1000; ++i)
			System.out.println("");
	}
	
	//paraméterként megadott eldöntendõ kérdés kiírása
	static boolean Kerdes(String szoveg)
	{
		System.out.println("\n" + szoveg + "I/N");
		String choice = null;
		try {
			choice = Game.op.br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(choice.charAt(0) == 'I' || choice.charAt(0) == 'i') 
		{			
			return true;
		}
		else
			return false;
	}
		
	
}
