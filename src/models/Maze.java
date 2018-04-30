package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A rakt�r�p�letet k�pvisel� oszt�ly
 */
public class Maze {
	public Tester tester;
	
	private FieldBase fields[][];
	
	private List<Box> boxes;
	private List<Worker> workers;
	private Timer t;
	private Game game;
	
	/**
	 * L�trehozza az elemeknek a t�rol�kat 
	 */
	public Maze() {
		fields = new FieldBase[5][5];
		boxes = new ArrayList<Box>();
		workers = new ArrayList<Worker>();
	}
	
	/**
	 * Inicializ�l egy p�ly�t
	 */
	public void init() {
	}
	
	
	public void UpdateAll() {
		
	}
	/**
	 * ellen�rzi, hogy teljes�lnek-e a j�t�k befejez�s�nek felt�telei, �s ez alapj�n t�r vissza
	 * @return v�ge van.e a j�t�knak
	 */
	public boolean CheckEndOfGame() throws IOException
	{
		if (CheckBoxes())			//minden doboz helyre ker�lt-e
			return true;
		else if (workers.size() <= 1)
			return true;
		return false;
	}
	
	/**
	 * Be�ll�tja, hogy melyik j�t�khoz tartozik
	 * @param g a j�t�k
	 */
	public void setGame(Game g) {
		game = g;
	}
	
	/**
	 * Leellen�rzi, hogy minden l�da kijel�lt helyen van-e
	 * @return minden l�da be�rt-e
	 */
	public boolean CheckBoxes() throws IOException
	{
		for (Box b : boxes)
		{
			if (!b.isOnBoxField()) {
				return false;
			}
		}
		return true;		
	}
	
}
