package sokoban;

public class Hole extends FieldBase {
	public boolean Accept(Box b) {
		return false;
	}
	
	public boolean Accept(Worker w) {
		return false;
	}
}
