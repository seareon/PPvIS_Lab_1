package View;

import java.awt.Dimension;
import javax.swing.JComboBox;

class Combo extends JComboBox {
	
	Combo(String [] s, int x, int y) {
		super(s);
		this.setMaximumSize(new Dimension(x, y));
		this.setEditable(true);
		this.addActionListener(this);
	}
}