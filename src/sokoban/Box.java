package sokoban;

public class Box extends Thing {
	private Worker owner;
	private Worker pusher;
	public void CollideWith(Thing t) {
	}
	
	public void HitBy(Box b, Direction dir) {
	}
	
	public void HitBy(Worker w, Direction dir) {
	}
	
	public void Delete() {
	}
}
