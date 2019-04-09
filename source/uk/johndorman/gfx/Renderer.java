package uk.johndorman.gfx;

import java.awt.Color;
import java.awt.Graphics;

import uk.johndorman.Game;
import uk.johndorman.libs.Images;
import uk.johndorman.world.Levels;


public class Renderer {

	
	public void renderBackground(Graphics g){
		switch(Game.state){
		case GAME:
			Levels.renderBackground(Game.getInstance().getPlayerLevelId(), g);
			break;
		case MENU:
			Game.getInstance().getMenu().render(g);
			break;
		case OPTIONS:
			Game.getInstance().getOptions().render(g);
			break;
		case CREDITS:
			Game.getInstance().getCredits().render(g);
			break;
		case PAUSE:
			Game.getInstance().getPause().render(g);
			break;
		case SCORE:
			Game.getInstance().getScore().render(g);
			break;
		case DEATH:
			Game.getInstance().getDeath().render(g);
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKOWN GAMESTATE", 150, 150);
			break;
		}
	}
	
	public void renderForeBackground(Graphics g){
		switch(Game.state){
		case GAME:
			g.drawImage(Images.backgroundHouse, 64, 448+64, null);
			g.drawImage(Images.backgroundHouse2, 672, 448+32, null);
			g.drawImage(Images.backgroundHouse, 1696, 448+64, null);
			g.drawImage(Images.backgroundHouse3, 2880, 448+64, null);
			
			Game.getInstance().getController().render2(g);
			
			//g.drawImage(Images.sign, 600, 448+320, null);
			//for(int i = 0; i < 12; i++)
			//	g.drawImage(Images.fence, (3240 + (i*64)), 448+262, null);
			//g.drawImage(Images.sign, 3200, 448+256, null);
			
			break;
		case MENU:
		case OPTIONS:
		case CREDITS:
		case PAUSE:
		case SCORE:
		case DEATH:
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKOWN GAMESTATE", 150, 150);
			break;
		
		}

	}
	
	public void renderForeground(Graphics g){
		switch(Game.state){
		case GAME:
			Game.getInstance().getController().renderForeground(g);
			break;
		case MENU:
		case OPTIONS:
		case CREDITS:
		case PAUSE:
		case SCORE:
		case DEATH:
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKOWN GAMESTATE", 150, 150);
			break;
		
		} 
	} 

}
