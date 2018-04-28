package models;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Csap�ajt�t reprezent�l� oszt�ly
 */
public class SwitchableHole extends Hole {
	
	/**
	 * nyitva van-e a csap�ajt�
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
	 * kiny�lik, �s ha van rajta valami, akkor ledobja
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
	 * fogadja a r� �rkez� dobozt, ha nyitva van, akkor ledobja
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
	 * fogadja a r� �rkez� munk�st, ha nyitva van, akkor ledobja
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
	 * Ki�rja az �llapot�t
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
