package models;

import java.io.PrintWriter;

import views.FieldView;

/**
 * A lyukakat reprezent�l� oszt�ly
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
	 * Fogadja a r� �rkez� dobozt, azaz ledobja
	 * @param b az �rkez� doboz
	 */
	public boolean Accept(Box b) {
		b.Delete();
		return false;
	}
	
	/**
	 * Fogadja a r� �rkez� munk�st, azaz ledobja
	 * @param b az �rkez� munk�s
	 */
	public boolean Accept(Worker w) {
		w.Delete();
		return false;
	}
	
	/**
	 * Ki�rja a lyuk �llapot�t
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
