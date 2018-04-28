package models;

import java.io.PrintWriter;
/**
 * Az egyszerû mezõket reprezentáló osztály
 */
public class Field extends FieldBase  {
	public Field(String n) {
		name = n;
	}
	
	public Field() {
	}
	
	/**
	 * Fogadja a rá érkezõ boxot(ütköztet)
	 */
	public boolean Accept(Box b) {
		if (thing != null)
		{
			b.CollideWith(thing);
			if(thing == null) 		//ha eltolódott, akkor jöhet
				return true;
			else 
				return false;
		}
		return true;
	}
	
	/**
	 * Fogadja a rá érkezõ munkást(ütköztet)
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
	 * Leveszi a róla távozó dolgot
	 */
	public void Remove()
	{
		super.thing = null;
	}
	
	/**
	 * Kiírja a mezõ állapotát
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
