package sokoban;


public class Worker extends Thing implements Steppable {
	private long points;
	public boolean Move(Direction d) {
		return false;
	}
	
	public void AddPoints(long p) {
		points += p;
	}
	
	public void CollideWith(Thing t) {
		t.HitBy(this, getDirection());
	}
	
	public void HitBy(Worker w, Direction dir) {
		// w, wyd?
	}
	
	public void HitBy(Box b, Direction dir) {
		if (getField().GetNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}	
	}
	
	public void Delete() {
		field = null;
	}
	
	public void Step() {
		// getteljuk az inputot, de ez meg nem kell (AFAIK)
	}

	@Override
	Worker Notify() {
		return this;
	}
}
