import java.util.ArrayList;

public class Text {
	ArrayList<Symbol> text = new ArrayList<Symbol>();
	double hight;
//	int n = 0;
	
	void add(Symbol s) {
		text.add(s);
	}
	
	Symbol getSymbol(int number) {
		return text.get(number);
	}
	
	int getSize() {
		return text.size();
	}
}
