import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
//	public static Text t = new Text();
//	int caret_x, caret_y;
	
	public static ArrayList<Text> text = new ArrayList<Text>();
	static Font f;
	int style, size;
	Timer m_timer;
	boolean view_caret = true;
	static Caret c = new Caret(1, 0);
	
	TimerTask tt = new TimerTask() {
		public void run() {
			repaint();
		}
	};
	
/*	void RepainMyPanel() {
		view_caret = false;
		this.repaint();
	} */
	
	MyPanel() {
		this.setBackground(Color.WHITE);
		style = Font.PLAIN;
		size = 14;
		f = new Font("SansSerif", style, size);
		m_timer = new Timer();
		m_timer.schedule(tt, 700, 700);
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if(text.isEmpty()) {
			if(view_caret) {
				g2.setFont(f);
				FontRenderContext context = g2.getFontRenderContext();
				g2.draw(Caret.getCaretDefault(f.getStringBounds("p", context)));
				view_caret = false;
			}
			else {
				view_caret = true;
			}
		}
		else {
			int width;
			for (int i = 0, j; i<text.size(); i++) {
				width = 10;
				Text s = text.get(i); 
				for(j = 0; j < s.getSize(); j++) {
					Symbol ss = s.getSymbol(j); 
					g2.drawString(ss.getSymbol(), width, (int)s.hight);
					width += ss.width_char;
				}
			}
		}
	}
	
	void setSize(int n) {
		size = n;
	}
	
	void setStyle(int n) {
		style = n;
	}
	
	void setFont(String str) {
		f = new Font(str, style, size);
	}
	
	void Repaint() {
		this.repaint();
	}
	
	public static void NewLine() {
		text.add(new Text());
	}
}
