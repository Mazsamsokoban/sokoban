package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import models.Friction;

public abstract class ViewBase extends JComponent{
	public int x;
	public int y;
	public static final int mezomeret = 100;
	
	public ViewBase(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	public Dimension getPos() {
		return new Dimension(x,y);
	}
	
	public void setPos(Dimension pos) {
		x = pos.width;
		y = pos.height;
	}
	@Override
	protected void paintComponent(Graphics g) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
		super.paintComponent(g);
		
	}

	
	
}
