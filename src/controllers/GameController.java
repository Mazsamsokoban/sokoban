package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import components.GameWindow;
import models.Direction;

public class GameController extends KeyAdapter{
	GameWindow window;
	
	public GameController(GameWindow w){
		window = w;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				window.movePlayer(1, Direction.Up);
				break;
			case KeyEvent.VK_DOWN:
				window.movePlayer(1, Direction.Down);
				break;
			case KeyEvent.VK_LEFT:
				window.movePlayer(1, Direction.Left);
				break;
			case KeyEvent.VK_RIGHT:
				window.movePlayer(1, Direction.Right);
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
