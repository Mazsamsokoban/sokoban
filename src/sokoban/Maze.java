package sokoban;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//a raktárépület
public class Maze {
	public Tester tester;
	
	private FieldBase fields[][];
	//private List<FieldBase> fields;
	private List<Box> boxes;
	private List<Worker> workers;
	private Timer t;
	private Game game;
	
	//létrehozza az elemeknek a tárolókat 
	public Maze() {
		fields = new FieldBase[5][5];
		boxes = new ArrayList<Box>();
		workers = new ArrayList<Worker>();
	}
	
	//inicializál egy pályát, amin a viselkedések bemutathatók
	public void init() {
		/*
		
		t = new Timer();
		/////////////////////////////////////////////////////
		Field f0 = new Field();
		Field f1 = new Field();
		Field f2 = new Field();
		Field f3 = new Field();
		Field f4 = new Field();
		Field f5 = new Field();
		Field f6 = new Field();
		Field f7 = new Field();
		SwitchableHole sh = new SwitchableHole();
		
		fields.add(f0);
		fields.add(f1);
		fields.add(f2);
		fields.add(f3);
		fields.add(f4);
		fields.add(f5);
		fields.add(f6);
		fields.add(f7);
		fields.add(sh);
		
		Worker w = new Worker();
		w.setField(f1);
		
		Box box0 = new Box();
		box0.setField(f3);
		
		
		Box box1 = new Box();
		box1.setField(f4);
		
		
		Box box2 = new Box();
		box2.setField(f5);
		
		
		boxes.add(box0);
		boxes.add(box1);
		boxes.add(box2);
		
		workers.add(w);
		
		t.add(w);
		////////////////////////////////////////////////////////////////
		
		Field f8 = new Field();
		Field f9 = new Field();
		Field f10 = new Field();
		Field f11 = new Field();
		Field f12 = new Field();
		Field f13 = new Field();
		Field f14 = new Field();
		Field f15 = new Field();
		Field f16 = new Field();
		Hole hole1 = new Hole();
		Hole hole2 = new Hole();
		BoxField bfield = new BoxField();
		Switch sw = new Switch();
		Obstacle obs = new Obstacle();
		
		sw.SetSh(sh);
		
		fields.add(f8);
		fields.add(f9);
		fields.add(f10);
		fields.add(f11);
		fields.add(f12);
		fields.add(f13);
		fields.add(f14);
		fields.add(f15);
		fields.add(f15);
		fields.add(f16);
		fields.add(hole1);
		fields.add(hole2);
		fields.add(bfield);
		fields.add(sw);
		fields.add(obs);
		
		Worker w1 = new Worker();	
		w1.setField(f10);
		Worker w2 = new Worker();
		w2.setField(f12);
		
		Box box3 = new Box();
		box3.setField(f9);
		Box box4 = new Box();
		box4.setField(f11);
		Box box5 = new Box();
		box5.setField(f13);
		Box box6 = new Box();
		box6.setField(bfield);
		Box box7 = new Box();
		box7.setField(f16);
		
		boxes.add(box3);
		boxes.add(box4);
		boxes.add(box5);
		boxes.add(box6);
		boxes.add(box7);
		
		
		workers.add(w1);
		workers.add(w2);
		
		t.add(w1);
		t.add(w2);
		
		
		

		
		
		Game.op.put(t, "t");
		Game.op.put(f0, "f0");
		Game.op.put(f1, "f1");
		Game.op.put(f2, "f2");
		Game.op.put(f3, "f3");
		Game.op.put(f4, "f4");
		Game.op.put(f5, "f5");
		Game.op.put(f6, "f6");
		Game.op.put(f7, "f7");
		Game.op.put(f8, "f8");
		Game.op.put(f9, "f9");
		Game.op.put(f10, "f10");
		Game.op.put(f11, "f11");
		Game.op.put(f12, "f12");
		Game.op.put(f13, "f13");
		Game.op.put(f14, "f14");
		Game.op.put(f15, "f15");
		Game.op.put(f16, "f16");
		Game.op.put(bfield, "bfield");
		Game.op.put(w, "w");
		Game.op.put(w1, "w1");
		Game.op.put(w2, "w2");
		Game.op.put(box0, "box0");
		Game.op.put(box1, "box1");
		Game.op.put(box2, "box2");
		Game.op.put(box3, "box3");
		Game.op.put(box4, "box4");
		Game.op.put(box5, "box5");
		Game.op.put(box6, "box6");
		Game.op.put(box7, "box7");
		Game.op.put(sw, "sw");
		Game.op.put(sh, "sh");
		Game.op.put(hole1, "hole1");
		Game.op.put(hole2, "hole2");
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
		Game.op.addPair("f8", f8);
		Game.op.addPair("f9", f9);
		Game.op.addPair("f10", f10);
		Game.op.addPair("f11", f11);
		Game.op.addPair("f12", f12);
		Game.op.addPair("f13", f13);
		Game.op.addPair("f14", f14);
		Game.op.addPair("f15", f15);
		Game.op.addPair("f16", f16);
		
		Game.op.addPair("w", w);
		Game.op.addPair("w1", w1);
		Game.op.addPair("w2", w2);
		Game.op.addPair("box0", box0);
		Game.op.addPair("box1", box1);
		Game.op.addPair("box2", box2);
		Game.op.addPair("box3", box3);
		Game.op.addPair("box4", box4);
		Game.op.addPair("box5", box5);
		Game.op.addPair("box6", box6);
		Game.op.addPair("box7", box7);
		Game.op.addPair("sw", sw);
		Game.op.addPair("sh", sh);
		Game.op.addPair("hole1", hole1);
		Game.op.addPair("hole2", hole2);
		Game.op.addPair("bfield", bfield);
		Game.op.addPair("obs", obs);
		
		
		
		
		
		tester.t = this.t;
		tester.f0 = f0;
		tester.f1 = f1;
		tester.f2 = f2;
		tester.f3 = f3;
		tester.f4 = f4;
		tester.f5 = f5;
		tester.f6 = f6;
		tester.f7 = f7;
		tester.f8 = f8;
		tester.f9 = f9;
		tester.f10 = f10;
		tester.f11 = f11;
		tester.f12 = f12;
		tester.f13 = f13;
		tester.f14 = f14;
		tester.f15 = f15;
		tester.f16 = f16;
		tester.w = w;
		tester.w1 = w1;
		tester.w2 = w2;
		tester.box0 = box0;
		tester.box1 = box1;
		tester.box2 = box2;
		tester.box3 = box3;
		tester.box4 = box4;
		tester.box5 = box5;
		tester.box6 = box6;
		tester.box7 = box7;
		tester.sh = sh;
		tester.sw = sw;
		tester.obs = obs;
		tester.bfield = bfield;
		
		f7.setNeighbor(Direction.Right, f3);
		f3.setNeighbor(Direction.Left, f7);
		
		f3.setNeighbor(Direction.Right, f1);
		f1.setNeighbor(Direction.Left, f3);
		
		f1.setNeighbor(Direction.Right, sh);
		sh.setNeighbor(Direction.Left, f1);
		
		f1.setNeighbor(Direction.Up, f2);
		f2.setNeighbor(Direction.Down, f1);
		
		f1.setNeighbor(Direction.Down, f4);
		f4.setNeighbor(Direction.Up, f1);
		
		f4.setNeighbor(Direction.Down, f5);
		f5.setNeighbor(Direction.Up, f4);
		
		f5.setNeighbor(Direction.Down, f6);
		f6.setNeighbor(Direction.Up, f5);
		
		///////////////////////////////////////
		sw.setNeighbor(Direction.Down, f9);
		f9.setNeighbor(Direction.Down, f10);
		f10.setNeighbor(Direction.Left, hole2);
		f10.setNeighbor(Direction.Right, f16);
		f10.setNeighbor(Direction.Down, f11);
		f16.setNeighbor(Direction.Right, hole1);
		f11.setNeighbor(Direction.Down, f12);
		f12.setNeighbor(Direction.Down, f14);
		f12.setNeighbor(Direction.Right, bfield);
		f12.setNeighbor(Direction.Left, f13);
		f13.setNeighbor(Direction.Left, obs);
		bfield.setNeighbor(Direction.Right, f15);
		
		f3.thing = box0;
		f4.thing = box1;
		f5.thing = box2;
		
		f9.thing = box3;
		f11.thing = box4;
		f13.thing = box5;
		bfield.thing = box6;
		f16.thing = box7;
		
		f10.thing = w1;
		f12.thing = w2;
		
		
		f1.thing = w;
		
		System.out.print(f3.getNeighbor(Direction.Left));
		Game.op.returnFromFunc(null);
		System.out.print("init()");*/
		
		
	}
	//ellenõrzi, hogy teljesülnek-e a játék befejezésének feltételei, és ez alapján tér vissza
	public boolean CheckEndOfGame() throws IOException
	{
		if (CheckBoxes())
			return true;
		else if (workers.size() <= 1)
			return true;
		return false;
	}
	
	
	public void setGame(Game g) {
		game = g;
	}
	
	public boolean CheckBoxes() throws IOException
	{
		for (Box b : boxes)
		{
			if (!b.isOnBoxField()) {
				return false;
			}
		}
		return true;		
	}
	
}
