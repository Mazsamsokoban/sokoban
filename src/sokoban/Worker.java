package sokoban;


public class Worker extends Thing implements Steppable {
	private long points;
	
	public Worker() {
		Game.op.makeCall(null);
		System.out.print("Worker()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Worker()");
	}
	
	//a munkás a megadott irányban lévõ mezõre mozog
	public boolean Move(Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		FieldBase f1 = field.GetNeighbor(dir);
		super.d = dir;
		Field old = getField();
		if (f1.Accept(this))
		{
			old.Remove();
		}
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		return false;
	}
	
	//a munkás p pontot kap
	public void AddPoints(long p) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(1)");
		points += p;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(1)");
	}
	
	//a munkás ütközik a t dologgal
	public void CollideWith(Thing t) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(t) +  ")");
		t.HitBy(this, getDirection());
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(t) +  ")");	
	}
	
	//a munkásnak dir irányban nekimegy egy másik munkás
	public void HitBy(Worker w, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
		
	}
	//a munkásnak dir irányban nekimegy egy doboz
	public void HitBy(Box b, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ", dir)");
		if (getField().GetNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}	
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ", dir)");
	}
	
	//a munkás törlõdik a mezõjérõl
	public void Delete() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		field = null;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
	
	// a munkás lép
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
