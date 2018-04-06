package sokoban;

import java.io.PrintStream;

//falat vagy oszlopot reprezent�l
public class Obstacle extends FieldBase {
	
	public Obstacle(String n) {
		name = n;
	}
	public Obstacle() {
	}
	
	//"fogadja", a r� �rkez� dobozt, nem engedi a mez�re
	public boolean Accept(Box b) {
		return false;
	}
	
	//"fogadja", a r� �rkez� munk�st, nem engedi a mez�re
	public boolean Accept(Worker w) {
		return false;
	}
	
	public void printState(PrintStream w) {
		w.println("name:"+ name + "\n");
	}
}
