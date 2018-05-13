package components;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

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
	private MenuPanel menuPanel;
	private GamePanel gamePanel;
	private EndPanel endPanel;
	
	
	
	public GameWindow() {
		super("Sokoban");
		setDefaultLookAndFeelDecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		setResizable(false);
		initMenu();
		
	}
	
	public void initMenu() {
		try {
			menuPanel = new MenuPanel(this);
			add(menuPanel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(true);
		repaint();
		invalidate();
	}
	/**
	 * Elkezdi a játékot, létrehozza a raktárépületet
	 */
	public void startGame() {
		remove(menuPanel);
		initComponents();
	}
	
	//befejezi a játékot, ha a feltételek teljesülnek
	public void endGame() {
		remove(gamePanel);
		if(getWorker1().getField() == null) {		//meghalt
			endPanel = new EndPanel(2);
			add(endPanel);
		}
		else if(getWorker2().getField() == null) {		//meghalt
			endPanel = new EndPanel(1);
			add(endPanel);
		}
		else if(getWorker1().getPoints() > getWorker2().getPoints()) {
			endPanel = new EndPanel(1);
			add(endPanel);
		}	
		else if(getWorker1().getPoints() < getWorker2().getPoints()) {
			endPanel = new EndPanel(2);
			add(endPanel);
		}
		else {
			endPanel = new EndPanel(0);
			add(endPanel);
		}
		
		Timer t = new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				remove(endPanel);
				initMenu();
		    }
		});
		t.setRepeats(false);
		t.start();
		
	}
	
	private void initComponents() {
		
		gamePanel = new GamePanel(null, this);
		currentLevel = new Maze(gamePanel);
		
		Component[] comp = gamePanel.getComponents();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(Component c : comp) {
			c.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
		}
		
		this.add(gamePanel);
		
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
		      }        
		 });    
		setVisible(true);
		gamePanel.addKeyListener(new GameController(this, currentLevel.getWorkers().get(1), currentLevel.getWorkers().get(0)));
		gamePanel.requestFocusInWindow();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		GameWindow window = new GameWindow();
		window.setVisible(true);
		window.repaint();
		window.revalidate();
	}

	public Worker getWorker1() {
		return currentLevel.getWorkers().get(1);
	}

	public Worker getWorker2() {
		return currentLevel.getWorkers().get(0);
	}

	
}
