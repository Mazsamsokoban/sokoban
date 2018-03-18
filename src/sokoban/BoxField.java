package sokoban;


public class BoxField extends Field {
	private Worker owner;
	
	public void SetOwner(Worker w) {
	}
	
	public boolean Accept(Box b) {
		return false;
	}
	
	public boolean Accept(Worker w) {
		return false;
	}
}
