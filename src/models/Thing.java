package models;

import java.io.PrintWriter;

/**
 * A mez�k�n l�v� dolgok �se
 */
public abstract class Thing{
	/**
	 * A mozg�s ir�nya
	 */
	private Direction d;
	/**
	 * A t�rol�mez�
	 */
	private FieldBase field;
	/**
	 * tol�er�
	 */
	protected float pushForce;
	
	
	protected String name = "";
	
	public Thing() {
		d = Direction.Neutral;
	}
	//absztrakt �tk�ztet� �s t�rl� fgv-ek
	public abstract void CollideWith(Thing t);
	
	public abstract void HitBy(Box b, Direction dir, float force);
	
	public abstract void HitBy(Worker w, Direction dir, float force);
	
	public abstract void Delete();
	
	abstract Worker Notify();
	
	public abstract void printState(PrintWriter w, boolean stdout);
	
	
	/**
	 * @return menetir�ny visszaad�sa
	 */
	public Direction getDirection()
	{
		return d;
	}
	
	/**
	 * Menetir�ny be�ll�t�sa
	 */
	public void setDirection(Direction d) {
		this.d = d;
	}
	
	/**
	 * T�rol�mez� be�ll�t�sa
	 */
	public void setField(FieldBase f) {
		field = f;
	}
	
	/**
	 * @return a t�rol�mez�
	 */
	public FieldBase getField(){
		return field;
	}
	
	/**
	 * Tol�er� be�ll�t�sa
	 */
	public void setPushForce(float pf) {
		pushForce = pf;
	}
	
	/**
	 * @return a tol�er�
	 */
	public float getPushForce(){
		return pushForce;
	}
	@Override
	public String toString() {
		return name;
	}
}
