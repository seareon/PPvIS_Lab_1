import javax.swing.JFrame;

public class GUI {
	static JFrame jf = new JFrame();
	static MyPanel mp = new MyPanel();
	
	public static void createGUI() {
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(mp);
        jf.setFocusable(true);
        jf.addKeyListener(new Key());
        jf.setSize(800,600);
        jf.setVisible(true);
    }

    public static void main(String[] args){
        createGUI();
    }
}
