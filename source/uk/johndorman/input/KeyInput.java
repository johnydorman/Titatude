package uk.johndorman.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import uk.johndorman.Game;
import uk.johndorman.core.CoreObject;
import uk.johndorman.entity.Player;
import uk.johndorman.enums.Direction;
import uk.johndorman.enums.GameState;
import uk.johndorman.libs.Identities;

public class KeyInput extends KeyAdapter{

	private Player player;

	
	private boolean[] keyDown = new boolean[2];
	private boolean returnSelected = true;
	private boolean menuSelected = false;
	private boolean quitSelected = false;
	
	public KeyInput(){
		for(CoreObject obj : Game.getInstance().getController().getObjects()){
			if(obj.getId() == Identities.PLAYER)
				player = (Player) obj;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		switch(Game.state){
		case GAME:
			
			if((key == KeyEvent.VK_SPACE || key == KeyEvent.VK_W) && !player.isJumping()){
				player.setVelY(-18);
				player.setJumping(true);
				
			}
			
			if(key == KeyEvent.VK_A){
				player.setVelX(-5);
				player.setDirection(Direction.LEFT);		
				player.setMoving(true);
				keyDown[0] = true;	
			}
			if(key == KeyEvent.VK_D){
				player.setVelX(5);
				player.setDirection(Direction.RIGHT);
				player.setMoving(true);
				keyDown[1] = true;
			}
			
			
			if(key == KeyEvent.VK_F){
				System.out.println(player.getX());
				System.out.println(player.getY());
			}
			
			if(key == KeyEvent.VK_ESCAPE){
				Game.state = GameState.PAUSE;
			}
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			
			if(key == KeyEvent.VK_ESCAPE){
				Game.state = GameState.GAME;
			}
			if(key == KeyEvent.VK_DOWN){
				if(returnSelected){
					menuSelected = true; 
					System.out.println("menu");
					returnSelected = false;
				}
				else if(menuSelected){
					quitSelected = true;
					System.out.println("quit");
					menuSelected = false;
				}
				else if(quitSelected){
					returnSelected = true;
					quitSelected = false;
				}
			}
			if(key == KeyEvent.VK_UP){
				if(returnSelected)
					quitSelected = true;
				else if(menuSelected)
					returnSelected = true;
				else if(quitSelected)
					menuSelected = true;
			}
			if(key == KeyEvent.VK_ENTER){
				if(returnSelected)
					Game.state = GameState.GAME;
				else if(menuSelected)
					Game.state = GameState.MENU;
				else if(quitSelected)
					Game.exit();
			}
			break;
		default:
			break;
		
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		
		switch(Game.state){
		case GAME:
			if(key == KeyEvent.VK_W)
				if(player.getVelY() < 0)
					player.setVelY(0);
			if(key == KeyEvent.VK_A){
				keyDown[0] = false;
				player.setMoving(false);
			}
			if(key == KeyEvent.VK_D){
				keyDown[1] = false;
				player.setMoving(false);
			}
			if(keyDown[0] && !keyDown[1]){
				player.setVelX(-5);
				player.setMoving(true);
				player.setDirection(Direction.LEFT);
			}
			if(!keyDown[0] && keyDown[1]){
				player.setVelX(5);
				player.setMoving(true);
				player.setDirection(Direction.RIGHT);
			}
			if(!keyDown[0] && !keyDown[1]){
				player.setVelX(0);
				player.setMoving(false);
			}
			if(key == KeyEvent.VK_SHIFT){
			}
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}
	}
}
