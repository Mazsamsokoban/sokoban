package sokoban;

public class Switch extends Field {
	private boolean on;
	private SwitchableHole hole;
	
	public Switch() {
		Game.op.makeCall(null);
		System.out.print("Switch()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Switch()");
	}
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		if (super.Accept(b))
		{
			Change();
			return true;
		}
		return false;
	}
	
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		return super.Accept(w);
	}
	
	public void Change() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		on = !on;
	}
}
