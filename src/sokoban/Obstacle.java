package sokoban;


public class Obstacle extends FieldBase {
	public Obstacle() {
		Game.op.makeCall(null);
		System.out.print("Obstacle()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Obstacle()");
	}
	
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		return false;
	}
	
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		return false;
	}
}
