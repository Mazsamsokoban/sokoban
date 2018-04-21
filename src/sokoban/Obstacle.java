package sokoban;

import java.io.PrintStream;
import java.io.PrintWriter;

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
	
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout)
			System.out.println("name:"+ name + "\n");
		else
			w.println("name:"+ name + "\r\n");
	}
}
