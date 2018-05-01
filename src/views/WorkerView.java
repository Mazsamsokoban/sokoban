package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;

public class WorkerView extends MovingObjectView{
	Color color;
	public WorkerView(int _x, int _y, Color c) {
		super(_x, _y);
		color = c;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int r = mezomeret* 1/3;
		int R = mezomeret* 2/3;
		Ellipse2D.Double body =
				  new Ellipse2D.Double(x+r/2, y+r/2, R, R);
		Ellipse2D.Double head =
				  new Ellipse2D.Double(x+r, y+r, r, r);
		
		g2d.setPaint(color);
		g2d.fill(body);
		g2d.setPaint(Color.lightGray);
		g2d.fill(head);
		revalidate();
	}
	
	
}
