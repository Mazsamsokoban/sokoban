package sokoban;

public class SwitchableHole extends Hole {
	private boolean open;
	private Thing thing;
	public void SetOpen() {
	}
	
	public boolean Accept(Box b) {
		return false;
	}
	
	public boolean Accept(Worker w) {
		return false;
	}
}
