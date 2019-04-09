package uk.johndorman.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import uk.johndorman.Game;
import uk.johndorman.enums.GameState;
import uk.johndorman.libs.Audio;
import uk.johndorman.screens.Credits;
import uk.johndorman.screens.Death;
import uk.johndorman.screens.Menu;
import uk.johndorman.screens.Options;
import uk.johndorman.screens.Pause;
import uk.johndorman.screens.Score;
import uk.johndorman.utils.AudioPlayer;

public class MouseInput extends MouseAdapter{

	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle(1,1,1,1);
	
	
	private Menu menu = Game.getInstance().getMenu();
	private Score score = Game.getInstance().getScore();
	private Credits credits = Game.getInstance().getCredits();
	private Options options = Game.getInstance().getOptions();
	private Death death = Game.getInstance().getDeath();
	private Pause pause = Game.getInstance().getPause();
	
	public static boolean pressed = false;
	public boolean playing = true;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
		
		if(mouse == MouseEvent.BUTTON1){
			
			switch(Game.state){
			case GAME:
				break;
			case MENU:
				if(rect.intersects(menu.play)){
					AudioPlayer.getMusic(Audio.MUSIC_TITLE).stop();
					Game.getInstance().currentLevel.load();
					Game.state = GameState.GAME;
				}
				if(rect.intersects(menu.score)){
					Game.state = GameState.SCORE;
				}
				if(rect.intersects(menu.options)){
					Game.state = GameState.OPTIONS;
				}
				if(rect.intersects(menu.credits)){
					Game.state = GameState.CREDITS;
				}
				if(rect.intersects(menu.quit))
					Game.exit();
				break;
			case SCORE:
				if(rect.intersects(score.back)){
					Game.state = GameState.MENU;
				}
				break;
			case OPTIONS:
				if(rect.intersects(options.back)){
					Game.state = GameState.MENU;
				}
				if(rect.intersects(options.music)){
					if (playing){
						AudioPlayer.getMusic(Audio.MUSIC_TITLE).stop();
						playing = false;
					}

					else {
						AudioPlayer.getMusic(Audio.MUSIC_TITLE).play();
						playing = true;
					}

				}
				break;
			case CREDITS:
				if(rect.intersects(credits.back)){
					Game.state = GameState.MENU;
				}
				break;
			case PAUSE:
				if(rect.intersects(pause.game)){
					Game.state = GameState.GAME;
				}
				if(rect.intersects(pause.menu)){
					Game.state = GameState.MENU;
				}
				if(rect.intersects(pause.quit)){
					Game.exit();
				}
				
				break;
			case DEATH:
				if(rect.intersects(death.game)){
					Game.state = GameState.GAME;
				}
				if(rect.intersects(death.menu)){
					Game.state = GameState.MENU;
				}
				if(rect.intersects(death.quit))
					Game.exit();
				break;
			default:
				break;
			
			}
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {

		pressed = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		pressed = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
	}
}
