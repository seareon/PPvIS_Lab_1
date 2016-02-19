package View;

import java.awt.Font;
import javax.swing.JTextPane;

class Area extends JTextPane {
	String style;
	int writing, size;
	
	Area(String str, int wr, int s) {
		style = str;
		writing = wr;
		size = s;
		this.setText(" ");
		this.setFont(new Font(style, writing, size));
	}
	
	void setSize(int n) {
		size = n;
		this.setFont(new Font(style, writing, size));
	}
	
	void setWriting(int n) { // допилить
		writing = n;
	}
	
	void setStyle(String str) { // допилить
		style = str;
	}
}
