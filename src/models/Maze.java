package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A raktárépületet képviselõ osztály
 */
public class Maze {
	public Tester tester;
	
	private FieldBase fields[][];
	
	private List<Box> boxes;
	private List<Worker> workers;
	private Timer t;
	private Game game;
	
	/**
	 * Létrehozza az elemeknek a tárolókat 
	 */
	public Maze() {
		fields = new FieldBase[5][5];
		boxes = new ArrayList<Box>();
		workers = new ArrayList<Worker>();
	}
	
	/**
	 * Inicializál egy pályát
	 */
	public void init() {
	}
	
	
	public void UpdateAll() {
		
	}
	/**
	 * ellenõrzi, hogy teljesülnek-e a játék befejezésének feltételei, és ez alapján tér vissza
	 * @return vége van.e a játéknak
	 */
	public boolean CheckEndOfGame() throws IOException
	{
		if (CheckBoxes())			//minden doboz helyre került-e
			return true;
		else if (workers.size() <= 1)
			return true;
		return false;
	}
	
	/**
	 * Beállítja, hogy melyik játékhoz tartozik
	 * @param g a játék
	 */
	public void setGame(Game g) {
		game = g;
	}
	
	/**
	 * Leellenõrzi, hogy minden láda kijelölt helyen van-e
	 * @return minden láda beért-e
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
