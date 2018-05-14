package components;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.Timer;

import controllers.GameController;
import models.Maze;
import models.Worker;



public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	/**
	 * a raktárépület
	 */
	private Maze currentLevel;
	/**
	 * a menüt tartalmazó panel
	 */
	private MenuPanel menuPanel;
	/**
	 * a játékot tartalmazó panel
	 */
	private GamePanel gamePanel;
	/**
	 * A játék végét jelzõ panel
	 */
	private EndPanel endPanel;
	
	
	
	public GameWindow() {
		super("Sokoban");
		setDefaultLookAndFeelDecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		setResizable(false);
		initMenu();
		
	}
	
	/**
	 * Menü létrehozása és megjelenítése
	 */
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
	
	/**
	 * befejezi a játékot, ha a feltételek teljesülnek, kirajzol egy EndPanelt
	 */
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
		
		// 3 mp után visszalép a fõmenübe
		Timer t = new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				remove(endPanel);
				initMenu();
		    }
		});
		t.setRepeats(false);
		t.start();
		
	}
	
	/**
	 * Játék létrehozása és gombkezelõ hozzáadása
	 */
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

	/**
	 * 
	 * @return az 1-es munkás
	 */
	public Worker getWorker1() {
		return currentLevel.getWorkers().get(1);
	}
	
	/**
	 * 
	 * @return a 2-es munkás
	 */
	public Worker getWorker2() {
		return currentLevel.getWorkers().get(0);
	}

	
}
