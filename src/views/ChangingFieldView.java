package views;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ChangingFieldView extends FieldView{
	ImageIcon secondary;
	
	public ChangingFieldView(int _x, int _y, Image _img, Image _img2) {
		super(_x, _y, _img);
		if(_img2 != null)
			secondary = new ImageIcon(new ImageIcon(_img2).getImage().getScaledInstance(mezomeret, mezomeret, Image.SCALE_DEFAULT));
	}
	
	public void switchImages() {
		ImageIcon temp = img;
		img = secondary;
		secondary = temp;
		repaint();
		revalidate();
	}

}
