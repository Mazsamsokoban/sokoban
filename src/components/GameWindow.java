package components;


import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.GameController;
import models.Direction;
import models.Worker;
import views.WorkerView;



public class GameWindow extends JFrame {
	
	Worker player1;
	Worker player2;
	
	WorkerView w1;
	public GameWindow() {
		player1 = new Worker();
		player2 = new Worker();
		try {
			w1 = new WorkerView(10,10, ImageIO.read(new File("box.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(w1);
		setDefaultLookAndFeelDecorated(true);
		setExtendedState(GameWindow.MAXIMIZED_BOTH); 
		setSize(600,400);
		
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
				w1.y -= 20;
				break;
			case Down:
				w1.y += 20;
				break;
			case Left:
				w1.x -= 20;
				break;
			case Right:
				w1.x += 20;
				break;
		}
		repaint();
		/*if(playerNumber == 1) {
			
			
		}
		else if(playerNumber == 2) {
			player2.Move(direction);
		}*/
	}
	public static void main(String[] args) throws IOException {
		GameWindow window = new GameWindow();
		window.addKeyListener(new GameController(window));
	}

	
}
