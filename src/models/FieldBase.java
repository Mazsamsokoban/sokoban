package models;
import java.io.PrintWriter;
import java.util.HashMap;

import views.FieldView;

/**
 * Mez�k �soszt�lya
 */
public abstract class FieldBase{
	private FieldView view;
	protected String name = "";
	
	/**
	 * A mez�n l�v� dolog
	 */
	protected Thing thing;
	
	/**
	 * A mez� s�rl�d�sa
	 */
	private Friction friction;
	
	/**
	 * A mez� szomsz�dai
	 */
	private HashMap<Direction, FieldBase> neighbours;
	
	public abstract void printState(PrintWriter w, boolean stdout);
	
	public FieldBase() {
		neighbours = new HashMap<Direction, FieldBase>();
		friction = Friction.Normal;
	}
	
	public FieldBase(FieldView _view) {
		view = _view;
		neighbours = new HashMap<Direction, FieldBase>();
		friction = Friction.Normal;
	}
	
	/**
	 * Be�ll�tja a mez�n l�v� dolgot
	 * @param t a mez�n l�v� dolog
	 */
	public void setThing(Thing t) {
		thing = t;
	}
	
	/**
	 * @return a mez�n l�v� dolog
	 */
	public Thing getThing() {
		return thing;
	}
	
	/**
	 * Be�ll�tja a s�rl�d�st
	 * @param f a s�rl�d�s
	 */
	public void setFriction(Friction f) {
		friction = f;
	}
	
	/**
	 * @return A mez� s�rl�d�sa
	 */
	public Friction getFriction() {
		return friction;
	}
	
	//absztrakt fogad� f�ggv�nyek
	public abstract boolean Accept(Box b);
	
	public abstract boolean Accept(Worker w);
	
	/**
	 * Leveszi a mez�n l�v� dolgot
	 */
	public void Remove() {
		thing = null;
	}
	/**
	 * Be�ll�tja k�lcs�n�sen a param�terrel a szomsz�ds�got
	 * @param d melyik ir�nyban
	 * @param f ki a szomsz�d
	 */
	public void setNeighbor(Direction d, FieldBase f) {
		neighbours.put(d, f);
        Direction n = null;
        switch (d)
        {
        case Up: n = Direction.Down; break;
        case Down: n = Direction.Up; break;
        case Right: n = Direction.Left; break;
        case Left: n = Direction.Right; break;
        default: return;
        }
        if (f.getNeighbor(n) == null)
            f.setNeighbor(n, this);
    }
	
	/**
	 * visszaadja a megadott ir�nyban l�v� szomsz�d mez�t
	 * @param d a k�rd�ses ir�ny
	 * @return a szomsz�d mez�
	 */
	public FieldBase getNeighbor(Direction d) {
		return neighbours.get(d);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
