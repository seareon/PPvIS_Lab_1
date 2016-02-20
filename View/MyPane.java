package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Vector;
import javax.swing.*;

public class MyPane extends JPanel {
	Vector str = new Vector();
	int caret_x, caret_y; // добавить стили, размер, фамилию шрифта
	
	MyPane() {
		this.setBackground(Color.WHITE);
	}
	
	void setText(byte buf[]) {  // переделывать в char, какая кодировка??
		for(int i=0 ; i<buf.length ; i++) 
			str.addElement(new Symbol((char)buf[i], "SansSerif", Font.PLAIN, 14)); // ASCII
		/*	char c;  // проверить работает ли  // UTF
		int j;
		for(int i=0 ; i<buf.length ; i++) {
			j = i << 1;
			c = (char)(((buf[j] & 0x00FF) << 8) + (buf[j+1] & 0x00FF));
			str.addElement(new Symbol(c, "SansSerif", Font.PLAIN, 14));
		}*/
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(str.isEmpty()) { // test!!!!!!!!!!!!
			Font f = new Font("SansSerif", Font.PLAIN, 14);
			g2.setFont(f);
			FontRenderContext context = g2.getFontRenderContext();
			LineMetrics lm = f.getLineMetrics("ph", context);
			g2.draw(getCaret(lm, 10, 30));
			g2.drawString("test", 12, 30);
		}
		else {
			
		} 
	}
	
	Line2D.Double getCaret(LineMetrics lm, double x, double y) {
		double dy = y+lm.getDescent();
		return new Line2D.Double(x, dy, x, dy-lm.getHeight());
	}
}

class Symbol {
	char ch;	
	Font f;

	int height_char, width, number_line;
	          
	Symbol(char ch, String face_name, int style, int size) {
		this.ch = ch;
		Font f = new Font(face_name, style, size);
	}
	
	void setFace_name(String str) {
		f = new Font(str, f.getStyle(), f.getSize());
	}
	
	void setStyle(int n) {
		f = f.deriveFont(n);
	}
	
	void setSize(float n) {
		f = f.deriveFont(n);
	} 
	
	void setNumLine(int n) {  // надо??
		number_line = n;
	}
}