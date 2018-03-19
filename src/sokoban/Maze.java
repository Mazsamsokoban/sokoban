package sokoban;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Maze {
	public Tester tester;
	
	private List<FieldBase> fields;
	private List<Box> boxes;
	private List<Worker> workers;
	private Timer t;
	private Game game;
	
	public Maze() {
		Game.op.makeCall(null);
		System.out.print("Maze()");
		fields = new ArrayList<FieldBase>();
		boxes = new ArrayList<Box>();
		workers = new ArrayList<Worker>();
		Game.op.returnFromFunc(null);
		System.out.print("Maze()");
	}
	
	public void init() {
		Game.op.makeCall(null);
		System.out.print("init()");
		
		t = new Timer();
		
		Field f0 = new Field();
		Field f1 = new Field();
		Field f2 = new Field();
		Field f3 = new Field();
		Field f4 = new Field();
		Field f5 = new Field();
		Field f6 = new Field();
		Field f7 = new Field();
		
		fields.add(f0);
		fields.add(f1);
		fields.add(f2);
		fields.add(f3);
		fields.add(f4);
		fields.add(f5);
		fields.add(f6);
		fields.add(f7);
		
		Worker w = new Worker();
		Worker w2 = new Worker();
		w.setField(f0);
		w2.setField(f4);
		
		workers.add(w);
		workers.add(w2);
		
		t.add(w);
		t.add(w2);
		
		Box box0 = new Box();
		Box box1 = new Box();
		Box box2 = new Box();
		
		box0.setField(f5);
		box1.setField(f2);
		box2.setField(f3);
		
		boxes.add(box0);
		boxes.add(box1);
		boxes.add(box2);

		Switch sw = new Switch();
		
		SwitchableHole sh = new SwitchableHole();
		
		Hole hole = new Hole();
		
		BoxField bfield = new BoxField();
		
		Obstacle obs = new Obstacle();
		
		fields.add(sw);
		fields.add(sh);
		fields.add(hole);
		fields.add(bfield);
		fields.add(obs);
		
		Game.op.put(t, "t");
		Game.op.put(f0, "f0");
		Game.op.put(f1, "f1");
		Game.op.put(f2, "f2");
		Game.op.put(f3, "f3");
		Game.op.put(f4, "f4");
		Game.op.put(f5, "f5");
		Game.op.put(f6, "f6");
		Game.op.put(f7, "f7");
		Game.op.put(w, "w");
		Game.op.put(w2, "w2");
		Game.op.put(box0, "box0");
		Game.op.put(box1, "box1");
		Game.op.put(box2, "box2");
		Game.op.put(sw, "sw");
		Game.op.put(sh, "sh");
		Game.op.put(hole, "hole");
		Game.op.put(bfield, "bfield");
		Game.op.put(obs, "obs");
		
		Game.op.addPair("t", t);
		Game.op.addPair("f0", f0);
		Game.op.addPair("f1", f1);
		Game.op.addPair("f2", f2);
		Game.op.addPair("f3", f3);
		Game.op.addPair("f4", f4);
		Game.op.addPair("f5", f5);
		Game.op.addPair("f6", f6);
		Game.op.addPair("f7", f7);
		Game.op.addPair("w", w);
		Game.op.addPair("w2", w2);
		Game.op.addPair("box0", box0);
		Game.op.addPair("box1", box1);
		Game.op.addPair("box2", box2);
		Game.op.addPair("sw", sw);
		Game.op.addPair("sh", sh);
		Game.op.addPair("hole", hole);
		Game.op.addPair("bfield", bfield);
		Game.op.addPair("obs", obs);
		
		
		
		f0.SetNeighbor(Direction.Right, f1);
		f0.SetNeighbor(Direction.Down, sh);		

		f1.SetNeighbor(Direction.Right, f2);
		f1.SetNeighbor(Direction.Down, f5);
	
		f2.SetNeighbor(Direction.Right, sw);
		f2.SetNeighbor(Direction.Down, f6);
		
		sw.SetNeighbor(Direction.Right, f3);
		sw.SetNeighbor(Direction.Down, hole);

		f3.SetNeighbor(Direction.Right, f4);
		f3.SetNeighbor(Direction.Down, bfield);
		

		f4.SetNeighbor(Direction.Down, f7);
		
		f6.SetNeighbor(Direction.Right, hole);
		
		f7.SetNeighbor(Direction.Right, obs);
		
		sh.SetNeighbor(Direction.Right, f5);
		
		f5.SetNeighbor(Direction.Right, f6);
		
		hole.SetNeighbor(Direction.Right,bfield);
		
		bfield.SetNeighbor(Direction.Right, f7);
		
		

		w.field = f0;
		f0.things = w;
		
		box1.field = f2;
		f2.things = box1;
		
		box2.field = f3;
		f3.things = box2;
		
		w2.field = f4;
		f4.things = w2;
		
		box0.field = f5;
		f5.things = box0;
		
		tester.t = this.t;
		tester.f0 = f0;
		tester.f1 = f1;
		tester.f2 = f2;
		tester.f3= f3;
		tester.f4 = f4;
		tester.f5 = f5;
		tester.f6 = f6;
		tester.f7 = f7;
		tester.w = w;
		tester.w2 = w2;
		tester.box0 = box0;
		tester.box1 = box1;
		tester.box1 = box1;
		tester.sh = sh;
		tester.sw = sw;
		tester.obs = obs;
		tester.bfield = bfield;
		Game.op.returnFromFunc(null);
		System.out.print("init()");
		
		
	}
	
	public boolean CheckEndOfGame() throws IOException
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		
		/*if (CheckBoxes())
			return true;
		else if (workers.size() <= 1)
			return true;
		*/
		System.out.println("\nMaradt még legalább 2 munkás ? I/N");
		String choice = Game.op.br.readLine();
		if(choice.charAt(0) == 'N' || choice.charAt(0) == 'n') {
			game.endGame();
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
			return true;
		}
		
		CheckBoxes();
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return false;
		
	}
	
	
	public void setGame(Game g) {
		game = g;
	}
	
	public boolean CheckBoxes() throws IOException
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		System.out.println("\nHelyükre kerültek a dobozok ? I/N");
		String choice = Game.op.br.readLine();
		if(choice.charAt(0) == 'I' || choice.charAt(0) == 'i') {
			game.endGame();
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
			return true;
		}
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		/*for (Box b : boxes)
		{
			if (!b.onBoxField) {
				return false;
			}
		}*/
		
		return false;		
	}
	
}
