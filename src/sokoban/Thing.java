package sokoban;

public abstract class Thing {
	private Direction d;
	protected Field field;
	
	public abstract void CollideWith(Thing t);
	
	public abstract void HitBy(Box b, Direction dir);
	
	public abstract void HitBy(Worker w, Direction dir);
	
	public abstract void Delete();
	
	abstract Worker Notify();
	
	Direction getDirection()
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return d;
	}
	
	Field getField()
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return field;
	}
}
