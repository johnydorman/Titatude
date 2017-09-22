package uk.johndorman.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import uk.johndorman.input.MouseInput;

@SuppressWarnings("serial")
public class Button extends Rectangle {

	private String text;	
	
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	public Button setText(String text){
		this.text = text;
		return this;
	}
	
	public void drawButton(Graphics g, int offset){
		int xx = x + offset;
		int yy = y + 38;
		Color tempColor = new Color(76, 205, 217);  // 202, 165, 205 pink
		
		if(MouseInput.MOUSE.intersects(this)){
			g.setColor(tempColor);
		} else {
			g.setColor(Color.WHITE);
		}
		
		if(MouseInput.pressed && MouseInput.MOUSE.intersects(this)){
			g.setColor(Color.WHITE);
			//g.fillRect(x, y, width, height);
			g.setColor(Color.WHITE);
			g.drawString(text, xx, yy);
		}
			//g.drawRect(x, y, width, height);
			g.drawString(text, xx, yy);
	}

}
