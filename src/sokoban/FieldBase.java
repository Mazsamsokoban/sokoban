package sokoban;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

// mez�k �soszt�lya
@XmlTransient
@XmlSeeAlso({Box.class, Worker.class})
public abstract class FieldBase{
	@XmlAttribute(name = "name")
	protected String name = "";
	
	@XmlElement
	protected Thing thing;
	@XmlElement
	private Friction friction;
	
	
	private HashMap<Direction, FieldBase> neighbours;
	
	public abstract void printState(PrintStream w);
	
	public FieldBase() {
		neighbours = new HashMap<Direction, FieldBase>();
		friction = Friction.Normal;
	}
	
	public void setThing(Thing t) {
		thing = t;
	}
	
	public Thing getThing() {
		return thing;
	}
	
	public void setFriction(Friction f) {
		friction = f;
	}
	
	public Friction getFriction() {
		return friction;
	}
	//absztrakt fogad� f�ggv�nyek
	public abstract boolean Accept(Box b);
	
	public abstract boolean Accept(Worker w);
	
	public void Remove() {
		thing = null;
	}
	//be�ll�tja k�lcs�n�sen a param�terrel a szomsz�ds�got
	public void setNeighbor(Direction d, FieldBase f) {
		neighbours.put(d, f);
        Direction n = null;
        switch (d)
        {
        case Up: n = Direction.Down; break;
        case Down: n = Direction.Up; break;
        case Right: n = Direction.Left; break;
        case Left: n = Direction.Right; break;
        default: return;
        }
        if (f.getNeighbor(n) == null)
            f.setNeighbor(n, this);
    }
	
	//visszaadja a megadott ir�nyban l�v� szomsz�d mez�t
	public FieldBase getNeighbor(Direction d) {
		return neighbours.get(d);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
