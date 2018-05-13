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
		int r = mezomeret * 3/5;
		int R = mezomeret;
		Ellipse2D.Double body =
				  new Ellipse2D.Double(x, y, R, R);
		Ellipse2D.Double head =
				  new Ellipse2D.Double(x+r/3, y+r/3, r, r);
		
		g2d.setPaint(color);
		g2d.fill(body);
		g2d.setPaint(Color.lightGray);
		g2d.fill(head);
		revalidate();
	}
	
	
}
