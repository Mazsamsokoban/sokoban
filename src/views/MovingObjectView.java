package views;

public class MovingObjectView extends ViewBase {

	public MovingObjectView(int _x, int _y) {
		super(_x, _y);
	
	}
	
	public void updatePosition(int _x, int _y) {
		x = _x;
		y = _y;
		repaint();
		revalidate();
	}
	
	public void disappear() {
		this.getParent().remove(this);
	}

}
