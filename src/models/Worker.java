package models;

import java.awt.Component;
import java.io.PrintWriter;

import views.WorkerView;

/**
 * A taktárépületben dolgozó munkások
 */
public class Worker extends Thing implements Steppable {
	private WorkerView view;
	/**
	 * A munkás pontjai
	 */
	private int points;
	
	
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
	}
	
	/**
	 * a munkás a megadott irányban lévõ mezõre mozog
	 * @param dir a mozgás iránya
	 * @return sikerült-e a mozgás
	 */
	public boolean Move(Direction dir) {
		FieldBase f1 = getField().getNeighbor(dir);
		setDirection(dir);
		FieldBase old = getField();
		if (f1.Accept(this))
		{
			old.Remove();
			f1.setThing(this);
			this.setField(f1);
		}
		return false;
	}
	
	/**
	 * a munkás p pontot kap
	 * @param p hány pontot
	 */
	public void AddPoints(long p) {
		points += p;
	}
	
	/**
	 * a munkás ütközik a t dologgal
	 */
	public void CollideWith(Thing t) {
		t.HitBy(this, getDirection(), this.getPushForce());
	}
	
	/**
	 * a munkásnak dir irányban nekimegy egy másik munkás
	 */
	public void HitBy(Worker w, Direction dir, float force) {
			
	}
	/**
	 * a munkásnak dir irányban nekimegy egy doboz
	 */
	public void HitBy(Box b, Direction dir, float force) {
		float tempPushForce = this.getPushForce(); //amíg tolják, addig más a pushForce
		this.setPushForce(force);  //ezzel az erõvel tol tovább
		setDirection(dir);
		FieldBase f = getField().getNeighbor(dir);
		FieldBase old = getField();
		boolean isAccepted = f.Accept(this);
		if (!isAccepted && f.getThing() == null) {		//Obstaclenek toltuk, ezért a munkás meghal
			this.Delete();
		}
		else if(isAccepted) {
			old.Remove();
			f.setThing(this);
			this.setField(f);
		}		
		this.setPushForce(tempPushForce);  //tolás után visszaállítjuk
	}
	
	/**
	 * A munkás lerak valamit
	 */
	public void put(Friction f) {
		this.getField().setFriction(f);
	}
	
	/**
	 * a munkás törlõdik a mezõjérõl
	 */
	public void Delete() {
		getField().setThing(null);
		setField(null);
		view.disappear();
	}
	
	/**
	 * a munkás lép
	 */
	public void Step() {
	
	}

	
	@Override
	Worker Notify() {
		return this;
	}
	
	/**
	 * Kiírja az állapotát
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
	public void update(int x, int y) {
		view.updatePosition(x, y);
	}

	public WorkerView getView() {
		return view;
	}
}
