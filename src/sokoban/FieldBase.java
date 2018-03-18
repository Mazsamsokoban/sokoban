package sokoban;


public abstract class FieldBase {
	private Thing things;
	private FieldBase neighbors;
	private FieldBase neighbours;
	public boolean Accept(Box b) {
		return false;
	
	}
	
	public boolean Accept(Worker w) {
		return false;
	}
	
	public FieldBase GetNeighbor(Direction d) {
		return new Field();
	}
	
	public void SetNeighbor(Direction d, FieldBase f) {
	}
}
