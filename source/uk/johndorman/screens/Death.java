package uk.johndorman.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uk.johndorman.Game;
import uk.johndorman.libs.Images;
import uk.johndorman.utils.Button;

public class Death {

	public Button total, game, menu, quit;
	
	public Death(){
		int fillerY = 200;
		int one = Game.getInstance().getPlayerScore();
		
		total = new Button(300, fillerY += 75, 450, 50).setText("You scored: "+ one);
		
		game = new Button(390, fillerY +=150, 350, 50).setText("Try Again");
		menu = new Button(340, fillerY +=75, 450, 50).setText("Back to Menu"); //Reference.CENTER_X - 100
		quit = new Button(460, fillerY +=75, 150, 50).setText("Quit");

	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.background, 0, 0, null);
		g.drawImage(Images.gameOver, (Game.WIDTH/2)-230, 0, null);
		g.drawImage(Images.gameOver_sub_title, (Game.WIDTH/2)-350, 160, null);
		
		Font tinytots = new Font("04b03", Font.BOLD, 45);
		g.setFont(tinytots);

		total.drawButton(g, 0);
		
		game.drawButton(g, 0);
		menu.drawButton(g, 0);
		quit.drawButton(g, 0);
	}
	
}
