package views;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import models.Friction;

public class FieldView extends ViewBase{
	protected ImageIcon img;
	protected ImageIcon material;
	private Friction materialFriction;
	
	public FieldView(int _x, int _y, Image _img) {
		super(_x, _y);
		materialFriction = null;
		material = null;
		if(_img != null)
			img = new ImageIcon(new ImageIcon(_img).getImage().getScaledInstance(mezomeret, mezomeret, Image.SCALE_DEFAULT));
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		img.paintIcon(this, g, x, y);
		if(material != null)
			material.paintIcon(this, g, x, y);
	}
	
	public void addMaterial(Image mat) {
		material = new ImageIcon(new ImageIcon(mat).getImage().getScaledInstance(mezomeret, mezomeret, Image.SCALE_DEFAULT));
		repaint();
		revalidate();
	}
	
	/**
	 * frissít
	 */
	public void updateField(boolean on, Friction friction) {
		if(friction == null || materialFriction == friction) return;
		switch (friction) {
		case Honey:
			try {
				Image im = ImageIO.read(new File("honey.jpg"));
				addMaterial(im);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case Oil:
			try {
				Image im = ImageIO.read(new File("oil.png"));
				addMaterial(im);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case Normal:
			material = null;
			repaint();
			revalidate();
			break;
			
		}
		
	}
}
