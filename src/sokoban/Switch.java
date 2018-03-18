package sokoban;

public class Switch extends Field {
	private boolean on;
	private SwitchableHole hole;
	
	public boolean Accept(Box b) {
		return false;
	}
	
	public boolean Accept(Worker w) {
		return false;
	}
	
	public void Change() {
	}
}
