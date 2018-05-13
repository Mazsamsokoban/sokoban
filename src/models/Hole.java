package models;

import java.io.PrintWriter;

import views.FieldView;

/**
 * A lyukakat reprezentáló osztály
 */
public class Hole extends FieldBase {
	
	public Hole(String n) {
		name = n;
	}
	
	public Hole() {
		
	}
	public Hole(FieldView _view) {
		super(_view);
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

	@Override
	public void update() {
		;
	}
}
