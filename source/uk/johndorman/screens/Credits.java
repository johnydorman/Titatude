package uk.johndorman.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uk.johndorman.Game;
import uk.johndorman.libs.Images;
import uk.johndorman.utils.Button;

public class Credits {

	public Button first, second, third, fourth, back;

	public Credits(){
		int fillerY = 150;
		
		first = new Button(180, fillerY +=75, 0, 50).setText("Design & Programming");
		second = new Button(300, fillerY +=75, 0, 50).setText("John Dorman");
		third = new Button(200, fillerY +=75, 0, 50).setText("Artwork & Animation");
		fourth = new Button(300, fillerY +=75, 0, 50).setText("John Dorman");
		
		back = new Button(0, fillerY +=125, 150, 50).setText("Back"); //Reference.CENTER_X - 100
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.background_sky, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.drawImage(Images.background_mountains, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.drawImage(Images.credits, (Game.WIDTH/2)-230, 0, null);
		g.drawImage(Images.credits_sub_title, (Game.WIDTH/2)-385, 150, null);
		
		
		Font tinytots = new Font("04b03", Font.BOLD, 45);
		g.setFont(tinytots);
		
		first.drawButton(g, 30);
		second.drawButton(g, 30);
		third.drawButton(g, 30);
		fourth.drawButton(g, 30);
		back.drawButton(g, 30);
	}
}

