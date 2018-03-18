package sokoban;
import java.util.HashMap;


public abstract class FieldBase {
	protected Thing things;
	private HashMap<Direction, FieldBase> neighbours = new HashMap<Direction, FieldBase>();
	//private FieldBase neighbours;
	public abstract boolean Accept(Box b);
	
	public abstract boolean Accept(Worker w);
	
	public FieldBase GetNeighbor(Direction d) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		return neighbours.get(d);
	}
	
	public void SetNeighbor(Direction d, FieldBase f) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d, " + Game.op.get(f) + ")");
		neighbours.put(d, f);
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d, " + Game.op.get(f) + ")");
		
	}	
}
