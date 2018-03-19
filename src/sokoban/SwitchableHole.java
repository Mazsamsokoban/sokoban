package sokoban;

import java.io.IOException;

public class SwitchableHole extends Hole {
	private boolean open;
	private Thing thing;
	
	public SwitchableHole() {
		Game.op.makeCall(null);
		System.out.print("SwitchableHole()");
		open = false;
		Game.op.returnFromFunc(null);
		System.out.print("SwitchableHole()");
	}
	
	//kinyílik, és ha van rajta valami, akkor ledobja
	public void SetOpen() {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
		
		//DBG
		boolean valasz = Tester.Kerdes("Nyitva van az ajtó ?");
		if(valasz) 
			open = true;
		else
			open = false;		

		open = !open;
		
		if (open)
		{
			valasz = Tester.Kerdes("Van rajta valami ?");
			if(valasz) 
			{
				thing = new Box();
				thing.Delete();
			}
		}
		Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "()");
	}
	
	//fogadja a rá érkezõ dobozt, ha nyitva van, akkor ledobja
	public boolean Accept(Box b) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
		
		
		if (open) {
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
			return super.Accept(b);
		}
		else
		{					
			if (thing != null)
			{
				b.CollideWith(thing);
				Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
				return Accept(b);
			}
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(b) +  ")");
			return true;
		}			
	}
	
	//fogadja a rá érkezõ munkást, ha nyitva van, akkor ledobja
	public boolean Accept(Worker w) {
		Game.op.callfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
		System.out.println("\nNyitva van a csapóajtó? ? I/N");
		String choice = null;
		try {
			choice = Game.op.br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(choice.charAt(0) == 'I' || choice.charAt(0) == 'i') 
			open = true;
		else
			open = false;
			
		
		if (open) {
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
			return super.Accept(w);
		}
		else
		{
			
			//DBG
			boolean valasz = Tester.Kerdes("Oda tud lépni ?");
			Game.op.returnfunc(this, new Object(){}.getClass().getEnclosingMethod().getName() + "(" + Game.op.get(w) +  ")");
			if(valasz) 
				return true;
			else
				return false;
			
			//DBG
			
			
		}		
	}
}
