package sokoban;


public abstract class FieldBase {
	private Thing things;
	private FieldBase neighbors;
	private FieldBase neighbours;
	public boolean Accept(Box b) {
	
	}
	
	public boolean Accept(Worker w) {
	}
	
	public FieldBase GetNeighbor(Direction d) {
	}
	
	public void SetNeighbor(Direction d, FieldBase f) {
	}
}
