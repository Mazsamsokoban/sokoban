package sokoban;

public class Box extends Thing {
	private Worker owner;
	private Worker pusher;
	public boolean onBoxField = false;
	
	public void CollideWith(Thing t) {
		t.HitBy(this, super.getDirection());
	}
	
	public void HitBy(Box b, Direction dir) {
		if (getField().GetNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}		
	}
	
	public void HitBy(Worker w, Direction dir) {
		if (getField().GetNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}		
	}
	
	public void Delete() {
		field = null;
	}

	@Override
	Worker Notify() {
		return pusher.Notify();
	}
}
