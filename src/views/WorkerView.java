package views;

import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class WorkerView extends ViewBase{

	public WorkerView(int _x, int _y, Image _img) {
		super(_x, _y, _img);
	
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D.Double body =
				  new Ellipse2D.Double(x, y, mezomeret* 2/3, mezomeret* 2/3);
		Ellipse2D.Double head =
				  new Ellipse2D.Double(x, y, mezomeret* 1/3, mezomeret* 1/3);
		
		g2d.fill(body);
		g2d.fill(head);		
	}
}
