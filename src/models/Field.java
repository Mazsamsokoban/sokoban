package models;

import java.io.PrintWriter;
/**
 * Az egyszer� mez�ket reprezent�l� oszt�ly
 */
public class Field extends FieldBase  {
	public Field(String n) {
		name = n;
	}
	
	public Field() {
	}
	
	/**
	 * Fogadja a r� �rkez� boxot(�tk�ztet)
	 */
	public boolean Accept(Box b) {
		if (thing != null)
		{
			b.CollideWith(thing);
			if(thing == null) 		//ha eltol�dott, akkor j�het
				return true;
			else 
				return false;
		}
		return true;
	}
	
	/**
	 * Fogadja a r� �rkez� munk�st(�tk�ztet)
	 */
	public boolean Accept(Worker w) {
		if (thing != null)
		{
			w.CollideWith(thing);
			if(thing == null)
				return true;
			else 
				return false;
		}
		return true;
	}
	
	/**
	 * Leveszi a r�la t�voz� dolgot
	 */
	public void Remove()
	{
		super.thing = null;
	}
	
	/**
	 * Ki�rja a mez� �llapot�t
	 */
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout)
			System.out.println("name:"+ name + "\n"
					+ "friction:" + getFriction() + "\n"
					+ "thing:" + thing + "\n"
					);
		else
			w.println("name:"+ name + "\r\n"
					+ "friction:" + getFriction() + "\r\n"
					+ "thing:" + thing + "\r\n"
					);
	}
}
