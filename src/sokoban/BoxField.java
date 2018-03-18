package sokoban;


public class BoxField extends Field {
	private Worker owner;
	
	public void SetOwner(Worker w) {
		owner = w;
		//SetColor(w.color);
	}
	
	public boolean Accept(Box b) {
		if (things != null)
		{
			b.CollideWith(things);
			return Accept(b);
		}
		
		Worker pusher = b.Notify();	
		
		if (pusher == owner)
		{
			pusher.AddPoints(1);
		}
		else if (owner == null)
		{
			pusher.AddPoints(1);
			SetOwner(pusher);
		}
		
		b.onBoxField = true;
		
		return true;
	}
	
	public boolean Accept(Worker w) {
		return super.Accept(w);
	}
	
	@Override
	public void Remove()
	{
		// ???
		/**
		 * ha a box elhagyja a boxfieldet, amit nem tudunk mert csak Thing-kent tudjuk mi van rajtunk, akkor pls mit tegyek
		 */
	}
}
