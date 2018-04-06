package sokoban;

import java.io.PrintStream;

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
	
	public void printState(PrintStream w) {
		w.println("name:"+ name + "\n");
	}
}
