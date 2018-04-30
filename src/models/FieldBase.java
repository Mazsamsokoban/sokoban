package models;
import java.io.PrintWriter;
import java.util.HashMap;

import views.FieldView;

/**
 * Mezõk õsosztálya
 */
public abstract class FieldBase{
	private FieldView view;
	protected String name = "";
	
	/**
	 * A mezõn lévõ dolog
	 */
	protected Thing thing;
	
	/**
	 * A mezõ súrlódása
	 */
	private Friction friction;
	
	/**
	 * A mezõ szomszédai
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
	 * Beállítja a mezõn lévõ dolgot
	 * @param t a mezõn lévõ dolog
	 */
	public void setThing(Thing t) {
		thing = t;
	}
	
	/**
	 * @return a mezõn lévõ dolog
	 */
	public Thing getThing() {
		return thing;
	}
	
	/**
	 * Beállítja a súrlódást
	 * @param f a súrlódás
	 */
	public void setFriction(Friction f) {
		friction = f;
	}
	
	/**
	 * @return A mezõ súrlódása
	 */
	public Friction getFriction() {
		return friction;
	}
	
	//absztrakt fogadó függvények
	public abstract boolean Accept(Box b);
	
	public abstract boolean Accept(Worker w);
	
	/**
	 * Leveszi a mezõn lévõ dolgot
	 */
	public void Remove() {
		thing = null;
	}
	/**
	 * Beállítja kölcsönösen a paraméterrel a szomszédságot
	 * @param d melyik irányban
	 * @param f ki a szomszéd
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
	 * visszaadja a megadott irányban lévõ szomszéd mezõt
	 * @param d a kérdéses irány
	 * @return a szomszéd mezõ
	 */
	public FieldBase getNeighbor(Direction d) {
		return neighbours.get(d);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
