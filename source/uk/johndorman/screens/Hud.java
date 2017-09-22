package uk.johndorman.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uk.johndorman.entity.Player;

public class Hud {
    
    public static void render(Graphics g, Player player){
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setColor(Color.YELLOW);
        int score = player.getScore();
        g.drawString("Score: " + score, 10, 30);
    }

}
