package components;


import java.awt.BorderLayout;
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
import models.Worker;
import views.BoxView;
import views.SwitchableHoleView;
import views.ViewBase;
import views.WorkerView;



public class GameWindow extends JFrame {
	
	Worker player1;
	Worker player2;
	
	BoxView w1;
	WorkerView w;
	SwitchableHoleView sw;
	
	public GameWindow() {
		super("Sokoban");
		setDefaultLookAndFeelDecorated(true);
		setExtendedState(GameWindow.MAXIMIZED_BOTH); 
		setSize(600,400);
		initComponents();
	}
	
	private void initComponents() {
		//this.setLayout(new BorderLayout());
		player1 = new Worker();
		player2 = new Worker();
		try {
			w1 = new BoxView(100 , 100, ImageIO.read(new File("box.png")));
			w = new WorkerView(500, 500);
		
			
			//sw = new SwitchableHoleView(700, 700, ImageIO.read(new File("box.png")), ImageIO.read(new File("")));
		} catch (IOException e) {
			System.out.println("Nem sikerült beolvasni egy képet!");
		}
		JPanel panel = new JPanel(null);
		panel.add(w);
		panel.add(w1);
		
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
		window.addKeyListener(new GameController(window));
		window.setVisible(true);
		window.repaint();
		window.revalidate();
	}

	
}
