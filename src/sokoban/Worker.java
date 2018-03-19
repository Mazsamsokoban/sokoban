package sokoban;


public class Worker extends Thing implements Steppable {
	private long points;
	
	public Worker() {
		Game.op.makeCall(null);
		System.out.print("Worker()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Worker()");
	}
	public boolean Move(Direction d) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		FieldBase f1 = field.GetNeighbor(d);
		f1.Accept(this);
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		return false;
	}
	
	public void AddPoints(long p) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(1)");
		points += p;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(1)");
	}
	
	public void CollideWith(Thing t) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(t) +  ")");
		t.HitBy(this, getDirection());
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(t) +  ")");	
	}
	
	public void HitBy(Worker w, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
		// w, wyd?
	}
	
	public void HitBy(Box b, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ", dir)");
		if (getField().GetNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}	
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ", dir)");
	}
	
	public void Delete() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		field = null;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
	
	public void Step() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		// getteljuk az inputot, de ez meg nem kell (AFAIK)
	}

	@Override
	Worker Notify() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return this;
	}
}
