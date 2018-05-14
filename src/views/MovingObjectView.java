package views;

public class MovingObjectView extends ViewBase {

	public MovingObjectView(int _x, int _y) {
		super(_x, _y);
	
	}
	
	/**
	 * friss�t
	 */
	public void updatePosition(ViewBase fieldView) {
		setPos(fieldView.getPos());
		repaint();
		revalidate();
	}
	
	public void disappear() {
		this.getParent().remove(this);
		repaint();
		revalidate();
	}
	
	
}
