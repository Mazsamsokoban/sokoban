package views;

import java.awt.Image;
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
		
		g2d.drawOval(super.x, super.y, mezomeret * 3/4, mezomeret * 3/4);		
		g2d.drawOval(super.x, super.y, mezomeret * 1/2, mezomeret * 1/2);
	}
}
