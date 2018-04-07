package sokoban;

import java.io.PrintStream;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "thing", "friction", "on", "swhole" })
@XmlRootElement
public class Switch extends FieldBase{
	@XmlAttribute
	private boolean on;
	@XmlElement
	private SwitchableHole swhole;
	
	private Box box;
	
	
	public Switch(String n) {
		name = n;
	}
	
	public Switch() {
	}
	
	public boolean isOn() {
		return on;
	}
	//fogadja a r� �rkez� dobozt, �s �llapotot v�lt
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
			//return Accept(b);
		}
		box = b;
		Change();
		return true;
	}
	
	//fogadja a r� �rkez� munk�st
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
	
	public void Remove()
	{	
		if(box != null) {
			box = null;
			Change();
		}
		thing = null;
	}
	
	//be�ll�tja a hozz� tartoz� csap�ajt�t
	public void SetSh(SwitchableHole sh) {
		swhole = sh;
	}
	
	//v�lt, �s v�ltja a hozz� tartoz� csap�ajt�t is
	public void Change() {
		swhole.setOpen();
		on = !on;
	}
	
	public Box getBox() {
		return box;
	}
	
	public void setBox(Box b) {
		box = b;
	}
	public void printState(PrintStream w) {
		w.println("name:"+ name + "\n"
				+ "friction:" + getFriction() + "\n"
				+ "thing:" + thing + "\n"
				+ "on:" + on + "\n"
				+ "switchablehole:" + swhole + "\n"
				+ "box:" + box + "\n"
				);
	}
}
