package sokoban;

public class Box extends Thing {
	private Worker owner;
	private Worker pusher;
	public boolean onBoxField = false;
	
	public Box() {
		Game.op.makeCall(null);
		System.out.print("Box()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Box()");
	}
	public void CollideWith(Thing t) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "(" + Game.op.get(t) + ")");
		t.HitBy(this, super.getDirection());
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "(" + Game.op.get(t) + ")");
	}
	
	public void HitBy(Box b, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "(" + Game.op.get(b) +  ", dir)");
		
		if (getField().GetNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}		
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ", dir)");
	}
	
	public void HitBy(Worker w, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
		if (getField().GetNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}		
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
	}
	
	public void Delete() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		field = null;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}

	@Override
	Worker Notify() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return pusher.Notify();
	}
}
