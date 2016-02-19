package Model;

import java.io.*;
import java.util.*;

public class MyFile {
	static private String szCurrentFilename = null;
	static private byte buf[] = null;
	
	public static String FileOpen(String str) {
		szCurrentFilename = str;
		FileInputStream is = null;
		
		try {
			is = new FileInputStream(szCurrentFilename);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		try {
			buf = new byte[is.available()]; 
			is.read(buf); // дополнить проверкой на все ли байты прочтены и если нет, то дочитать в цикле
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		String st = new String(buf);
		
		try {
			is.close();
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		
		return st;
	}
	
	public static void FileSave(String str) {
		FileOutputStream os = null;
		
		buf = str.getBytes();
		
		try { // отдельный метод???
			os = new FileOutputStream(szCurrentFilename);
			os.write(buf);
			os.close();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void FileSaveAs(String str_path, String str_text) {
		FileOutputStream os = null;
		 
		buf = str_text.getBytes();
		
		try { // отдельный метод???
			os = new FileOutputStream(str_path);
			os.write(buf);
			os.close();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
