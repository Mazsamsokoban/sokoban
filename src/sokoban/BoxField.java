package sokoban;


public class BoxField extends Field {
	private Worker owner;
	private Box box;

	
	public BoxField() {
		
	}
	
	public BoxField(String n){
		name = n;
	}
	//beállítja a betolóját
	public void setOwner(Worker w) {
		owner = w;
	}
	
	//dobozt fogad, és pontot ad, illetve jelez a tólókon keresztül
	public boolean Accept(Box b) {
		if (thing != null)
		{
			b.CollideWith(thing);
			return Accept(b);
		}
		
		Worker pusher = b.Notify();	
		
		if (pusher == b.getOwner())
		{
			pusher.AddPoints(1);
		}
		else if (b.getOwner() == null)
		{
			pusher.AddPoints(1);
			setOwner(pusher);
			b.setOwner(pusher);
		}
		
		b.setOnBoxField();
		return true;
	}
	
	//munkást fogad, és elhelyezi a mezõn, ha lehet
	public boolean Accept(Worker w) {
		return super.Accept(w);
	}
	
	//leveszi a mezõn lévõ boxot, és ha olyan tolta le, aki betolta, akkor pontot von le
	@Override
	public void Remove()
	{
		Worker pusher = ((Box)thing).getPusher();
		Worker o = ((Box)thing).getOwner();
		if(pusher == o)
			pusher.AddPoints(-1);
		
		thing = null;
	}
}
