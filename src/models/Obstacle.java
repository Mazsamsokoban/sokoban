package models;

import java.io.PrintWriter;

import views.FieldView;

/**
 * Falat vagy oszlopot reprezentáló osztály
 */
public class Obstacle extends FieldBase {
	
	public Obstacle(String n) {
		name = n;
	}
	public Obstacle() {
	}
	public Obstacle(FieldView _view) {
	}
	
	/**
	 * "Fogadja", a rá érkezõ dobozt, nem engedi a mezõre
	 * @param b az érkezõ doboz
	 */
	public boolean Accept(Box b) {
		return false;
	}
	
	/**
	 * "Fogadja", a rá érkezõ munkást, nem engedi a mezõre
	 * @param w az érkezõ munkás
	 */
	public boolean Accept(Worker w) {
		return false;
	}
	
	/**
	 * Kiírja az akadály állapotát
	 */
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout)
			System.out.println("name:"+ name + "\n");
		else
			w.println("name:"+ name + "\r\n");
	}
}
