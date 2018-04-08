package sokoban;

import java.io.PrintStream;
import java.io.Serializable;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;


@XmlTransient
@XmlSeeAlso({Field.class, SwitchableHole.class, Switch.class})
public abstract class Thing{
	@XmlAttribute(name = "direction")
	private Direction d;
	private FieldBase field;
	protected float pushForce;
	
	@XmlAttribute(name = "name")
	protected String name = "";
	
	public Thing() {
		d = Direction.Neutral;
	}
	//absztrakt ütköztetõ és törlõ fgv-ek
	public abstract void CollideWith(Thing t);
	
	public abstract void HitBy(Box b, Direction dir, float force);
	
	public abstract void HitBy(Worker w, Direction dir, float force);
	
	public abstract void Delete();
	
	abstract Worker Notify();
	
	public abstract void printState(PrintStream w);
	
	
	//menetirány visszaadása
	public Direction getDirection()
	{
		return d;
	}
	
	public void setDirection(Direction d) {
		this.d = d;
	}
	
	
	public void setField(FieldBase f) {
		field = f;
	}
	
	@XmlElement
	public FieldBase getField(){
		return field;
	}
	
	public void setPushForce(float pf) {
		pushForce = pf;
	}
	
	public float getPushForce(){
		return pushForce;
	}
	@Override
	public String toString() {
		return name;
	}
}
