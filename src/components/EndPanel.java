package components;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * A v�geredm�nyt megjelen�t� panel.
 *
 */
public class EndPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * A gy�ztes sorsz�ma, 0 eset�n d�ntetlen
	 */
	private int winner;
	
	public EndPanel(int w) {
		winner = w;
	}
	
	/**
	 * Gy�ztes/d�ntetlen ki�r�sa
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
		switch(winner) {
		case 1:
			g.drawString("Yellow worker wins!", 500, 300);
			break;
		case 2:
			g.drawString("Blue worker wins!", 500, 300);
			break;
		default:
			g.drawString("It's a tie!", 600, 300);
			break;
		}
		
	}
}
