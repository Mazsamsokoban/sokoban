package models;

import java.io.PrintWriter;

/**
 * A lyukakat reprezentáló osztály
 */
public class Hole extends FieldBase {
	
	public Hole(String n) {
		name = n;
	}
	
	public Hole() {
		
	}
	
	/**
	 * Fogadja a rá érkezõ dobozt, azaz ledobja
	 * @param b az érkezõ doboz
	 */
	public boolean Accept(Box b) {
		b.Delete();
		return false;
	}
	
	/**
	 * Fogadja a rá érkezõ munkást, azaz ledobja
	 * @param b az érkezõ munkás
	 */
	public boolean Accept(Worker w) {
		w.Delete();
		return false;
	}
	
	/**
	 * Kiírja a lyuk állapotát
	 */
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout)
			System.out.println("name:"+ name + "\n");
		else
			w.println("name:"+ name + "\r\n");
	}
}
