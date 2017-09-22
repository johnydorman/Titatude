package uk.johndorman.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uk.johndorman.Game;
import uk.johndorman.libs.Images;
import uk.johndorman.utils.Button;

public class Score {
	public Button music, effects, holder, holder2, holder3, back;

	public Score(){
		int fillerY = 200;


		holder = new Button(0, fillerY +=75, 0, 50).setText("Coming Soon...");

		back = new Button(0, fillerY +=75, 150, 50).setText("Back"); //Reference.CENTER_X - 100
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.background, 0, 0, null);
		g.drawImage(Images.options, (Game.WIDTH/2)-230, 0, null);
		
		Font tinytots = new Font("04b03", Font.BOLD, 45);
		g.setFont(tinytots);
		
		holder.drawButton(g, 30);

		back.drawButton(g, 30);
	}
}