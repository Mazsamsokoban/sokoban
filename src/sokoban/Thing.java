package sokoban;

public abstract class Thing {
	protected Direction d;
	protected Field field;
	
	
	//absztrakt ütköztetõ és törlõ fgv-ek
	public abstract void CollideWith(Thing t);
	
	public abstract void HitBy(Box b, Direction dir);
	
	public abstract void HitBy(Worker w, Direction dir);
	
	public abstract void Delete();
	
	abstract Worker Notify();
	
	
	//menetirány visszaadása
	Direction getDirection()
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return d;
	}
	
	//tartalmazó mezõ visszaadása
	Field getField()
	{
		//Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		//Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return field;
	}
	//tartalmazó mezõ beállítása
	void setField(Field f) {
		field = f;
	}
}
