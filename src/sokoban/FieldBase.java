package sokoban;
import java.util.HashMap;


public abstract class FieldBase {
	protected Thing things;
	private HashMap<Direction, FieldBase> neighbours = new HashMap<Direction, FieldBase>();
	//private FieldBase neighbours;
	public abstract boolean Accept(Box b);
	
	public abstract boolean Accept(Worker w);
	public void SetNeighbor(Direction d, FieldBase f) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d, " + Game.op.get(f) + ")");
		neighbours.put(d, f);
        Direction n = null;
        switch (d)
        {
        case Up: n = Direction.Down; break;
        case Down: n = Direction.Up; break;
        case Right: n = Direction.Left; break;
        case Left: n = Direction.Right; break;
        }
        if (!f.neighbours.containsKey(n))
            f.SetNeighbor(n, this);
        Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d, " + Game.op.get(f) + ")");
    }
	public FieldBase GetNeighbor(Direction d) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		return neighbours.get(d);
	}
	
	
}
