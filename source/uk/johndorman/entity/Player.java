package uk.johndorman.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import uk.johndorman.Game;
import uk.johndorman.core.CoreObject;
import uk.johndorman.enums.Direction;
import uk.johndorman.enums.GameState;
import uk.johndorman.gfx.Animation;
import uk.johndorman.gfx.Textures;
import uk.johndorman.objects.Block;

public class Player extends CoreObject {
	
	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
	
	private float gravity = 0.98f;
	private boolean falling = true;
	private boolean jumping = false;
	
	private boolean moving = false;
	private Animation animeRight;
	private Animation animeLeft;
	
	private Direction direction = Direction.RIGHT;
	public int score;
	private int life;

	
	public Player(float x, float y, int id, Textures tex, boolean colide, int life, int score) {
		super(x, y, id, tex, colide);
		this.setSize(32, 70);
		animeRight = new Animation(3, tex.playerRight);
		animeLeft = new Animation (3, tex.playerLeft);
		this.life = life;
		this.score = score;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		fall();
		checkCollision();
		if(moving){
			if(velX > 0)
				animeRight.runAnimation();
			else if(velX < 0)
				animeLeft.runAnimation();
		if(velY != 0)
		{
			jumping = true;
			
			if(velX > 0){
				velX = 3;
			}
			else if(velX < 0){
				velX = -3;			
			}
		}
		else
			jumping = false;
			if(velX > 0){
				velX = 5;
			}
			else if(velX < 0){
				velX = -5;				
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if(!moving){
			if(direction == Direction.RIGHT)
				g.drawImage(tex.playerStandingRight, (int) x, (int) y, null);
			else if(direction == Direction.LEFT)
				g.drawImage(tex.playerStandingLeft, (int) x, (int) y, null);
		}else {
			if(direction == Direction.RIGHT)
				animeRight.drawAnimation(g, x, y);
			else if(direction == Direction.LEFT)
				animeLeft.drawAnimation(g, x, y);
		}
	}
	
	private void checkCollision(){
		if(score < (int) (x - 300))
			score = (int) (x - 300);
		if(score < 0)
			score = 0;
		
		Game.getInstance().setPlayerScore(score);
		Game.getInstance().setPlayerLife(life);
		
		for(CoreObject obj : gameObjects){
			if(obj instanceof Block){
					if(getBottomBounds().intersects(obj.getTopBounds())){
						velY = 0;
						y = obj.getY() - height;
						jumping = false;
					}
					if(getTopBounds().intersects(obj.getBottomBounds())){
						fall();
						y = obj.getY() + obj.getHeight();
					}
					if(getRightBounds().intersects(obj.getLeftBounds())){
						velX = 0;
						x = obj.getX() - width;
						
					}
					if(getLeftBounds().intersects(obj.getRightBounds())){
						velX = 0;
						x = obj.getX() + obj.getWidth();
						if(obj.getId() == 250){  // SCORE FROM PICKUPS //
							score+=150;
						}
							
					}
					
				}
		}
		if(y >= 1750)
		{
			if(life > 0)
			{
				System.out.println("Lives left: " + life);
				life--;
				Game.getInstance().setPlayerLife(life);
				y= 256;
				x+= -112;
			}
			else if(life == 0){
				score = (int) (x - 300);
				Game.getInstance().setPlayerScore(score);
				Game.getInstance().setPlayerLife(life);
				score = 0;
				Game.state = GameState.DEATH;
				y= 600; //600
				x= 320; //320
				life = 2;

			}

		}
		
	}
	
	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public void fall(){
		if(falling)
			if(velY < 20)
				velY += gravity;
	}

	public boolean isMoving() {
		return moving;
	}
	public int getLife() {
		return life;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public void setDirection(Direction direction){
		this.direction = direction;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	public void setScore(int score) {
		
		System.out.println("you scored: " + score);
		
		this.score = score;
    }
	public int getScore() {
		return score;
    }
}
