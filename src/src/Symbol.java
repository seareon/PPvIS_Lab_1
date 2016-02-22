import java.awt.Font;

public class Symbol {
	public String ch = "";	
	public Font f;

	double height_char, width_char;
	int number_line;
	          
	public Symbol(char ch, Font f) {
		this.ch += ch;
		this.f = f;
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
	
	String getSymbol() {
		return ch;
	}
}
