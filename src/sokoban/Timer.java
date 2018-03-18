package sokoban;


public class Timer {
	public Timer() {
		Game.op.makeCall(null);
		System.out.print("Timer()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Timer()");
	}
	public void Tick() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
	
	public void Start() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
}
