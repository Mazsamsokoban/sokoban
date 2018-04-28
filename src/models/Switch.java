package models;

import java.io.PrintWriter;

/**
 * A kapcsol�kat reprezent�l� oszt�ly
 */
public class Switch extends FieldBase{
	/**
	 * Be van-e kapcsolva a kapcsol�
	 */
	private boolean on;
	
	/**
	 * A kapcsol�hoz tatoz� csap�ajt�
	 */
	private SwitchableHole swhole;
	
	/**
	 * A kapcsol�n l�v� doboz
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
	 * Fogadja a r� �rkez� dobozt, �s �llapotot v�lt
	 * @param b az �rkez� doboz
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
	 * Fogadja a r� �rkez� munk�st
	 * @param w az �rkez� munk�s
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
	 * Leveszi a mez�n l�v� dolgot
	 */
	public void Remove()
	{	
		if(box != null) {		//ha l�da, akkor �tkapcsol
			box = null;
			Change();
		}
		thing = null;
	}
	
	/**
	 * Be�ll�tja a hozz� tartoz� csap�ajt�t
	 * @param sh a csap�ajt�
	 */
	public void SetSh(SwitchableHole sh) {
		swhole = sh;
	}
	
	/**
	 * V�lt, �s v�ltja a hozz� tartoz� csap�ajt�t is
	 */
	public void Change() {
		swhole.setOpen();
		on = !on;
	}
	
	/**
	 * @return a rajta l�v� l�da
	 */
	public Box getBox() {
		return box;
	}
	
	/**
	 * Be�ll�tja a rajta l�v� l�d�t
	 */
	public void setBox(Box b) {
		box = b;
	}
	
	/**
	 * Ki�rja a kapcsol� �llapot�t
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
