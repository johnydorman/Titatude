package uk.johndorman;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import uk.johndorman.libs.Reference;

public class Window {

	private static JFrame frame;
	
	public static void initWindow(String title){
		frame = new JFrame(title);
	}
	
	public static void addGame(Game game){
		frame.add(game);
	}
	
	public static void createtWindow(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage(Reference.RESOURCE_LOCATION + "icon.png");
		Image cursor = toolkit.getImage(Reference.RESOURCE_LOCATION + "sword3.gif");
		frame.setIconImage(icon);
		frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor"));
		frame.setSize(Game.WIDTH, Game.HEIGHT);
		
		frame.addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						Game.exit();
					}
				}
		);
		
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		
	}
	
	public static void setTitle(String title){
		frame.setTitle(title);
	}
}
