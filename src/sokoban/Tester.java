package sokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

//tesztelõ osztály a viselkedések bemutatására
public class Tester {
	Outputter op;
	Game game;
	Maze m;
	PrintStream printer;
	
	ArrayList<Worker> workers;
	ArrayList<Box> boxes;
	ArrayList<FieldBase> fields;
	FieldBase fieldMap[][];
	
	FieldBase mazeImage;
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	
	public Tester() {
		printer = System.out;
		workers = new ArrayList<Worker>();
		boxes = new ArrayList<Box>();
		fields = new ArrayList<FieldBase>();
	} 
	
	
	public void processCommand(String command) {
		String parts[] = command.split(" ");
		switch (parts[0]) {
			case "loadtest":
				loadtestCommand(parts);
				System.out.println("\nA betöltött tesztpálya:");
				showmazeCommand();
				break;
		
			case "move":										//kész
				moveCommand(parts);
				break;
			
			case "put":
				
				break;	
			
			case "listboxes":									//kész
				for(Box b : boxes)
					b.printState(printer);
				break;
			
			case "listworkers":									// kész
				for(Worker w : workers)
					w.printState(printer);
				break;
			
			case "showstate":									//kész
				showstateCommand(parts);
				break;
			
			case "showmaze":									//kész
				showmazeCommand();
				break;
			
			default:
				System.out.println("Nincs ilyen parancs.");
		}
		
	}
		
	


	public void clearTest() {
		workers.clear();
		boxes.clear();
		fields.clear();
	}
	
	public void initTest1(){
		fieldMap = new FieldBase[1][2];
		
		Worker w = new Worker("w", 10);
		FieldBase f1 = new Field("f1");
		FieldBase f2 = new Field("f2");
		
		fields.add(f1);
		fields.add(f2);
		workers.add(w);
		
		fieldMap[0][0] = f1;
		fieldMap[0][1] = f2;
		
		f1.setNeighbor(Direction.Right, f2);
		f1.setFriction(Friction.Normal);
		f2.setFriction(Friction.Normal);
		f1.setThing(w);
		w.setField(f1);
	}
	
	public void initTest2(){
		fieldMap = new FieldBase[1][2];
		
		Worker w = new Worker("w", 10);
		FieldBase f1 = new Field("f1");
		FieldBase f2 = new Hole("h");
		
		fields.add(f1);
		fields.add(f2);
		workers.add(w);
		
		fieldMap[0][0] = f1;
		fieldMap[0][1] = f2;
		
		f1.setNeighbor(Direction.Right, f2);
		f1.setFriction(Friction.Normal);
		f1.setThing(w);
		w.setField(f1);
	}
	
	public void initTest3(){
		fieldMap = new FieldBase[1][2];
		
		Worker w = new Worker("w", 10);
		FieldBase f1 = new Field("f1");
		FieldBase f2 = new SwitchableHole("shole");
		
		fields.add(f1);
		fields.add(f2);
		workers.add(w);
		
		fieldMap[0][0] = f1;
		fieldMap[0][1] = f2;
		
		f1.setNeighbor(Direction.Right, f2);
		f1.setFriction(Friction.Normal);
		f1.setFriction(Friction.Normal);
		f1.setThing(w);
		w.setField(f1);
	}
	
	public void initTest4(){
		initTest3();
		((SwitchableHole)fields.get(1)).setOpen();
	}
	
	public void initTest5(){
		fieldMap = new FieldBase[1][2];
		
		Worker w = new Worker("w", 10);
		FieldBase f1 = new Field("f1");
		FieldBase f2 = new Obstacle("obs");
		
		fields.add(f1);
		fields.add(f2);
		workers.add(w);
		
		fieldMap[0][0] = f1;
		fieldMap[0][1] = f2;
		
		f1.setNeighbor(Direction.Right, f2);
		f1.setFriction(Friction.Normal);
		f1.setThing(w);
		
		w.setField(f1);
	}
	
	public void initTest6() {
		
	}
	
	public void initTest7() {
		
	}
	
	public void initTest8() {
		fieldMap = new FieldBase[1][3];
		
		Worker w = new Worker("w", 10);
		Box b = new Box("box");
		FieldBase f1 = new Field("f1");
		FieldBase f2 = new Field("f2");
		FieldBase f3 = new Field("f3");
		
		fields.add(f1);
		fields.add(f2);
		fields.add(f3);
		workers.add(w);
		boxes.add(b);
		
		fieldMap[0][0] = f1;
		fieldMap[0][1] = f2;
		fieldMap[0][2] = f3;
		
		f1.setNeighbor(Direction.Right, f2);
		f2.setNeighbor(Direction.Right, f3);
		f1.setFriction(Friction.Normal);
		f2.setFriction(Friction.Normal);
		f3.setFriction(Friction.Normal);
		f1.setThing(w);
		w.setField(f1);
		
		f2.setThing(b);
		b.setField(f2);
	}
	
	private void loadtestCommand(String[] parts) {
		clearTest();
		int test = Integer.parseInt(parts[1]);
		switch (test) {
			case 1:
				initTest1();
				break;
			case 2:
				initTest2();
				break;
			case 3:
				initTest3();
				break;
			case 4:
				initTest4();
				break;
			case 5:
				initTest5();
				break;
			case 6:
				initTest6();
				break;
			case 7:
				initTest7();
				break;
			case 8:
				initTest8();
				break;
		}
	}

	private void showmazeCommand() {
		for(int i = 0; i < fieldMap.length; ++i) {
			for(int j = 0; j < fieldMap[i].length; ++j) {
				FieldBase f = fieldMap[i][j];
				System.out.print(f + ":" + f.getThing()+ " ");
			}
			System.out.println("");
		}
	}

	public void moveCommand(String[] parts) {
		String workerName = parts[1];
		String direction = parts[2];
		if(parts[2] != null) {
			for(Worker w : workers) {
				if(w.name.equals(workerName)) {
					switch(direction) {
						case "right":
							w.Move(Direction.Right);
							break;
						case "left":
							w.Move(Direction.Left);
							break;
						case "up":
							w.Move(Direction.Up);
							break;
						case "down":
							w.Move(Direction.Down);
							break;
					}
				}
			}
		}
			
	}
	
	public void showstateCommand(String[] parts) {
		if (parts[1] == null) {
			System.out.println("Hibas parancs.");
			return;
		}
			
		for (FieldBase f : fields) {
			if (f.name.equals(parts[1])) {
				f.printState(printer);
				return;
			}
		}
		
		for (Box b : boxes) {
			if (b.name.equals(parts[1])) {
				b.printState(printer);
				return;
			}
		}
		
		for (Worker w : workers) {
			if (w.name.equals(parts[1])) {
				w.printState(printer);
				return;
			}
		}
		
	}
}
