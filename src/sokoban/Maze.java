package sokoban;

import java.util.List;

public class Maze {
	private List<FieldBase> fields;
	private List<Box> boxes;
	private List<Worker> workers;
	
	public Maze() {
		Game.op.makeCall(null);
		System.out.print("Maze()");
		init();
		Game.op.returnFromFunc(null);
		System.out.print("Maze()");
	}
	
	public void init() {
		Game.op.makeCall(null);
		System.out.print("init()");
		
		Worker w = new Worker();
		Field f0 = new Field();
		f0.Accept(w);
		SwitchableHole sh = new SwitchableHole();
		Field f1 = new Field();
		Field f5 = new Field();
		Box box0 = new Box();
		f5.Accept(box0);
		Field f2 = new Field();
		Box box1 = new Box();
		f2.Accept(box1);
		Field f6 = new Field();
		Switch sw = new Switch();
		Hole h = new Hole();
		Field f3 = new Field();
		Box box2 = new Box();
		f3.Accept(box2);
		Field f4 = new Field();
		Worker w2 = new Worker();
		f4.Accept(w2);
		Field f7 = new Field();
		Obstacle obs = new Obstacle();
		
		
		
	
		
		
		
		
		Game.op.returnFromFunc(null);
		System.out.print("init()");
	}
	
	public boolean CheckEndOfGame()
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		if (CheckBoxes())
			return true;
		else if (workers.size() <= 1)
			return true;
		
		return false;
		
	}
	
	public boolean CheckBoxes()
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		for (Box b : boxes)
		{
			if (!b.onBoxField) {
				return false;
			}
		}
		
		return true;		
	}
	
}
