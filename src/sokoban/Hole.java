package sokoban;

import java.io.PrintStream;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hole extends FieldBase {
	
	public Hole(String n) {
		name = n;
	}
	
	public Hole() {
		
	}
	
	//fogadja a r� �rkez� dobozt, azaz ledobja
	public boolean Accept(Box b) {
		b.Delete();
		return false;
	}
	
	//fogadja a r� �rkez� munk�st, azaz ledobja
	public boolean Accept(Worker w) {
		w.Delete();
		return false;
	}
	
	public void printState(PrintStream w) {
		w.println("name:"+ name + "\n");
	}
}
