package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	/**
	 * A tartalmaz� ablak
	 */
	private GameWindow window;
	/**
	 * Megnyomt�k-e az End game gombot
	 */
	private boolean isEnded = false;
	public GamePanel(LayoutManager m, GameWindow w) {
		super(m);
		window = w;
		//t�glalapra kattint�s �rz�kel�se
		addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int x = e.getX(); int y = e.getY();
				if(x>1000 && x<1200 && y>120 && y<170)
					isEnded = true;
			}
			
		});
	}
	
	/**
	 * R�kattintottak-e a t�glalapra 
	 * @return isEnded �rt�ke
	 */
	public boolean isEnded() {
		return isEnded;
	}
	
	/**
	 * J�t�k befejez�se
	 */
	public void endGame() {
		isEnded = true;
		window.endGame();
	}
	
	/**
	 * Pontok �s End game t�glalap kirajzol�sa
	 */
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		g.drawString("Yellow worker points: " + Integer.toString(window.getWorker1().getPoints()), 1000, 50);
		g.drawString("Blue worker points: " + Integer.toString(window.getWorker2().getPoints()), 1000, 80);
		
		g.setColor(Color.GRAY);
		g.fillRect(1000, 120, 200, 50);
		
		g.setColor(Color.BLACK);
		g.drawString("End game ", 1050, 150);
	}
}
