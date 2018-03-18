package sokoban;
import java.util.HashMap;


public abstract class FieldBase {
	protected Thing things;
	private HashMap<Direction, FieldBase> neighbours = new HashMap<Direction, FieldBase>();
	//private FieldBase neighbours;
	public abstract boolean Accept(Box b);
	
	public abstract boolean Accept(Worker w);
	
	public FieldBase GetNeighbor(Direction d) {
		return neighbours.get(d);
	}
	
	public void SetNeighbor(Direction d, FieldBase f) {
		neighbours.put(d, f);
	}	
}
