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
 * A manüt megvalósító panel.
 *
 */
public class MenuPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * a fõablak
	 */
	private GameWindow window;
	
	/**
	 * új játékot kezdõ gomb
	 */
	private JButton newGameButton;
	/**
	 * kilépés gombja
	 */
	private JButton exitButton;
	/**
	 * háttérkép
	 */
	transient private BufferedImage backGroundImage;
	
	
	/**
	 * Létrehozza a menüt tartalmazó MainMenuPanel-t, és hozzáadja a menü gombjait.
	 * @param f - a fõablak
	 */
	public MenuPanel(GameWindow f) throws IOException {
			window = f;
			newGameButton = new JButton("New Game");
			exitButton = new JButton("Exit");
			
			backGroundImage = ImageIO.read(new File("raktar.jpg"));
			
			mainMenuButtonsInit();
	}
	
	/**
	 * Megrajzolja a menüt.
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
	 * Beállítja a gombok ActionCommand-ját, és MainMenuListenert ad hozzájuk.
	 * @param f - a fõképernyõ
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
	 * Megjeleníti a fõmenüt. Rárakja a képernyõre a gombokat és beállítja a betûméretet.
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
	 * Letörli a képernyõt.
	 *
	 */
	public void clearScreen() {
		this.removeAll();
		this.revalidate();
		this.repaint();
	}
}
	
