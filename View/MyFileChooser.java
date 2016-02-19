package View;

import java.io.File;
import javax.swing.JFileChooser;
import Model.MyFile;

public class MyFileChooser {
	
	public static String OpenFile(){
		int ret;
		JFileChooser openfile = new JFileChooser();
		ret = openfile.showDialog(null, "Open");
		if(ret == JFileChooser.APPROVE_OPTION) {
			File file = openfile.getSelectedFile();
			String st = MyFile.FileOpen(file.getPath());
			return st;
			
		}
		return null;
	}
	
	public static void SaveAsFile (String str) {
		int ret;
		JFileChooser saveAsFile = new JFileChooser();
		ret = saveAsFile.showDialog(null, "Save");
		if(ret == JFileChooser.APPROVE_OPTION) {
			File file = saveAsFile.getSelectedFile();
			MyFile.FileSaveAs(file.getPath(), str);
		}
	}
}
