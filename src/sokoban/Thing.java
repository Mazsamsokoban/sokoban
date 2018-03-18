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
		return d;
	}
	
	Field getField()
	{
		return field;
	}
}
