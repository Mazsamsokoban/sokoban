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
	private Worker owner;
	private Worker pusher;
	@XmlAttribute
	private boolean onBoxField = false;
	
	public Box(String n) {
		name = n;
	}
	
	//Box kontruktor
	public Box() {
	}
	
	public void setOnBoxField() {
		onBoxField = !onBoxField;
	}
	
	public boolean isOnBoxField() {
		return onBoxField;
	}
	
	
	//ütköztetõ fgv
	public void CollideWith(Thing t) {
		t.HitBy(this, super.getDirection(), this.getPushForce());
	}
	
	//nekimegy a dir irányban egy box
	public void HitBy(Box b, Direction dir, float force) {
		Friction friction = this.getField().getFriction();
		this.setPushForce(force - friction.getValue());
		if(force - friction.getValue() <= 0) return;	//nem tudja eltolni
		
		setDirection(dir);
		this.pusher = b.getPusher();
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
	public void HitBy(Worker w, Direction dir, float force) {
		Friction friction = this.getField().getFriction();
		this.setPushForce(force - friction.getValue());
		if(force - friction.getValue() <= 0) return;		//nem tudja eltolni
		
		setDirection(dir);
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
		getField().setThing(null);
		setField(null);
	}
	
	//jelzi, hogy beérkezett
	@Override
	Worker Notify() {
		return pusher.Notify();
	}
	
	public void printState(PrintStream w) {
		w.println("name:"+ name + "\n"
				+  "field:" + getField() + "\n"
				+ "direction:" + getDirection() + "\n"
				+ "owner:" + owner + "\n"
				+ "pusher:" + pusher + "\n"
				//+ "pushforce:" + pushForce + "\n"
				);
	}

	public Worker getPusher() {
		return pusher;
	}
	
	public void setPusher(Worker p) {
		pusher = p;
	}
	
	public Worker getOwner() {
		return owner;
	}
	
	public void setOwner(Worker o) {
		owner = o;
	}

	
}
