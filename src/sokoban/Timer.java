package sokoban;

import java.util.ArrayList;

public class Timer extends ArrayList<Steppable> {
	
	public Timer() {
		Game.op.makeCall(null);
		System.out.print("Timer()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Timer()");
	}
	//lépteti a Steppable-eket
	public void Tick() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		for(Steppable s : this) {
			s.Step();
		}
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
	
	//elindul
	public void Start() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
}
