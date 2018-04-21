package sokoban;

import java.io.PrintStream;
import java.io.PrintWriter;

//falat vagy oszlopot reprezentál
public class Obstacle extends FieldBase {
	
	public Obstacle(String n) {
		name = n;
	}
	public Obstacle() {
	}
	
	//"fogadja", a rá érkezõ dobozt, nem engedi a mezõre
	public boolean Accept(Box b) {
		return false;
	}
	
	//"fogadja", a rá érkezõ munkást, nem engedi a mezõre
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
