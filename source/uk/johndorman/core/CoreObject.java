package uk.johndorman.core;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import uk.johndorman.gfx.Textures;

public abstract class CoreObject {

	protected float x, y, velX, velY;
	protected int id;
	
	protected int height;
	
	protected int width;
	
	protected boolean colide = true;
	
	protected Textures tex;
	protected BufferedImage image;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	
	public CoreObject(float x, float y, int id, Textures tex, boolean colide){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
		this.colide = colide;
	}
	
	public CoreObject(float x, float y, int id, BufferedImage image, boolean colide){
		this.x = x;
		this.y = y;
		this.id = id;
		this.image = image;
		this.colide = colide;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
	public Rectangle getTopBounds(){
		if(colide)
			return new Rectangle((int)x, (int)y , width, 12); //
		else
			return new Rectangle(0,0,0,0);
	}
	
	public Rectangle getBottomBounds(){
		if(colide)
			return new Rectangle((int)x,  (int)y + (height - 6), width, 12);
		else
			return new Rectangle(0,0,0,0);
	}
	
	public Rectangle getRightBounds(){
		if(colide)
			return new Rectangle((int)x + (width - 6), (int)y, 6, height);
		else
			return new Rectangle(0,0,0,0);
	}
	
	public Rectangle getLeftBounds(){
		if(colide)
			return new Rectangle((int)x, (int)y, 6, height);
		else
			return new Rectangle(0,0,0,0);
	}


	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}
	public float getVelx() {
		return velX;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	public float getVelY() {
		return velY;
	}
	
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}
}
