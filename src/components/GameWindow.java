package components;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.GameController;
import models.Direction;
import models.Maze;
import models.Worker;
import views.BoxView;
import views.ChangingFieldView;
import views.FieldView;
import views.ViewBase;
import views.WorkerView;



public class GameWindow extends JFrame {
	private Maze currentLevel;
	Worker player1;
	Worker player2;
	WorkerView w;
	
	public GameWindow() {
		super("Sokoban");
		setDefaultLookAndFeelDecorated(true);
		setExtendedState(GameWindow.MAXIMIZED_BOTH); 
		//setSize(600,400);
		initComponents();
	}
	
	private void initComponents() {
		//this.setLayout(new BorderLayout());
		player1 = new Worker();
		player2 = new Worker();
		JPanel panel = new JPanel(null);
		currentLevel = new Maze(panel);
		/*try {
			panel.add(w = new WorkerView(400, 500, new Color(244, 178, 26)));
			panel.add(w = new WorkerView(200, 200, Color.CYAN));
			panel.add(new BoxView(300, 200, ImageIO.read(new File("box.png"))));
			panel.add(new BoxView(100, 500, ImageIO.read(new File("cyanbox.png"))));
			panel.add(new BoxView(300, 500, ImageIO.read(new File("yellowbox.png"))));
			panel.add(new BoxView(300, 200, ImageIO.read(new File("box.png"))));
			panel.add(new FieldView(100, 100, ImageIO.read(new File("hole.png"))));
			panel.add(new FieldView(500, 100, ImageIO.read(new File("boxfield.png"))));
			panel.add(new FieldView(500, 400, ImageIO.read(new File("wall.png"))));
			panel.add(new FieldView(100, 300, ImageIO.read(new File("wall.png"))));
			panel.add(new FieldView(200, 300, ImageIO.read(new File("wall.png"))));
			panel.add(new FieldView(400, 400, ImageIO.read(new File("wall.png"))));
			
			for(int i = 100; i<=500; i+=100) {
				for(int j = 100; j<=500; j+=100) {
					panel.add(new FieldView(i, j, ImageIO.read(new File("floor.png"))));
				}
			}
			for(int i = 0; i <= 600; i+=100) {
				panel.add(new FieldView(i, 0, ImageIO.read(new File("wall.png"))));
				panel.add(new FieldView(0, i, ImageIO.read(new File("wall.png"))));
				panel.add(new FieldView(600, i, ImageIO.read(new File("wall.png"))));
				panel.add(new FieldView(i, 600, ImageIO.read(new File("wall.png"))));
			}
			
			
				
			
			//sw = new SwitchableHoleView(700, 700, ImageIO.read(new File("box.png")), ImageIO.read(new File("")));
		} catch (IOException e) {
			System.out.println("Nem sikerült beolvasni egy képet!");
		}*/
		
		
		
		Component[] comp = panel.getComponents();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(Component c : comp) {
			c.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
		}
		
		this.add(panel);
		
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
		      }        
		 });    
		setVisible(true);
	}
	
	public void movePlayer(int playerNumber, Direction direction) {
		switch (direction) {
			case Up:
				w.y -= 100;
				break;
			case Down:
				w.y += 100;
				break;
			case Left:
				w.x -= 100;
				break;
			case Right:
				w.x += 100;
				break;
		}
		repaint();
		/*if(playerNumber == 1) {
			player1.Move(direction);
			
		}
		else if(playerNumber == 2) {
			player2.Move(direction);
		}*/
	}
	public static void main(String[] args) throws IOException {
		GameWindow window = new GameWindow();
		window.addKeyListener(new GameController(window, window.getWorker1(), window.getWorker2()));
		window.setVisible(true);
		window.repaint();
		window.revalidate();
	}

	private Worker getWorker1() {
		return currentLevel.worker1;
	}

	private Worker getWorker2() {
		return currentLevel.worker2;
	}

	
}
