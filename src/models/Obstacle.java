package models;

import java.io.PrintWriter;

import views.FieldView;

/**
 * Falat vagy oszlopot reprezent�l� oszt�ly
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
	 * "Fogadja", a r� �rkez� dobozt, nem engedi a mez�re
	 * @param b az �rkez� doboz
	 */
	public boolean Accept(Box b) {
		return false;
	}
	
	/**
	 * "Fogadja", a r� �rkez� munk�st, nem engedi a mez�re
	 * @param w az �rkez� munk�s
	 */
	public boolean Accept(Worker w) {
		return false;
	}
	
	/**
	 * Ki�rja az akad�ly �llapot�t
	 */
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout)
			System.out.println("name:"+ name + "\n");
		else
			w.println("name:"+ name + "\r\n");
	}
}
