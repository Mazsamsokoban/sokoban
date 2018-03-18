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
		Field f = new Field();
		f.Accept(w);
		SwitchableHole sh = new SwitchableHole();
		Box box1 = new Box();
		Switch sw = new Switch();
		Hole h = new Hole();
		BoxField bf = new BoxField();
		
		
		
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
