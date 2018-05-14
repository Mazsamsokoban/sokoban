package components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * A man�t megval�s�t� panel.
 *
 */
public class MenuPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * a f�ablak
	 */
	private GameWindow window;
	
	/**
	 * �j j�t�kot kezd� gomb
	 */
	private JButton newGameButton;
	/**
	 * kil�p�s gombja
	 */
	private JButton exitButton;
	/**
	 * h�tt�rk�p
	 */
	transient private BufferedImage backGroundImage;
	
	
	/**
	 * L�trehozza a men�t tartalmaz� MainMenuPanel-t, �s hozz�adja a men� gombjait.
	 * @param f - a f�ablak
	 */
	public MenuPanel(GameWindow f) throws IOException {
			window = f;
			newGameButton = new JButton("New Game");
			exitButton = new JButton("Exit");
			
			backGroundImage = ImageIO.read(new File("raktar.jpg"));
			
			mainMenuButtonsInit();
	}
	
	/**
	 * Megrajzolja a men�t.
	 *
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int height = getHeight();
		int width = getWidth();
		g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawImage(backGroundImage, 0, 0, width, height, this);
		
		showMainMenu();
	}
	
	/**
	 * Be�ll�tja a gombok ActionCommand-j�t, �s MainMenuListenert ad hozz�juk.
	 * @param f - a f�k�perny�
	 */
	void mainMenuButtonsInit() {
		
		newGameButton.setActionCommand("New Game");
		newGameButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent event){
		        setVisible(false);
		        repaint();
		        invalidate();
	        	window.startGame();
		      }        
		 });
		newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		exitButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent event){
		        System.exit(0);
		      }        
		 });
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		showMainMenu();
	}
	
	/**
	 * Megjelen�ti a f�men�t. R�rakja a k�perny�re a gombokat �s be�ll�tja a bet�m�retet.
	 *
	 */
	public void showMainMenu() {
		clearScreen();
		int height = getHeight();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0, height/5)));
		this.add(newGameButton, BorderLayout.CENTER);
		
		this.add(Box.createRigidArea(new Dimension(0, height/13)));
		this.add(exitButton, BorderLayout.CENTER);
		
		newGameButton.setFont(new Font("Serif", Font.BOLD, height/13));
		exitButton.setFont(new Font("Serif", Font.BOLD, height/13));
		
	}
	
	/**
	 * Let�rli a k�perny�t.
	 *
	 */
	public void clearScreen() {
		this.removeAll();
		this.revalidate();
		this.repaint();
	}
}
	
