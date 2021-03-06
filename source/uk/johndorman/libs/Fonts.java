package uk.johndorman.libs;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;

public class Fonts {

	private static String fontPath;
	private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
	
	public Fonts(String filePath){
		Fonts.fontPath = Reference.FONT_LOCATION + filePath;
		registerFont();
	}
	
	private void registerFont(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		try{
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void addFont(Fonts font){
		fontList.add(font);
	}
}
