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
	
	//fogadja a rá érkezõ dobozt, és állapotot vált
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		Change();
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		/*if (super.Accept(b))
		{
			Change();
			return true;
		}*/
		return false;
	}
	
	//fogadja a rá érkezõ munkást
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		//return super.Accept(w);
		return false;
	}
	
	//beállítja a hozzá tartozó csapóajtót
	void SetSw(SwitchableHole sw) {
		hole = sw;
	}
	
	//vált, és váltja a hozzá tartozó csapóajtót is
	public void Change() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		hole.SetOpen();
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		on = !on;
	}
}
