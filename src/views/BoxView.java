package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class BoxView extends MovingObjectView {
	private ImageIcon img;
	private ImageIcon worker1Img;
	private ImageIcon worker2Img;
	
	public BoxView(int _x, int _y, Image _img, Image w1Img, Image w2Img) {
		super(_x, _y);
		if(_img != null)
			img = new ImageIcon(new ImageIcon(_img).getImage().getScaledInstance(mezomeret, mezomeret, Image.SCALE_DEFAULT));
		if(w1Img != null)
			worker1Img = new ImageIcon(new ImageIcon(w1Img).getImage().getScaledInstance(mezomeret, mezomeret, Image.SCALE_DEFAULT));
		if(w2Img != null)
			worker2Img = new ImageIcon(new ImageIcon(w2Img).getImage().getScaledInstance(mezomeret, mezomeret, Image.SCALE_DEFAULT));
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		img.paintIcon(this, g, x, y);
	}
	
	public void setColor(int i) {
		switch (i) {
		case 1:
			img = worker1Img;
			break;
		case 2:
			img = worker2Img;
			break;
		}
	}
	
}
