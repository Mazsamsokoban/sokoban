package components;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EndPanel extends JPanel {
	private int winner;
	
	public EndPanel(int w) {
		winner = w;
	}
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
