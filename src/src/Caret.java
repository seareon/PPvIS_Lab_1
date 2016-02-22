import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Caret {
int line, locale;
	
	Caret(int li, int lo) {
		line = li;
		locale = lo;
	}
	
	Line2D.Double getCaret(LineMetrics lm, double x, double y) {
		double dy = y+lm.getDescent();
		return new Line2D.Double(x, dy, x, dy-lm.getHeight());
	}
	
	static Line2D.Double getCaretDefault(Rectangle2D r2) {
		return new Line2D.Double(10, r2.getHeight(), 10 + r2.getWidth(), r2.getHeight());
	}
}
