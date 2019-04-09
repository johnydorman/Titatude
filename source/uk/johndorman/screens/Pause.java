package uk.johndorman.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uk.johndorman.Game;
import uk.johndorman.libs.Images;
import uk.johndorman.utils.Button;

public class Pause {

	public Button game, menu, quit;
	
	public Pause(){
		int fillerY = 275;
		game = new Button(400, fillerY +=75, 350, 50).setText("Return");
		menu = new Button(320, fillerY +=75, 450, 50).setText("Back to Menu"); //Reference.CENTER_X - 100
		quit = new Button(440, fillerY +=75, 150, 50).setText("Quit");
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.background_sky, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.drawImage(Images.background_mountains, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.drawImage(Images.pause, (Game.WIDTH/2)-240, 0, null);
		g.drawImage(Images.pause_sub_title, (Game.WIDTH/2)-370, 160, null);
		
		Font tinytots = new Font("04b03", Font.BOLD, 45);
		g.setFont(tinytots);

		game.drawButton(g, 0);
		menu.drawButton(g, 0);
		quit.drawButton(g, 0);
	}
	
}
