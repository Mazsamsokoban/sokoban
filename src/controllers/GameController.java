package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import components.GameWindow;
import models.Direction;
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
			case 'w':
				window.movePlayer(1, Direction.Up);
				break;
			default:
				break;
		}
    }
		

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
			case 'w':
				
				break;
			case 'a':
				
				break;
			case 's':
				
				break;
			case 'd':
				
				break;
			default: ;
				break;
		}
		
	}

}
