package uk.johndorman.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import uk.johndorman.Game;
import uk.johndorman.core.CoreObject;
import uk.johndorman.enums.Direction;
import uk.johndorman.gfx.Animation;
import uk.johndorman.gfx.Textures;
import uk.johndorman.objects.Block;

public class Ai extends CoreObject {
	
	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
	
	private float gravity = 0.98f;
	private boolean falling = true;
	private boolean jumping = false;
	
	private boolean moving = false;
	private Animation animeRight;
	private Animation animeLeft;
	
	private Direction direction = Direction.RIGHT;
	private int life;
	private int id;
	boolean hitRight = true;
	
	
	public Ai(float x, float y, int id, Textures tex, boolean colide, int life) {
		super(x, y, id, tex, colide);
		this.setSize(32, 70);
		this.id = id;
		animeRight = new Animation(3, tex.playerRight);
		animeLeft = new Animation (3, tex.playerLeft);
		
		this.life = life;
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
				velX = 1;
			}
			else if(velX < 0){
				velX = -1;			
			}
		}
		else
			jumping = false;
			if(velX > 0){
				velX = 1;
			}
			else if(velX < 0){
				velX = -1;				
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
						hitRight = true;
						moving = false;
						
						
					} else { 
						if(!hitRight){
							velX = 1;
							direction = Direction.RIGHT;
							moving = true;
						}
						else if(hitRight){
							velX = -1;
							direction = Direction.LEFT;
							moving = true;
						}
					}
					if(getLeftBounds().intersects(obj.getRightBounds())){
						velX = 0;
						x = obj.getX() + obj.getWidth();
						hitRight = false;
						
					}
					
					
					if(id == 2){
						if(x == 410){
						hitRight = true;
						}
					}
					
					
					if(id == 3) {
						//if(x == 1415){
						//hitRight = true;
						//}
						//if(x == 648){
						//	hitRight = false;
						//}
						if(x > Game.getInstance().getPlayerXLocation()){
							velX = -2;
						}
						if(x < Game.getInstance().getPlayerXLocation()){
							velX = 2;
						}
					}
				}
		}
		if(y >= 1750)
		{
			life--;
			if(life == 0)
			{
				//death of Ai
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
}

