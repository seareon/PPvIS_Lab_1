package View;

import javax.swing.*;

import Model.MyFile;

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
	Font myfont = new Font("Helvetica", Font.PLAIN, 14);
	
	JMenuBar menuBar = new JMenuBar();
	
	JMenu file = new JMenu("File");
	JMenu edit = new JMenu("Edit");
	
//	JMenuItem newFile = new JMenuItem("New");
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
		
	/*	Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension sSize = kit.getScreenSize();
		
		setLocation(sSize.width / 4, sSize.height / 4); */
		setSize(1000, 600);
		setLocationRelativeTo(null);
		
		file.setFont(myfont);
		edit.setFont(myfont);
//		newFile.setFont(myfont);
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
		
//		file.add(newFile);
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
		open.addActionListener(new ActionListener() { // сделать отдельный листнер!!!!!!!!!!!!!
			public void actionPerformed(ActionEvent e) {
				String st = MyFileChooser.OpenFile();
				toolBar.pane.setText("");
				toolBar.pane.setText(st);
			}
		});
		
		save.addActionListener(new ActionListener() { // сделать отдельный листнер!!!!!!!!!!!!!
			public void actionPerformed(ActionEvent e) {
				String str = toolBar.pane.getText();
	        	MyFile.FileSave(str);
			}
		});
		
		saveAs.addActionListener(new ActionListener() { // сделать отдельный листнер!!!!!!!!!!!!!
			public void actionPerformed(ActionEvent e) {
				String str = toolBar.pane.getText();
	        	MyFileChooser.SaveAsFile(str);
			}
		});
	}
}