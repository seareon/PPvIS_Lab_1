package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MyFrame {
	public static void main(String args[]) {
		Notebook nt =  new Notebook();
		nt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nt.show();
	}	
}

class Notebook extends JFrame {
	Font myfont = new Font("Verdana", Font.PLAIN, 14);
	
	JMenuBar menuBar = new JMenuBar();
	
	JMenu file = new JMenu("File");
	JMenu edit = new JMenu("Edit");
	
	JMenuItem newFile = new JMenuItem("New");
	JMenuItem open = new JMenuItem("Open");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem saveAs = new JMenuItem("Save As...");
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem copy = new JMenuItem("Copy");
	JMenuItem paste = new JMenuItem("Paste");
	JMenuItem cut = new JMenuItem("Cut");
	JMenuItem delete = new JMenuItem("Delete");
	
	JToolBar jtb = new JToolBar();
	
	Notebook() {
		super("My Notebook");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension sSize = kit.getScreenSize();
		
		setLocation(sSize.width / 4, sSize.height / 4);
		setSize(1000, 600);
		
		file.setFont(myfont);
		edit.setFont(myfont);
		newFile.setFont(myfont);
		open.setFont(myfont);
		save.setFont(myfont);
		saveAs.setFont(myfont);
		exit.setFont(myfont);
		copy.setFont(myfont);
		paste.setFont(myfont);
		cut.setFont(myfont);
		delete.setFont(myfont); 
		
		menuBar.add(file);
		menuBar.add(edit);
		
		file.add(newFile);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(exit);
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
		
		setJMenuBar(menuBar);
		
		myToolBar toolBar = new myToolBar();
		this.add(toolBar);
		
		exit.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
                System.exit(0);             
            }           
        });
	}
}

class myToolBar extends JPanel implements ActionListener {
	JToolBar jtb; 
	String [] strSize = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36"};
	
	myToolBar() {
		super(new BorderLayout());
		jtb = new JToolBar();
		addButtons(jtb);
		setPreferredSize(new Dimension(450, 130));
		jtb.setFloatable(false);
		jtb.setRollover(true);
		add(jtb, BorderLayout.PAGE_START);
	}
	
	protected void addButtons(JToolBar jtb) {
		JButton button = null;
		
		button = makeNavigationButton("new.png", "NewFile", "Create new file", "New");		
		jtb.add(button);
		
		button = makeNavigationButton("open.png", "OpenFile", "Open file", "Open");
		jtb.add(button);
		
		button = makeNavigationButton("save.png", "SaveFile", "Save file", "Save");
		jtb.add(button);
		
		button = makeNavigationButton("saveAs.png", "SaveASFile", "Save as file", "Save as");
		jtb.add(button);
		
		jtb.addSeparator();
		
		button = makeNavigationButton("cut.png", "Cut", "Cut the selected part of the text", "Cut");		
		jtb.add(button); 
		
		button = makeNavigationButton("copy.png", "Copy", "Copy the selected part of the text", "Copy");		
		jtb.add(button);
		
		button = makeNavigationButton("paste.png", "Paste", "Paste the copied text", "Paste");		
		jtb.add(button);
		
		button = makeNavigationButton("delete.png", "Delete", "Delete the selected part of the text", "Delete");		
		jtb.add(button);
		
		jtb.addSeparator();

		ComboSize cs = new ComboSize(strSize, 50, 44); 
		jtb.add(cs);
	}
	
	protected JButton makeNavigationButton(String ImageName, String ActionCommand,
			   							   String toolTipText, String altText) {
		
		String imgLocation = "d:\\work\\работа\\JAVA\\workspace_asus\\Lab_1\\src\\View\\" + ImageName;
		ImageIcon img = new ImageIcon(imgLocation);
		img.setDescription(altText);
		
		JButton button = new JButton();
		button.setActionCommand(ActionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);
		                 
	    button.setIcon(img);
	    
		return button;
	}

	public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NewFile"))
            System.out.println("first buton pressed");
        
        if (e.getActionCommand().equals("OpenFile"))
            System.out.println("second buton pressed");
        
        if (e.getActionCommand().equals("SaveFile"))
            System.out.println("third buton pressed");
        
        if (e.getActionCommand().equals("SaveASFile"))
            System.out.println("fourth buton pressed");
	}
	
	class ComboSize extends JComboBox {
		
		ComboSize(String [] s, int x, int y) {
			super(s);
			this.setMaximumSize(new Dimension(x, y));
			this.setEditable(true);
			this.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e) {
			System.out.println(e);
		}
	}
}