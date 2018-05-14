package models;

import java.io.PrintStream;
import java.io.PrintWriter;

import views.FieldView;

/**
 * Kijelölt helyet reprezentáló osztály
 */
public class BoxField extends Field {
	/**
	 * A mezõre ládát toló munkás
	 */
	private Worker owner;
	/**
	 * A mezõn lévõ doboz
	 */
	private Box box;

	
	public BoxField() {
		
	}
	
	public BoxField(String n){
		name = n;
	}
	
	public BoxField(FieldView _view) {
		super(_view);
	}
	/**
	 * Beállítja a betolót
	 * @param w a betoló
	 */
	public void setOwner(Worker w) {
		owner = w;
	}
	
	/**
	 * Ládát fogad, és pontot ad, illetve jelez a tólókon keresztül
	 * @param b az érkezõ láda
	 */
	public boolean Accept(Box b) {
		if (thing != null)
		{
			b.CollideWith(thing);
			if (thing != null)		//nem tolódott tovább az, amivel ütközött
				return false;
		}
		
		box = b;
		Worker pusher = b.Notify();	//jelzés küldése
		
		if (pusher == b.getOwner())		//az tolta be, aki korábban is
		{
			pusher.AddPoints(1);
		}
		else if (b.getOwner() == null)			//még nem tolta be senki
		{
			pusher.AddPoints(1);
			setOwner(pusher);
			b.setOwner(pusher);
		}
		
		b.setOnBoxField();
		return true;
	}
	
	/**
	 * Munkást fogad, és elhelyezi a mezõn, ha lehet
	 */
	public boolean Accept(Worker w) {
		return super.Accept(w);
	}
	
	/**
	 * leveszi a mezõn lévõ boxot, és ha olyan tolta le, aki betolta, akkor pontot von le
	 */
	@Override
	public void Remove()
	{
		if(box != null) {
			Worker pusher = box.getPusher();
			Worker o = box.getOwner();
			if(pusher == o)					//pontlevonás, mert a korábban betoló tolta le
				pusher.AddPoints(-1);
			box.setOnBoxField();
			box = null;
		}
		thing = null;
		
	}
	
	/**
	 * @return a mezõn lévõ láda
	 */
	public Box getBox() {
		return box;
	}
	
	/**
	 * Beállítja a mezõn lévõ ládát
	 * @param b a mezõn lévõ láda
	 */
	public void setBox(Box b) {
		box = b;
	}
	
	/**
	 * Kiírja a mezõ állapotát
	 */
	public void printState(PrintWriter w, boolean stdout) {
		if(stdout)
			System.out.println("name:"+ name + "\n"
					+ "friction:" + getFriction() + "\n"
					+ "thing:" + thing + "\n"
					+ "box:" + box + "\n"
					);
		else
			w.println("name:"+ name + "\r\n"
					+ "friction:" + getFriction() + "\r\n"
					+ "thing:" + thing + "\r\n"
					+ "box:" + box + "\r\n"
					);
	}
	
	/**
	 * frissíti a rajta lévõ dolgot és magát
	 */
	public void update() {
		getView().updateField(false, getFriction());
		if(thing!=null) 
			thing.update(getView());
	}
}
