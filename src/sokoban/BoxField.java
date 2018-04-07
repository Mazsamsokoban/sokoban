package sokoban;


public class BoxField extends Field {
	private Worker owner;
	private Box box;

	
	public BoxField() {
		
	}
	
	public BoxField(String n){
		name = n;
	}
	//be�ll�tja a betol�j�t
	public void setOwner(Worker w) {
		owner = w;
	}
	
	//dobozt fogad, �s pontot ad, illetve jelez a t�l�kon kereszt�l
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
	
	//munk�st fogad, �s elhelyezi a mez�n, ha lehet
	public boolean Accept(Worker w) {
		return super.Accept(w);
	}
	
	//leveszi a mez�n l�v� boxot, �s ha olyan tolta le, aki betolta, akkor pontot von le
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
