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
	 * a rakt�r�p�let
	 */
	private Maze currentLevel;
	/**
	 * a men�t tartalmaz� panel
	 */
	private MenuPanel menuPanel;
	/**
	 * a j�t�kot tartalmaz� panel
	 */
	private GamePanel gamePanel;
	/**
	 * A j�t�k v�g�t jelz� panel
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
	 * Men� l�trehoz�sa �s megjelen�t�se
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
	 * Elkezdi a j�t�kot, l�trehozza a rakt�r�p�letet
	 */
	public void startGame() {
		remove(menuPanel);
		initComponents();
	}
	
	/**
	 * befejezi a j�t�kot, ha a felt�telek teljes�lnek, kirajzol egy EndPanelt
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
		
		// 3 mp ut�n visszal�p a f�men�be
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
	 * J�t�k l�trehoz�sa �s gombkezel� hozz�ad�sa
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
	 * @return az 1-es munk�s
	 */
	public Worker getWorker1() {
		return currentLevel.getWorkers().get(1);
	}
	
	/**
	 * 
	 * @return a 2-es munk�s
	 */
	public Worker getWorker2() {
		return currentLevel.getWorkers().get(0);
	}

	
}
