package models;

import java.io.PrintWriter;

/**
 * A kapcsolókat reprezentáló osztály
 */
public class Switch extends FieldBase{
	/**
	 * Be van-e kapcsolva a kapcsoló
	 */
	private boolean on;
	
	/**
	 * A kapcsolóhoz tatozó csapóajtó
	 */
	private SwitchableHole swhole;
	
	/**
	 * A kapcsolón lévõ doboz
	 */
	private Box box;
	
	
	public Switch(String n) {
		name = n;
	}
	
	public Switch() {
	}
	
	/**
	 * @return be van-e kapcsolva
	 */
	public boolean isOn() {
		return on;
	}
	/**
	 * Fogadja a rá érkezõ dobozt, és állapotot vált
	 * @param b az érkezõ doboz
	 */
	public boolean Accept(Box b) {
		if (thing != null)
		{
			b.CollideWith(thing);
			if(thing == null) {
				Change();
				box = b;
				return true;
			}
			else 
				return false;
		}
		box = b;
		Change();
		return true;
	}
	
	/**
	 * Fogadja a rá érkezõ munkást
	 * @param w az érkezõ munkás
	 */
	public boolean Accept(Worker w) {
		if (thing != null)
		{
			w.CollideWith(thing);
			if(thing == null)
				return true;
			else 
				return false;
			//return Accept(w);
		}
		return true;
	}
	
	/**
	 * Leveszi a mezõn lévõ dolgot
	 */
	public void Remove()
	{	
		if(box != null) {		//ha láda, akkor átkapcsol
			box = null;
			Change();
		}
		thing = null;
	}
	
	/**
	 * Beállítja a hozzá tartozó csapóajtót
	 * @param sh a csapóajtó
	 */
	public void SetSh(SwitchableHole sh) {
		swhole = sh;
	}
	
	/**
	 * Vált, és váltja a hozzá tartozó csapóajtót is
	 */
	public void Change() {
		swhole.setOpen();
		on = !on;
	}
	
	/**
	 * @return a rajta lévõ láda
	 */
	public Box getBox() {
		return box;
	}
	
	/**
	 * Beállítja a rajta lévõ ládát
	 */
	public void setBox(Box b) {
		box = b;
	}
	
	/**
	 * Kiírja a kapcsoló állapotát
	 */
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout)
			System.out.println("name:"+ name + "\n"
					+ "friction:" + getFriction() + "\n"
					+ "thing:" + thing + "\n"
					+ "on:" + on + "\n"
					+ "switchablehole:" + swhole + "\n"
					+ "box:" + box + "\n"
					);
		else
			w.println("name:"+ name + "\r\n"
					+ "friction:" + getFriction() + "\r\n"
					+ "thing:" + thing + "\r\n"
					+ "on:" + on + "\r\n"
					+ "switchablehole:" + swhole + "\r\n"
					+ "box:" + box + "\r\n"
					);
	}
}
