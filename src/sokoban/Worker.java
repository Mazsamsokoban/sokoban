package sokoban;


public class Worker extends Thing implements Steppable {
	private long points;
	
	public Worker() {
		Game.op.makeCall(null);
		System.out.print("Worker()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Worker()");
	}
	
	//a munk�s a megadott ir�nyban l�v� mez�re mozog
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
	
	//a munk�s p pontot kap
	public void AddPoints(long p) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(1)");
		points += p;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(1)");
	}
	
	//a munk�s �tk�zik a t dologgal
	public void CollideWith(Thing t) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(t) +  ")");
		t.HitBy(this, getDirection());
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(t) +  ")");	
	}
	
	//a munk�snak dir ir�nyban nekimegy egy m�sik munk�s
	public void HitBy(Worker w, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
		
	}
	//a munk�snak dir ir�nyban nekimegy egy doboz
	public void HitBy(Box b, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ", dir)");
		if (getField().GetNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}	
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ", dir)");
	}
	
	//a munk�s t�rl�dik a mez�j�r�l
	public void Delete() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		field = null;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
	
	// a munk�s l�p
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
