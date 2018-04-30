package views;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class FieldView extends ViewBase{
	protected ImageIcon img;
	protected ImageIcon material;
	
	public FieldView(int _x, int _y, Image _img) {
		super(_x, _y);
		material = null;
		if(_img != null)
			img = new ImageIcon(new ImageIcon(_img).getImage().getScaledInstance(mezomeret, mezomeret, Image.SCALE_DEFAULT));
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		img.paintIcon(this, g, x, y);
		if(material != null)
			img.paintIcon(this, g, x, y);
	}
	
	public void addMaterial(Image mat) {
		material = new ImageIcon(new ImageIcon(mat).getImage().getScaledInstance(mezomeret, mezomeret, Image.SCALE_DEFAULT));
		repaint();
		revalidate();
	}
}
