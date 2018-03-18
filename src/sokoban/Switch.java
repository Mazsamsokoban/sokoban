package sokoban;

public class Switch extends Field {
	private boolean on;
	private SwitchableHole hole;
	
	public boolean Accept(Box b) {
		if (super.Accept(b))
		{
			Change();
			return true;
		}
		return false;
	}
	
	public boolean Accept(Worker w) {
		return super.Accept(w);
	}
	
	public void Change() {
		on = !on;
	}
}
