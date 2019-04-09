package uk.johndorman.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uk.johndorman.Game;
import uk.johndorman.libs.Images;
import uk.johndorman.utils.Button;

public class Menu {

	public Button play, score, options, credits, quit;
	private Font tinytots;

	public Menu(){
		int fillerY = 275;
		play = new Button(440, fillerY, 150, 50).setText("Play");  //Reference.CENTER_X - 100
		score = new Button(410, fillerY += 75, 220, 50).setText("Scores");
		options = new Button(400, fillerY +=75, 220, 50).setText("Options");  //Reference.CENTER_X - 100
		credits = new Button(400, fillerY +=75, 220, 50).setText("Credits"); 
		quit = new Button(440, fillerY +=75, 150, 50).setText("Quit"); //Reference.CENTER_X - 100
		
		tinytots = new Font("04b03", Font.BOLD, 45);
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.background_sky, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.drawImage(Images.background_mountains, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.drawImage(Images.title, (Game.WIDTH/2)-230, 0, null);
		g.drawImage(Images.sub_title, (Game.WIDTH/2)-350, 160, null);


		g.setFont(tinytots);
		
		play.drawButton(g, 0);
		score.drawButton(g, 0);
		options.drawButton(g, 0);
		credits.drawButton(g, 0);
		quit.drawButton(g, 0);
	}
}
