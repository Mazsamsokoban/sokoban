package models;

import java.io.PrintWriter;
import java.io.Serializable;

import views.BoxView;
import views.ViewBase;

/**
 * A l�d�kat reprezent�l� oszt�ly
 */
public class Box extends Thing implements Serializable{
	private BoxView view;
	
	/**
	 * A l�d�t el�sz�r betol� munk�s
	 */
	private Worker owner;
	/**
	 * A l�d�t �ppen tol� munk�s
	 */
	private Worker pusher;
	/**
	 * A l�da �pp be van-e tolva
	 */
	private boolean onBoxField = false;
	
	public Box(String n) {
		name = n;
	}
	
	//Box kontruktor
	public Box() {
	}
	
	public Box(BoxView _view) {
		view = _view;
	}
	
	/**
	 * A l�da el�rte/elhagyta a kijel�lt helyet
	 */
	public void setOnBoxField() {
		onBoxField = !onBoxField;
	}
	
	/**
	 * A l�da kijel�lt helyen van-e
	 * @return a hely�n van-e
	 */
	public boolean isOnBoxField() {
		return onBoxField;
	}
	
	
	/**
	 * A t dolog neki�tk�zik a l�d�nak
	 * @param t ami a l�d�nak �tk�zik
	 */
	public void CollideWith(Thing t) {
		t.HitBy(this, super.getDirection(), this.getPushForce());
	}
	
	/**
	 * A l�d�nak nekimegy a dir ir�nyban egy l�da
	 * @param b a l�da, ami nekimegy
	 * @param dir melyik ir�nyban
	 * @param force milyen er�vel
	 */
	public void HitBy(Box b, Direction dir, float force) {
		Friction friction = this.getField().getFriction();
		this.setPushForce(force - friction.getValue());
		if(force - friction.getValue() <= 0) return;	//nem tudja eltolni
		
		setDirection(dir);
		this.pusher = b.getPusher();
		FieldBase old = getField();
		FieldBase f = old.getNeighbor(dir);
		
		if (f.Accept(this) && this.getField() != null)
		{
			old.Remove();
			f.setThing(this);
			this.setField(f);
		}		
		
	}
	
	/**
	 * A l�d�nak nekimegy a dir ir�nyban egy munk�s
	 * @param w a munk�s, ami nekimegy
	 * @param dir melyik ir�nyban
	 * @param force milyen er�vel
	 */
	public void HitBy(Worker w, Direction dir, float force) {
		Friction friction = this.getField().getFriction();
		this.setPushForce(force - friction.getValue());
		if(force - friction.getValue() <= 0) return;		//nem tudja eltolni
		
		setDirection(dir);
		this.pusher = w;
		FieldBase old = getField();
		FieldBase f = old.getNeighbor(dir);
		
		if (f.Accept(this) && this.getField() != null)								//ha elfogadta, akkor leveszi mag�t
		{
			old.Remove();
			f.setThing(this);
			this.setField(f);
		}		
	}
	
	/**
	 * T�rl�dik a mez�j�r�l
	 */
	public void Delete() {
		getField().Remove();
		setField(null);
		if(onBoxField)
			onBoxField = false;
		view.disappear();
	}
	
	/**
	 * Jelzi, hogy be�rkezett
	 */
	@Override
	Worker Notify() {
		return pusher.Notify();
	}
	
	/**
	 * Ki�rja a l�da �llapot�t a tesztel�shez.
	 */
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout) {
			System.out.println("name:"+ name + "\n"
					+  "field:" + getField() + "\n"
					+ "direction:" + getDirection() + "\n"
					+ "owner:" + owner + "\n"
					+ "pusher:" + pusher + "\n"
					//+ "pushforce:" + pushForce + "\n"
					);
		}
		else
			w.println("name:"+ name + "\r\n"
					+  "field:" + getField() + "\r\n"
					+ "direction:" + getDirection() + "\r\n"
					+ "owner:" + owner + "\r\n"
					+ "pusher:" + pusher + "\r\n"
					//+ "pushforce:" + pushForce + "\n"
					);
	}

	/**
	 * visszaadja a l�da tol�j�t
	 * @return aki tolja
	 */
	public Worker getPusher() {
		return pusher;
	}
	
	/**
	 * Be�ll�tja a tol�t
	 * @param p az aktu�lis tol�
	 */
	public void setPusher(Worker p) {
		pusher = p;
	}
	/**
	 * Visszaadja a tulajdonost, aki betolta
	 * @return a tulajdonos
	 */
	public Worker getOwner() {
		return owner;
	}
	
	/**
	 * Be�ll�tja a tulajdonost
	 * @param o a tulajdonos
	 */
	public void setOwner(Worker o) {
		owner = o;
	}

	@Override
	public void update(ViewBase fieldView) {
		view.updatePosition(fieldView);
		if(owner != null) view.setColor(owner.getId());
	}
	
	public BoxView getView() {
		return view;
	}
	
}
