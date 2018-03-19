package sokoban;

public class Box extends Thing {
	Worker owner;
	Worker pusher;
	public boolean onBoxField = false;
	
	//Box kontruktor
	public Box() {
		Game.op.makeCall(null);
		System.out.print("Box()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Box()");
	}
	
	//ütköztetõ fgv
	public void CollideWith(Thing t) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "(" + Game.op.get(t) + ")");
		t.HitBy(this, super.getDirection());
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "(" + Game.op.get(t) + ")");
	}
	
	//nekimegy a dir irányban egy box
	public void HitBy(Box b, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName()+ "(" + Game.op.get(b) +  ", dir)");
		super.d = dir;
		if (getField().GetNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}		
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ", dir)");
	}
	
	//nekimegy a dir irányban egy box
	public void HitBy(Worker w, Direction dir) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
		super.d = dir;
		this.pusher = w;
		FieldBase f = getField().GetNeighbor(dir);
		Field old = getField();
		if (f.Accept(this))
		{
			old.Remove();
		}		
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ", dir)");
	}
	
	//törli magát a mezõjérõl
	public void Delete() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		field = null;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}

	//jelzi, hogy beérkezett
	@Override
	Worker Notify() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		return pusher.Notify();
	}
}
