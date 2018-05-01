package models;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import views.BoxView;
import views.FieldView;
import views.WorkerView;

/**
 * A raktárépületet képviselõ osztály
 */
public class Maze {
	//public Tester tester;
	
	private List<FieldBase> fields;
	
	private List<Box> boxes;
	private List<Worker> workers;
	private Timer timer;
	private Game game;
	private JPanel gamePanel;

	public Worker worker1;
	public Worker worker2;
	
	
	/**
	 * Létrehozza az elemeknek a tárolókat 
	 */
	public Maze(JPanel panel) {
		gamePanel = panel;
		fields = new ArrayList<FieldBase>();
		boxes = new ArrayList<Box>();
		workers = new ArrayList<Worker>();
		init();
	}
	
	/**
	 * Inicializál egy pályát
	 */
	public void init() {
		//inicializálás soronként
		
		try {
			Field field = new Field(new FieldView(0,0, ImageIO.read(new File("floor.png"))));
			worker1 = new Worker(new WorkerView(0, 0, Color.CYAN));
			worker2 = new Worker(new WorkerView(0, 0, new Color(244, 178, 26)));
			Box box0 = new Box(new BoxView(100, 0, ImageIO.read(new File("box.png"))));
			Box box1 = new Box(new BoxView(200, 0, ImageIO.read(new File("box.png"))));
			Box box2 = new Box(new BoxView(300, 0, ImageIO.read(new File("box.png"))));
			fields.add(field);
			boxes.add(box0);
			boxes.add(box1);
			boxes.add(box2);
			workers.add(worker1);
			workers.add(worker2);
			field.setThing(worker1);
			
			for(int i = 0, x = 100; i < 7;  i++, x += 100) {
				FieldBase o = new Field(new FieldView(x, 0, ImageIO.read(new File("floor.png"))));
				fields.add(o);
				int index = fields.indexOf(o);		//az elõtte lévõ
				System.out.println(index);
				o.setNeighbor(Direction.Left, fields.get(index-1));
			}
			fields.get(1).setThing(box0);
			fields.get(2).setThing(box1);
			fields.get(3).setThing(box2);
			fields.get(4).setThing(worker2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		showMaze();
		timer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		         updateAll();
		    }
		});
		timer.setRepeats(true);
		timer.start();
	}
	
	
	private void showMaze() {
		for(Worker w : workers)
			gamePanel.add(w.getView());
		for(Box b : boxes){
			gamePanel.add(b.getView());
		}
		for(FieldBase f : fields) {
			gamePanel.add(f.getView());
		}
		
	}

	public void updateAll() {
		for(FieldBase f : fields) {
			f.update();
		}
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
