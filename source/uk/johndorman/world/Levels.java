package uk.johndorman.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import uk.johndorman.Game;
import uk.johndorman.libs.Images;

public class Levels {
	
	private static float xOrigin =0;
	
	
	public static void renderBackground(int playerLevelId, Graphics g) {
		switch(playerLevelId){
			case 1:
				tileAcrossX(g, Images.background_sky, (int)xOrigin, 0, 2);
				tileAcrossX(g, Images.background_mountains, 0, 0, 2);
				tileAcrossX(g, Images.background_woods, 0, Game.HEIGHT/2, 2);
				
				if(xOrigin > -Images.background_sky.getWidth())
					xOrigin -= 0.025f;
				else
					xOrigin = 0;
				
				break;
			case 2:
				break;
			default:
				g.setColor(Color.RED);
				g.drawString("UNKOWN LEVEL " + playerLevelId, 150, 150);
				break;
		}
	}
	
	private static void tileAcrossX(Graphics g, BufferedImage image, int currentX, int currentY, int scale) {
		while(currentX < Game.WIDTH) {
			g.drawImage(image, currentX, currentY, image.getWidth() * scale, image.getHeight() * scale, null);
			currentX += image.getWidth() * scale;
		}
	}

}
