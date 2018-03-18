package sokoban;


public class BoxField extends Field {
	private Worker owner;
	
	public BoxField() {
		Game.op.makeCall(null);
		System.out.print("BoxField()");
		
		Game.op.returnFromFunc(null);
		System.out.print("BoxField()");
	}
	public void SetOwner(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		owner = w;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		//SetColor(w.color);
	}
	
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		if (things != null)
		{
			b.CollideWith(things);
			return Accept(b);
		}
		
		Worker pusher = b.Notify();	
		
		if (pusher == owner)
		{
			pusher.AddPoints(1);
		}
		else if (owner == null)
		{
			pusher.AddPoints(1);
			SetOwner(pusher);
		}
		
		b.onBoxField = true;
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		
		return true;
	}
	
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		return super.Accept(w);
	}
	
	@Override
	public void Remove()
	{
		// ???
		/**
		 * ha a box elhagyja a boxfieldet, amit nem tudunk mert csak Thing-kent tudjuk mi van rajtunk, akkor pls mit tegyek
		 */
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
}
