package sokoban;
import java.util.HashMap;

// mez�k �soszt�lya
public abstract class FieldBase {
	protected Thing thing;
	private HashMap<Direction, FieldBase> neighbours;
	//private FieldBase neighbours;
	
	public FieldBase() {
		neighbours = new HashMap<Direction, FieldBase>();
	}
	
	//absztrakt fogad� f�ggv�nyek
	public abstract boolean Accept(Box b);
	
	public abstract boolean Accept(Worker w);
	
	//be�ll�tja k�lcs�n�sen a param�terrel a szomsz�ds�got
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
	
	//visszaadja a megadott ir�nyban l�v� szomsz�d mez�t
	public FieldBase GetNeighbor(Direction d) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(d)");
		return neighbours.get(d);
	}
	
	
}
