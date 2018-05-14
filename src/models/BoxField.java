package models;

import java.io.PrintStream;
import java.io.PrintWriter;

import views.FieldView;

/**
 * Kijel�lt helyet reprezent�l� oszt�ly
 */
public class BoxField extends Field {
	/**
	 * A mez�re l�d�t tol� munk�s
	 */
	private Worker owner;
	/**
	 * A mez�n l�v� doboz
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
	 * Be�ll�tja a betol�t
	 * @param w a betol�
	 */
	public void setOwner(Worker w) {
		owner = w;
	}
	
	/**
	 * L�d�t fogad, �s pontot ad, illetve jelez a t�l�kon kereszt�l
	 * @param b az �rkez� l�da
	 */
	public boolean Accept(Box b) {
		if (thing != null)
		{
			b.CollideWith(thing);
			if (thing != null)		//nem tol�dott tov�bb az, amivel �tk�z�tt
				return false;
		}
		
		box = b;
		Worker pusher = b.Notify();	//jelz�s k�ld�se
		
		if (pusher == b.getOwner())		//az tolta be, aki kor�bban is
		{
			pusher.AddPoints(1);
		}
		else if (b.getOwner() == null)			//m�g nem tolta be senki
		{
			pusher.AddPoints(1);
			setOwner(pusher);
			b.setOwner(pusher);
		}
		
		b.setOnBoxField();
		return true;
	}
	
	/**
	 * Munk�st fogad, �s elhelyezi a mez�n, ha lehet
	 */
	public boolean Accept(Worker w) {
		return super.Accept(w);
	}
	
	/**
	 * leveszi a mez�n l�v� boxot, �s ha olyan tolta le, aki betolta, akkor pontot von le
	 */
	@Override
	public void Remove()
	{
		if(box != null) {
			Worker pusher = box.getPusher();
			Worker o = box.getOwner();
			if(pusher == o)					//pontlevon�s, mert a kor�bban betol� tolta le
				pusher.AddPoints(-1);
			box.setOnBoxField();
			box = null;
		}
		thing = null;
		
	}
	
	/**
	 * @return a mez�n l�v� l�da
	 */
	public Box getBox() {
		return box;
	}
	
	/**
	 * Be�ll�tja a mez�n l�v� l�d�t
	 * @param b a mez�n l�v� l�da
	 */
	public void setBox(Box b) {
		box = b;
	}
	
	/**
	 * Ki�rja a mez� �llapot�t
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
	 * friss�ti a rajta l�v� dolgot �s mag�t
	 */
	public void update() {
		getView().updateField(false, getFriction());
		if(thing!=null) 
			thing.update(getView());
	}
}
