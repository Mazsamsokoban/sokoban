package sokoban;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "d", "field", "onBoxField" })
@XmlRootElement
public class Box extends Thing implements Serializable{
	Worker owner;
	Worker pusher;
	@XmlAttribute
	public boolean onBoxField = false;
	
	public Box(String n) {
		name = n;
	}
	
	//Box kontruktor
	public Box() {
	}
	
	//ütköztetõ fgv
	public void CollideWith(Thing t) {
		t.HitBy(this, super.getDirection());
	}
	
	//nekimegy a dir irányban egy box
	public void HitBy(Box b, Direction dir) {
		super.d = dir;
		FieldBase f = getField().getNeighbor(dir);
		FieldBase old = getField();
		if (f.Accept(this))
		{
			old.Remove();
			f.setThing(this);
			this.setField(f);
		}		
	}
	
	//nekimegy a dir irányban egy box
	public void HitBy(Worker w, Direction dir) {
		super.d = dir;
		this.pusher = w;
		FieldBase f = getField().getNeighbor(dir);
		FieldBase old = getField();
		if (f.Accept(this))
		{
			old.Remove();
			f.setThing(this);
			this.setField(f);
		}		
	}
	
	//törli magát a mezõjérõl
	public void Delete() {
		field.setThing(null);
		field = null;
	}
	
	//jelzi, hogy beérkezett
	@Override
	Worker Notify() {
		return pusher.Notify();
	}
	
	public void printState(PrintStream w) {
		w.println("name:"+ name + "\n"
				+  "field:" + getField() + "\n"
				+  "field:" + getField().getFriction() + "\n"
				+ "direction:" + getDirection() + "\n"
				+ "owner:" + owner + "\n"
				+ "pusher:" + pusher + "\n"
				+ "pushforce:" + pushForce + "\n"
				);
	}
}
