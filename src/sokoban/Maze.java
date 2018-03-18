package sokoban;

import java.util.List;

public class Maze {
	private List<FieldBase> fields;
	private List<Box> boxes;
	private List<Worker> workers;
	
	public void init() {
		
	}
	
	public boolean CheckEndOfGame()
	{
		
		if (CheckBoxes())
			return true;
		else if (workers.size() <= 1)
			return true;
		
		return false;
		
	}
	
	public boolean CheckBoxes()
	{
		for (Box b : boxes)
		{
			if (!b.onBoxField)
				return false;
		}
		return true;		
	}
	
}
