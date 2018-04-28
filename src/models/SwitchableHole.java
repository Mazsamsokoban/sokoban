package models;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Csapóajtót reprezentáló osztály
 */
public class SwitchableHole extends Hole {
	
	/**
	 * nyitva van-e a csapóajtó
	 */
	private boolean open;
	
	public SwitchableHole(String n) {
		name = n;
		open = false;
	}
	public SwitchableHole() {
		open = false;
	}
	
	/**
	 * kinyílik, és ha van rajta valami, akkor ledobja
	 */
	public void setOpen() {

		open = !open;
		
		if (open)
		{
			if(thing != null) 
				thing.Delete();
		}
	}
	
	/**
	 * 
	 * @return nyitva van-e
	 */
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * fogadja a rá érkezõ dobozt, ha nyitva van, akkor ledobja
	 */
	public boolean Accept(Box b) {
		if (open) {
			return super.Accept(b);
		}
		else
		{					
			if (thing != null)
			{
				b.CollideWith(thing);
				return Accept(b);
			}
			return true;
		}			
	}
	
	/**
	 * fogadja a rá érkezõ munkást, ha nyitva van, akkor ledobja
	 */
	public boolean Accept(Worker w) {
		if (open) {
			return super.Accept(w);
		}
		else
		{
			if (thing != null)
			{
				w.CollideWith(thing);
				return Accept(w);
			}
			return true;
		}		
		
	}
	
	/**
	 * Kiírja az állapotát
	 */
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout)
			System.out.println("name:"+ name + "\n"
					+ "friction:" + getFriction() + "\n"
					+ "thing:" + thing + "\n"
					+ "open:" + open + "\n"
					);
		else
			w.println("name:"+ name + "\r\n"
					+ "friction:" + getFriction() + "\r\n"
					+ "thing:" + thing + "\r\n"
					+ "open:" + open + "\r\n"
					);
	}
}
