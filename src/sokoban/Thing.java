package sokoban;

public abstract class Thing {
	protected Direction d;
	protected Field field;
	
	
	//absztrakt �tk�ztet� �s t�rl� fgv-ek
	public abstract void CollideWith(Thing t);
	
	public abstract void HitBy(Box b, Direction dir);
	
	public abstract void HitBy(Worker w, Direction dir);
	
	public abstract void Delete();
	
	abstract Worker Notify();
	
	
	//menetir�ny visszaad�sa
	Direction getDirection()
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return d;
	}
	
	//tartalmaz� mez� visszaad�sa
	Field getField()
	{
		//Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		//Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return field;
	}
	//tartalmaz� mez� be�ll�t�sa
	void setField(Field f) {
		field = f;
	}
}
