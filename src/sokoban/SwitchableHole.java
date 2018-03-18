package sokoban;

public class SwitchableHole extends Hole {
	private boolean open;
	private Thing thing;
	
	public SwitchableHole() {
		Game.op.makeCall(null);
		System.out.print("SwitchableHole()");
		
		Game.op.returnFromFunc(null);
		System.out.print("SwitchableHole()");
	}
	public void SetOpen() {
		open = !open;
	}
	
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		
		if (open) {
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
			return super.Accept(b);
		}
		else
		{
			if (thing != null)
			{
				b.CollideWith(thing);
				Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
				return Accept(b);
			}
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
			return true;
		}			
	}
	
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		
		if (open) {
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
			return super.Accept(w);
		}
		else
		{
			if (thing != null)
			{
				w.CollideWith(thing);
				Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
				return Accept(w);
			}
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
			return true;
		}		
	}
}
