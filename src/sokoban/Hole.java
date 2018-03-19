package sokoban;

public class Hole extends FieldBase {
	public Hole() {
		Game.op.makeCall(null);
		System.out.print("Hole()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Hole()");
	}
	
	//fogadja a r� �rkez� dobozt, azaz ledobja
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		b.Delete();
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		return true;
	}
	
	//fogadja a r� �rkez� munk�st, azaz ledobja
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		w.Delete();
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		return true;
	}
}
