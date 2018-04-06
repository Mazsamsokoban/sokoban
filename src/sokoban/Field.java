package sokoban;

import java.io.IOException;
import java.io.PrintStream;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "thing", "friction"})
@XmlRootElement
public class Field extends FieldBase  {
	boolean debug = false;
	public void ChangeDebug()
	{
		debug = !debug;
	}
	
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
			return Accept(b);
		}
		return true;
	}
	
	//fogadja a rá érkezõ boxot(ütköztet)
	public boolean Accept(Worker w) {
		if (thing != null)
		{
			w.CollideWith(thing);
			return Accept(w);
		}
		return true;
	}
	
	//leveszi a róla távozó dolgot
	public void Remove()
	{
		super.thing = null;
	}
	
	
	public void printState(PrintStream w) {
		w.println("name:"+ name + "\n"
				+ "friction:" + getFriction() + "\n"
				+ "thing:" + thing + "\n"
				);
	}
}
