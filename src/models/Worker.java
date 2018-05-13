package models;

import java.awt.Component;
import java.io.PrintWriter;

import views.ViewBase;
import views.WorkerView;

/**
 * A takt�r�p�letben dolgoz� munk�sok
 */
public class Worker extends Thing  {
	private WorkerView view;
	/**
	 * A munk�s pontjai
	 */
	private int points;
	private static int number = 1;
	private int id;
	
	
	public Worker(String n, float pf) {
		name = n;
		points = 0;
		pushForce = pf;
	}
	
	public Worker() {
		points = 0;
		pushForce = 10;
	}
	public Worker(WorkerView _view) {
		view = _view;
		points = 0;
		pushForce = 10;
		id = number++;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPoints() {
		return points;
	}
	
	/**
	 * a munk�s a megadott ir�nyban l�v� mez�re mozog
	 * @param dir a mozg�s ir�nya
	 * @return siker�lt-e a mozg�s
	 */
	public boolean Move(Direction dir) {
		FieldBase old = getField();
		if(old == null)
			return false;
		FieldBase f1 = old.getNeighbor(dir);
		if(f1 == null)
			return false;
		setDirection(dir);
		
		if (f1.Accept(this) && this.getField() != null)
		{
			old.Remove();
			f1.setThing(this);
			this.setField(f1);
		}
		return true;
	}
	
	/**
	 * a munk�s p pontot kap
	 * @param p h�ny pontot
	 */
	public void AddPoints(long p) {
		points += p;
	}
	
	/**
	 * a munk�s �tk�zik a t dologgal
	 */
	public void CollideWith(Thing t) {
		t.HitBy(this, getDirection(), this.getPushForce());
	}
	
	/**
	 * a munk�snak dir ir�nyban nekimegy egy m�sik munk�s
	 */
	public void HitBy(Worker w, Direction dir, float force) {
			
	}
	/**
	 * a munk�snak dir ir�nyban nekimegy egy doboz
	 */
	public void HitBy(Box b, Direction dir, float force) {
		float tempPushForce = this.getPushForce(); //am�g tolj�k, addig m�s a pushForce
		this.setPushForce(force);  //ezzel az er�vel tol tov�bb
		setDirection(dir);
		FieldBase f = getField().getNeighbor(dir);
		FieldBase old = getField();
		boolean isAccepted = f.Accept(this);
		if (!isAccepted && f.getThing() == null) {		//Obstaclenek toltuk, ez�rt a munk�s meghal
			this.Delete();
		}
		else if(isAccepted && this.getField() != null) {
			old.Remove();
			f.setThing(this);
			this.setField(f);
		}		
		this.setPushForce(tempPushForce);  //tol�s ut�n vissza�ll�tjuk
	}
	
	/**
	 * A munk�s lerak valamit
	 */
	public void put(Friction f) {
		this.getField().setFriction(f);
	}
	
	/**
	 * a munk�s t�rl�dik a mez�j�r�l
	 */
	public void Delete() {
		getField().Remove();
		setField(null);
		view.disappear();
	}
	
	
	@Override
	Worker Notify() {
		return this;
	}
	
	/**
	 * Ki�rja az �llapot�t
	 */
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout) {
			System.out.println("name:"+ name + "\n"
					+  "field:" + getField() + "\n"
					+ "direction:" + getDirection() + "\n"
					+ "points:" + points + "\n"
					+ "pushforce:" + pushForce + "\n"
					);
		}
		else
			w.println("name:"+ name + "\r\n"
					+  "field:" + getField() + "\r\n"
					+ "direction:" + getDirection() + "\r\n"
					+ "points:" + points + "\r\n"
					+ "pushforce:" + pushForce + "\r\n"
					);
	}

	@Override
	public void update(ViewBase fieldView) {
		view.updatePosition(fieldView);
	}

	public WorkerView getView() {
		return view;
	}
}
