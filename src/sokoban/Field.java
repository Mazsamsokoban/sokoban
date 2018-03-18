package sokoban;


public class Field extends FieldBase  {
	public boolean Accept(Box b) {
		if (things != null)
		{
			b.CollideWith(things);
			return Accept(b);
		}
		return true;
	}
	
	public boolean Accept(Worker w) {
		if (things != null)
		{
			w.CollideWith(things);
			return Accept(w);
		}
		return true;
	}
	
	public void Remove()
	{
		super.things = null;
	}
}
