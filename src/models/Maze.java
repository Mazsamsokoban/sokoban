package models;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import components.GamePanel;
import views.BoxView;
import views.ChangingFieldView;
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
	
	private GamePanel gamePanel;

	/**
	 * Létrehozza az elemeknek a tárolókat 
	 */
	public Maze(GamePanel panel) {
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
		BufferedImage floorImg = null;
		BufferedImage wallImg = null;
		BufferedImage holeImg = null;
		BufferedImage switchImg = null;
		BufferedImage boxImg = null;
		BufferedImage w1boxImg = null;
		BufferedImage w2boxImg = null;
		BufferedImage bfImg = null;
		BufferedImage oilImg = null;
		BufferedImage honeyImg = null;
		try {
			floorImg = ImageIO.read(new File("floor.png"));
			wallImg = ImageIO.read(new File("wall.png"));
			holeImg = ImageIO.read(new File("hole.png"));
			switchImg = ImageIO.read(new File("button.png"));
			boxImg = ImageIO.read(new File("box.png"));
			w1boxImg = ImageIO.read(new File("cyanbox.png"));
			w2boxImg = ImageIO.read(new File("yellowbox.png"));
			bfImg = ImageIO.read(new File("boxfield.png"));
			honeyImg = ImageIO.read(new File("honey.jpg"));
			oilImg = ImageIO.read(new File("oil.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		SwitchableHole shole;
		Switch sw;
		/*1.sor*/
		for(int i = 0, x = 0; i < 8; x += 100, ++i) {
			fields.add(new Obstacle(new FieldView(x, 0, wallImg)));
		}
		/*2.sor*/
		fields.add(new Obstacle(new FieldView(0, 100, wallImg)));
		fields.add(new Field(new FieldView(100,100, floorImg)));
		fields.add(new Field(new FieldView(200,100, floorImg)));
		fields.add(new Obstacle(new FieldView(300, 100, wallImg)));
		fields.add(new Field(new FieldView(400,100, floorImg)));
		fields.add(new Field(new FieldView(500,100, floorImg)));
		fields.add(new BoxField(new FieldView(600,100, bfImg)));
		fields.add(new Obstacle(new FieldView(700, 100, wallImg)));
		/*3.sor*/
		fields.add(new Obstacle(new FieldView(0, 200, wallImg)));
		fields.add(new Field(new FieldView(100,200, floorImg)));
		fields.add(new Field(new FieldView(200,200, floorImg)));
		fields.add(new Obstacle(new FieldView(300, 200, wallImg)));
		fields.add(new BoxField(new FieldView(400,200, bfImg)));
		fields.add(new Field(new FieldView(500,200, floorImg)));
		fields.add(new Field(new FieldView(600,200, floorImg)));
		fields.add(new Obstacle(new FieldView(700, 200, wallImg)));
		/*4.sor*/
		fields.add(new Obstacle(new FieldView(0, 300, wallImg)));
		fields.add(new Field(new FieldView(100,300, floorImg)));
		fields.add(new Field(new FieldView(200,300, floorImg)));
		fields.add(new Obstacle(new FieldView(300, 300, wallImg)));
		fields.add(new Field(new FieldView(400, 300, floorImg)));
		fields.add(shole = new SwitchableHole(new ChangingFieldView(500, 300, floorImg, holeImg)));
		fields.add(new Field(new FieldView(600,300, floorImg)));
		fields.add(new Obstacle(new FieldView(700, 300, wallImg)));
		/*5.sor*/
		fields.add(new Obstacle(new FieldView(0, 400, wallImg)));
		fields.add(new Field(new FieldView(100,400, floorImg)));
		fields.add(new Field(new FieldView(200,400, floorImg)));
		fields.add(new BoxField(new FieldView(300, 400, bfImg)));
		fields.add(sw = new Switch(new FieldView(400, 400, switchImg)));
		fields.add(new Field(new FieldView(500, 400, floorImg)));
		fields.add(new Field(new FieldView(600,400, floorImg)));
		fields.add(new Obstacle(new FieldView(700, 400, wallImg)));
		/*6.sor*/
		fields.add(new Obstacle(new FieldView(0, 500, wallImg)));
		fields.add(new Hole(new FieldView(100, 500, holeImg)));
		for(int i = 0, x = 200; i < 4; x += 100, ++i) {
			fields.add(new Field(new FieldView(x, 500, floorImg)));
		}
		fields.add(new BoxField(new FieldView(600, 500, bfImg)));
		fields.add(new Obstacle(new FieldView(700, 500, wallImg)));
		/*7.sor*/
		for(int i = 0, x = 0; i < 8; x += 100, ++i) {
			fields.add(new Obstacle(new FieldView(x, 600, wallImg)));
		}
		
		//szomszédságok
		for(int i = 0; i< fields.size()-1; ++i) {
			fields.get(i).setNeighbor(Direction.Right, fields.get(i+1));
		}
		
		for(int i = 0; i < fields.size() - 8; ++i) {
			fields.get(i).setNeighbor(Direction.Down, fields.get(i+8));
		}
		
		//munkások és ládák
		Worker worker1 = new Worker(new WorkerView(0, 0, Color.CYAN));
		Worker worker2 = new Worker(new WorkerView(0, 0, new Color(244, 178, 26)));
		workers.add(worker1);
		workers.add(worker2);
		Box box1 = new Box(new BoxView(0, 0, boxImg, w1boxImg, w2boxImg));
		Box box2 = new Box(new BoxView(0, 0, boxImg, w1boxImg, w2boxImg));
		Box box3 = new Box(new BoxView(0, 0, boxImg, w1boxImg, w2boxImg));
		Box box4 = new Box(new BoxView(0, 0, boxImg, w1boxImg, w2boxImg));
		boxes.add(box1);
		boxes.add(box2);
		boxes.add(box3);
		boxes.add(box4);
		fields.get(7+5).setThing(worker1);
		fields.get(7+6).setThing(worker2);
		fields.get(7+8+3).setThing(box1);
		fields.get(7+8*2+3).setThing(box2);
		fields.get(7+8*3+6).setThing(box3);
		fields.get(7+8*4+4).setThing(box4);
		
		sw.SetSh(shole);
	
		showMaze();
		timer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		         updateAll();
		         try {
		        	 if(CheckEndOfGame() || gamePanel.isEnded()) {
						 gamePanel.endGame();
						 timer.stop();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		gamePanel.repaint();
		gamePanel.invalidate();
	}
	
	/**
	 * ellenõrzi, hogy teljesülnek-e a játék befejezésének feltételei, és ez alapján tér vissza
	 * @return vége van.e a játéknak
	 */
	public boolean CheckEndOfGame() throws IOException
	{
		if (CheckBoxes())			//minden doboz helyre került-e
			return true;
		else {
			int n = 0;
			for(Worker w : workers)
				if(w.getField() == null)
					++n;
			if(n == workers.size() - 1)
				return true;
		}
		return false;
	}
	
	
	/**
	 * Leellenõrzi, hogy minden láda kijelölt helyen van-e
	 * @return minden láda beért-e
	 */
	public boolean CheckBoxes() throws IOException
	{
		for (Box b : boxes)
		{
			if (!b.isOnBoxField() && b.getField() != null) {
				return false;
			}
		}
		return true;		
	}

	public List<Worker> getWorkers() {
		return workers;
	}
	
}
