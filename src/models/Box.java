package models;

import java.io.PrintWriter;
import java.io.Serializable;

/**
 * A ládákat reprezentáló osztály
 */
public class Box extends Thing implements Serializable{
	/**
	 * A ládát elõször betoló munkás
	 */
	private Worker owner;
	/**
	 * A ládát éppen toló munkás
	 */
	private Worker pusher;
	/**
	 * A láda épp be van-e tolva
	 */
	private boolean onBoxField = false;
	
	public Box(String n) {
		name = n;
	}
	
	//Box kontruktor
	public Box() {
	}
	
	/**
	 * A láda elérte/elhagyta a kijelölt helyet
	 */
	public void setOnBoxField() {
		onBoxField = !onBoxField;
	}
	
	/**
	 * A láda kijelölt helyen van-e
	 * @return a helyén van-e
	 */
	public boolean isOnBoxField() {
		return onBoxField;
	}
	
	
	/**
	 * A t dolog nekiütközik a ládának
	 * @param t ami a ládának ütközik
	 */
	public void CollideWith(Thing t) {
		t.HitBy(this, super.getDirection(), this.getPushForce());
	}
	
	/**
	 * A ládának nekimegy a dir irányban egy láda
	 * @param b a láda, ami nekimegy
	 * @param dir melyik irányban
	 * @param force milyen erõvel
	 */
	public void HitBy(Box b, Direction dir, float force) {
		Friction friction = this.getField().getFriction();
		this.setPushForce(force - friction.getValue());
		if(force - friction.getValue() <= 0) return;	//nem tudja eltolni
		
		setDirection(dir);
		this.pusher = b.getPusher();
		FieldBase f = getField().getNeighbor(dir);
		FieldBase old = getField();
		if (f.Accept(this))
		{
			old.Remove();
			f.setThing(this);
			this.setField(f);
		}		
		
	}
	
	/**
	 * A ládának nekimegy a dir irányban egy munkás
	 * @param w a munkás, ami nekimegy
	 * @param dir melyik irányban
	 * @param force milyen erõvel
	 */
	public void HitBy(Worker w, Direction dir, float force) {
		Friction friction = this.getField().getFriction();
		this.setPushForce(force - friction.getValue());
		if(force - friction.getValue() <= 0) return;		//nem tudja eltolni
		
		setDirection(dir);
		this.pusher = w;
		FieldBase f = getField().getNeighbor(dir);
		FieldBase old = getField();
		if (f.Accept(this))								//ha elfogadta, akkor leveszi magát
		{
			old.Remove();
			f.setThing(this);
			this.setField(f);
		}		
	}
	
	/**
	 * Törlõdik a mezõjérõl
	 */
	public void Delete() {
		getField().setThing(null);
		setField(null);
	}
	
	/**
	 * Jelzi, hogy beérkezett
	 */
	@Override
	Worker Notify() {
		return pusher.Notify();
	}
	
	/**
	 * Kiírja a láda állapotát a teszteléshez.
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
	 * visszaadja a láda tolóját
	 * @return aki tolja
	 */
	public Worker getPusher() {
		return pusher;
	}
	
	/**
	 * Beállítja a tolót
	 * @param p az aktuális toló
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
	 * Beállítja a tulajdonost
	 * @param o a tulajdonos
	 */
	public void setOwner(Worker o) {
		owner = o;
	}

	
}
