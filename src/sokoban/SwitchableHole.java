package sokoban;

public class SwitchableHole extends Hole {
	private boolean open;
	private Thing thing;
	
	public void SetOpen() {
		open = !open;
	}
	
	public boolean Accept(Box b) {
		if (open)
			return super.Accept(b);
		else
		{
			if (thing != null)
			{
				b.CollideWith(thing);
				return Accept(b);
			}
			return true;
		}			
	}
	
	public boolean Accept(Worker w) {
		if (open)
			return super.Accept(w);
		else
		{
			if (thing != null)
			{
				w.CollideWith(thing);
				return Accept(w);
			}
			return true;
		}		
	}
}
