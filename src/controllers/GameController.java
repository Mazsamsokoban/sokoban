package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import components.GameWindow;
import models.Direction;
import models.Friction;
import models.Worker;

public class GameController extends KeyAdapter{
	GameWindow window;
	Worker worker1;
	Worker worker2;
	
	public GameController(GameWindow w, Worker w1, Worker w2){
		window = w;
		worker1 = w1;
		worker2 = w2;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				worker1.Move(Direction.Up);
				break;
			case KeyEvent.VK_DOWN:
				worker1.Move(Direction.Down);
				break;
			case KeyEvent.VK_LEFT:
				worker1.Move(Direction.Left);
				break;
			case KeyEvent.VK_RIGHT:
				worker1.Move(Direction.Right);
				break;
			case KeyEvent.VK_J:
				worker1.put(Friction.Normal);
				break;
			case KeyEvent.VK_K:
				worker1.put(Friction.Honey);
				break;
			case KeyEvent.VK_L:
				worker1.put(Friction.Oil);
				break;
			
			case KeyEvent.VK_W:	
				worker2.Move(Direction.Up);
				break;
			case KeyEvent.VK_A:	
				worker2.Move(Direction.Left);
				break;
			case KeyEvent.VK_S:	
				worker2.Move(Direction.Down);
				break;
			case KeyEvent.VK_D:	
				worker2.Move(Direction.Right);
				break;
			case KeyEvent.VK_X:
				worker2.put(Friction.Normal);
				break;
			case KeyEvent.VK_C:
				worker2.put(Friction.Honey);
				break;
			case KeyEvent.VK_V:
				worker2.put(Friction.Oil);
				break;
			default:
				break;
		}
    }
}
