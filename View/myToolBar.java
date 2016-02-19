package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;

import Model.MyFile;
import View.Combo;

class myToolBar extends JPanel implements ActionListener {
	JToolBar jtb; 
	
	String [] strSize = {"10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36"};
	String [] strFont = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	
	JButton butBold, butItalic, butUnder;
	boolean bool_bo, bool_it, bool_un;
	
	int size = 14;
	
	public Area pane = new Area("SANS_SERIF", Font.PLAIN, 14);
	
	myToolBar() {
		super(new BorderLayout());
		jtb = new JToolBar();
		addButtons(jtb);
		setPreferredSize(new Dimension(450, 130));
		jtb.setFloatable(false);
		jtb.setRollover(true);
		add(jtb, BorderLayout.NORTH);
		
		add(new JScrollPane(pane), BorderLayout.CENTER);
		
		pane.setFocusable(true);
		
		bool_bo = bool_it = bool_un = false;
	}
	
	protected void addButtons(JToolBar jtb) {
		JButton button = null;
		
/*		button = makeNavigationButton("new.png", "NewFile", "Create new file", "New", this);		
		jtb.add(button); */
		
		button = makeNavigationButton("open.png", "OpenFile", "Open file", "Open", this);
		jtb.add(button);
		
		button = makeNavigationButton("save.png", "SaveFile", "Save file", "Save", this);
		jtb.add(button);
		
		button = makeNavigationButton("saveAs.png", "SaveASFile", "Save as file", "Save as", this);
		jtb.add(button);
		
		jtb.addSeparator();
		
		button = makeNavigationButton("cut.png", "Cut", "Cut the selected part of the text", "Cut", this);		
		jtb.add(button); 
		
		button = makeNavigationButton("copy.png", "Copy", "Copy the selected part of the text", "Copy", this);		
		jtb.add(button);
		
		button = makeNavigationButton("paste.png", "Paste", "Paste the copied text", "Paste", this);		
		jtb.add(button);
		
		button = makeNavigationButton("delete.png", "Delete", "Delete the selected part of the text", "Delete", this);		
		jtb.add(button);
		
		jtb.addSeparator();

		Combo cs_size = new Combo(strSize, 50, 44);
		cs_size.setActionCommand("ComboSize");
		cs_size.addActionListener(this);
		jtb.add(cs_size);
		
		jtb.addSeparator();
		
		Combo cs_font = new Combo(strFont, 220, 44);
		cs_font.setActionCommand("ComboFont");
		cs_font.addActionListener(this);
		jtb.add(cs_font);
		
		jtb.addSeparator();
		
		butBold = makeNavigationButton("bold.png", "Bold", "Makes highlighted and the following text in bold", "Bold",
											new StyledEditorKit.BoldAction());
		jtb.add(butBold);
		
		butItalic = makeNavigationButton("Italic.png", "Italic", "Makes highlighted and the following text in italic", 
											"Italic", new StyledEditorKit.ItalicAction());
		jtb.add(butItalic);
		
/*		butUnder = makeNavigationButton("underline.png", "Underline", "Makes highlighted and the following text in underline", 
				"Underline"); */
	}
	
	protected JButton makeNavigationButton(String ImageName, String ActionCommand,
			   							   String toolTipText, String altText, ActionListener action) {
		
		String imgLocation = "d:\\work\\работа\\JAVA\\workspace_asus\\Lab_1\\src\\View\\" + ImageName;
		ImageIcon img = new ImageIcon(imgLocation);
		img.setDescription(altText);
		
		JButton button = new JButton();
		button.setActionCommand(ActionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(action);
		                 
	    button.setIcon(img);
	    
		return button;
	}
	
	public void actionPerformed(ActionEvent e) {
 /*       if (e.getActionCommand().equals("NewFile"))
            System.out.println("first buton pressed"); */
        
        if(e.getActionCommand().equals("OpenFile")) { // сделать отдельный листнер!!!!!!!!!!!!!
        	String st = MyFileChooser.OpenFile();
			pane.setText("");
			pane.setText(st);
        }
        
        if(e.getActionCommand().equals("SaveFile")) { // сделать отдельный листнер!!!!!!!!!!!!!
        	String str = pane.getText();
        	MyFile.FileSave(str);
        }
        
        if(e.getActionCommand().equals("SaveASFile")) {// сделать отдельный листнер!!!!!!!!!!!!!
        	String str = pane.getText();
        	MyFileChooser.SaveAsFile(str);
        }
        
        if(e.getActionCommand().equals("ComboSize")) {
        	JComboBox box = (JComboBox)e.getSource();
      //  	System.out.println((String)box.getSelectedItem());
        	try {
        		Integer num = new Integer((String)box.getSelectedItem());
        		pane.setSize(num);
        	} catch (NumberFormatException ee) {  
                System.err.println("Неверный формат строки!");
        	}
        }
        
        if(e.getActionCommand().equals("ComboFont")) {
        	JComboBox box = (JComboBox)e.getSource();
        	try {
        	//	Integer num = new Integer();
        		pane.setStyle((String)box.getSelectedItem());
        	} catch (NumberFormatException ee) {  
                System.err.println("Неверный формат строки!");
        	}
        }
        
        if(e.getActionCommand().equals("Bold")) {
        	pane.setWriting(Font.BOLD);
        }
        
        if(e.getActionCommand().equals("Italic")) {
        	pane.setWriting(Font.ITALIC);
        }
	} 
}	
