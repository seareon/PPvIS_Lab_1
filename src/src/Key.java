import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class Key implements KeyListener {
	public void keyPressed(KeyEvent e) {
		System.out.println("1");
		switch(e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				MyPanel.NewLine();
				MyPanel.c.line++;
				break;
			case KeyEvent.VK_RIGHT:
				if (MyPanel.c.locale == 0)
					MyPanel.c.line--;
				else
					MyPanel.c.locale--;
				break;
			default: 
				Graphics2D g2 = (Graphics2D) GUI.mp.getGraphics();
				FontRenderContext context = g2.getFontRenderContext();
				Symbol s = new Symbol(e.getKeyChar(), MyPanel.f);
				Rectangle2D bounds = MyPanel.f.getStringBounds(s.ch, context);
				s.height_char = bounds.getHeight();
				s.width_char = bounds.getWidth();
				if (MyPanel.text.isEmpty()) {
					MyPanel.NewLine();
					Text t = MyPanel.text.get(0);
					t.hight = -bounds.getY();
					t.add(s); 
				}
				else {
					Text t = MyPanel.text.get(MyPanel.text.size() - 1);
					if (MyPanel.text.size() == 1)
						t.add(s);
					else {
						Text before_t = MyPanel.text.get(MyPanel.text.size() - 2);
						t.hight = before_t.hight -bounds.getY();
						t.add(s); 
					}
				}
				MyPanel.c.locale++;
		}
		GUI.mp.Repaint();
	}
	
	public void keyReleased(KeyEvent keyEvent) {
		System.out.println("1");
    }

    public void keyTyped(KeyEvent keyEvent) {
    	System.out.println("1");
    }
}
