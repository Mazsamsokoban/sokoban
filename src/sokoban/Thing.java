package sokoban;

public abstract class Thing {
	private Direction d;
	public void CollideWith(Thing t) {
	}
	
	public void HitBy(Box b, Direction dir) {
	}
	
	public void HitBy(Worker w, Direction dir) {
	}
	
	public void Delete() {
	}
}
