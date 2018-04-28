package views;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public abstract class ViewBase extends JComponent{
	public int x;
	public int y;
	ImageIcon img;
	
	public ViewBase(int _x, int _y, Image _img) {
		img = new ImageIcon(new ImageIcon(_img).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		img.paintIcon(this, g, x, y);
		
	}
}
