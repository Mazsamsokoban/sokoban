package sokoban;

import java.io.IOException;

public class Field extends FieldBase  {
	boolean debug = false;
	public void ChangeDebug()
	{
		debug = !debug;
	}
	
	public Field() {
		Game.op.makeCall(null);
		System.out.print("Field()");
		
		Game.op.returnFromFunc(null);
		System.out.print("Field()");
	}
	
	//fogadja a rá érkezõ boxot(ütköztet)
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		//4-es menupont choice miatt
				if (debug)
				{
					boolean valasz = Tester.Kerdes("Oda tud lépni ?");
					ChangeDebug();
					Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
					if(valasz) 
						return true;
					else
						return false;
				}
		
		
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		if (thing != null)
		{
			b.CollideWith(thing);
			return Accept(b);
		}
		return true;
	}
	
	//fogadja a rá érkezõ boxot(ütköztet)
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		
		//1-es menupont choice miatt
		if (debug)
		{
			boolean valasz = Tester.Kerdes("Oda tud lépni ?");
			ChangeDebug();
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
			if(valasz) 
				return true;
			else
				return false;
		}
		
		
		if (thing != null)
		{
			w.CollideWith(thing);
			//Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
			//return Accept(w);
		}
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		return true;
	}
	
	//leveszi a róla távozó dolgot
	public void Remove()
	{
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		super.thing = null;
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
	}
}
