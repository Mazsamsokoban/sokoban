package sokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	Worker w;
	Worker w2;
	Timer t;
	Switch sw;
	SwitchableHole sh;
	Hole hole;
	BoxField bfield;
	Obstacle obs;
	Box box0;
	Box box1;
	Box box2;
	
	
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	
	void inputHandler(int choice) throws IOException {
		//Runtime.getRuntime().exec("cls");
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
	
	
	void executeWorkerMoves() {
		w.Move(Direction.Right);
	}
	
	void executeWorkerStepsOnSwitchableHole() {
		w.Move(Direction.Down);
	}
	
	void executeTimerMakesWorkerStep() {
		t.Tick();
	}
	
	void executeWorkerPushesBox() {
		System.out.println(f3.GetNeighbor(Direction.Left).Accept(box2));
		f3.Accept(w2);
	}
	
	void executeBoxPushesBox() {
		
	}
	
	void executeBoxPushesWorker() {
		
	}
	
	void executeSwitchChanges() {
		
	}
	
	void executeSwitchableHoleSwitches() {
		
	}
	
	void executeBoxFallsIntoHole() {
		
	}
	
	void executeWorkerStepsIntoHole() {
		
	}
	
	void executeWorkerStepsintoHole() {
		
	}
	
	void executeBoxReachesBoxField() {
		
	}
	
	void executeBoxLeavesBoxField() {
		
	}
	
	void executeBoxPumpsIntoObstacle() {
		
	}
	
	void executeEndGame() throws IOException {
		m.CheckEndOfGame();
	}
	
}
