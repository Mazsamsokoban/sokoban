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
	
	public Switch(String n) {
		name = n;
	}
	
	public Switch() {
	}
	
	public boolean isOn() {
		return on;
	}
	//fogadja a rá érkezõ dobozt, és állapotot vált
	public boolean Accept(Box b) {
		Change();
		/*if (super.Accept(b))
		{
			Change();
			return true;
		}*/
		return false;
	}
	
	//fogadja a rá érkezõ munkást
	public boolean Accept(Worker w) {
		//return super.Accept(w);
		return false;
	}
	
	//beállítja a hozzá tartozó csapóajtót
	public void SetSh(SwitchableHole sh) {
		swhole = sh;
	}
	
	//vált, és váltja a hozzá tartozó csapóajtót is
	public void Change() {
		swhole.setOpen();
		on = !on;
	}
	
	public void printState(PrintStream w) {
		w.println("name:"+ name + "\n"
				+ "friction:" + getFriction() + "\n"
				+ "thing:" + thing + "\n"
				+ "on:" + on + "\n"
				+ "switchablehole:" + swhole + "\n"
				);
	}
}
