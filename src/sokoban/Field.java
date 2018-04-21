package sokoban;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "thing", "friction"})
@XmlRootElement
public class Field extends FieldBase  {
	public Field(String n) {
		name = n;
	}
	
	public Field() {
	}
	
	//fogadja a rá érkezõ boxot(ütköztet)
	public boolean Accept(Box b) {
		if (thing != null)
		{
			b.CollideWith(thing);
			if(thing == null) 
				return true;
			else 
				return false;
			//return Accept(b);
		}
		return true;
	}
	
	//fogadja a rá érkezõ boxot(ütköztet)
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
	
	//leveszi a róla távozó dolgot
	public void Remove()
	{
		super.thing = null;
	}
	
	
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
