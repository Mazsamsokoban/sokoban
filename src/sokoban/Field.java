package sokoban;


public class Field extends FieldBase  {
	public boolean Accept(Box b) {
		return false;
	}
	
	public boolean Accept(Worker w) {
		return false;
	}
	
	public void Remove() {
	}
}
