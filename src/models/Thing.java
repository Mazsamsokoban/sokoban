package models;

import java.io.PrintWriter;

/**
 * A mezõkön lévõ dolgok õse
 */
public abstract class Thing{
	/**
	 * A mozgás iránya
	 */
	private Direction d;
	/**
	 * A tárolómezõ
	 */
	private FieldBase field;
	/**
	 * tolóerõ
	 */
	protected float pushForce;
	
	
	protected String name = "";
	
	public Thing() {
		d = Direction.Neutral;
	}
	//absztrakt ütköztetõ és törlõ fgv-ek
	public abstract void CollideWith(Thing t);
	
	public abstract void HitBy(Box b, Direction dir, float force);
	
	public abstract void HitBy(Worker w, Direction dir, float force);
	
	public abstract void Delete();
	
	abstract Worker Notify();
	
	public abstract void printState(PrintWriter w, boolean stdout);
	
	
	/**
	 * @return menetirány visszaadása
	 */
	public Direction getDirection()
	{
		return d;
	}
	
	/**
	 * Menetirány beállítása
	 */
	public void setDirection(Direction d) {
		this.d = d;
	}
	
	/**
	 * Tárolómezõ beállítása
	 */
	public void setField(FieldBase f) {
		field = f;
	}
	
	/**
	 * @return a tárolómezõ
	 */
	public FieldBase getField(){
		return field;
	}
	
	/**
	 * Tolóerõ beállítása
	 */
	public void setPushForce(float pf) {
		pushForce = pf;
	}
	
	/**
	 * @return a tolóerõ
	 */
	public float getPushForce(){
		return pushForce;
	}
	@Override
	public String toString() {
		return name;
	}
}
