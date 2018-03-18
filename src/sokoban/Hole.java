package sokoban;

public class Hole extends FieldBase {
	public boolean Accept(Box b) {
		b.Delete();
		return true;
	}
	
	public boolean Accept(Worker w) {
		w.Delete();
		return true;
	}
}
