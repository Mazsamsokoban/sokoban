package sokoban;
import java.util.HashMap;

// mezõk õsosztálya
public abstract class FieldBase {
	protected Thing thing;
	private HashMap<Direction, FieldBase> neighbours;
	//private FieldBase neighbours;
	
	public FieldBase() {
		neighbours = new HashMap<Direction, FieldBase>();
	}
	
	//absztrakt fogadó függvények
	public abstract boolean Accept(Box b);
	
	public abstract boolean Accept(Worker w);
	
	//beállítja kölcsönösen a paraméterrel a szomszédságot
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
        if (f.GetNeighbor(n) == null)
            f.SetNeighbor(n, this);
        Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d, " + Game.op.get(f) + ")");
    }
	
	//visszaadja a megadott irányban lévõ szomszéd mezõt
	public FieldBase GetNeighbor(Direction d) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		return neighbours.get(d);
	}
	
	
}
