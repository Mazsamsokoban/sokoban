package sokoban;


public class Field extends FieldBase  {
	public Field() {
		Game.op.makeCall(null);
		System.out.print("Field()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Field()");
	}
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		if (things != null)
		{
			b.CollideWith(things);
			return Accept(b);
		}
		return true;
	}
	
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		if (things != null)
		{
			w.CollideWith(things);
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
			return Accept(w);
		}
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		return true;
	}
	
	public void Remove()
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		super.things = null;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
	}
}
