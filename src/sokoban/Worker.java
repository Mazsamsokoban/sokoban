package sokoban;

import java.io.PrintStream;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "name", "d", "field", "points" })
@XmlRootElement
public class Worker extends Thing implements Steppable {
	
	
	@XmlAttribute
	private int points;
	
	
	public Worker(String n, float pf) {
		name = n;
		points = 0;
		pushForce = pf;
	}
	
	public Worker() {
		points = 0;
		pushForce = 10;
	}
	
	//a munkás a megadott irányban lévõ mezõre mozog
	public boolean Move(Direction dir) {
		FieldBase f1 = getField().getNeighbor(dir);
		setDirection(dir);
		FieldBase old = getField();
		if (f1.Accept(this))
		{
			old.Remove();
			f1.setThing(this);
			this.setField(f1);
		}
		return false;
	}
	
	//a munkás p pontot kap
	
	public void AddPoints(long p) {
		points += p;
	}
	
	//a munkás ütközik a t dologgal
	public void CollideWith(Thing t) {
		t.HitBy(this, getDirection());
	}
	
	//a munkásnak dir irányban nekimegy egy másik munkás
	public void HitBy(Worker w, Direction dir) {
			
	}
	//a munkásnak dir irányban nekimegy egy doboz
	public void HitBy(Box b, Direction dir) {
		if (getField().getNeighbor(dir).Accept(this))
		{
			getField().Remove();
		}	
	}
	
	//a munkás törlõdik a mezõjérõl
	public void Delete() {
		getField().setThing(null);
		setField(null);
	}
	
	// a munkás lép
	public void Step() {
		// getteljuk az inputot, de ez meg nem kell (AFAIK)
	}

	
	@Override
	Worker Notify() {
		return this;
	}
	
	public void printState(PrintStream w) {
		w.println("name:"+ name + "\n"
				+  "field:" + getField() + "\n"
				+ "direction:" + getDirection() + "\n"
				+ "points:" + points + "\n"
				+ "pushforce:" + pushForce + "\n"
				);
	}
}
