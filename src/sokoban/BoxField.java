package sokoban;


public class BoxField extends Field {
	//Debug
	boolean debug = true;
	public void ChangeDebug()
	{
		debug = !debug;
	}
	//Debug
	
	
	private Worker owner;
	
	
	
	public BoxField() {
		Game.op.makeCall(null);
		System.out.print("BoxField()");
		
		Game.op.returnFromFunc(null);
		System.out.print("BoxField()");
	}
	
	//beállítja a betolóját
	public void SetOwner(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		owner = w;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		
	}
	
	//dobozt fogad, és pontot ad, illetve jelez a tólókon keresztül
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		if (thing != null)
		{
			b.CollideWith(thing);
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
	
	//munkást fogad, és elhelyezi a mezõn, ha lehet
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		return super.Accept(w);
	}
	
	//leveszi a mezõn lévõ boxot, és ha olyan tolta le, aki betolta, akkor pontot von le
	@Override
	public void Remove()
	{
		
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		Worker pusher = ((Box)thing).pusher;
		if(pusher == this.owner)
			pusher.AddPoints(-1);
		
		thing = null;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
}
