package uk.johndorman.core;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import uk.johndorman.gfx.Textures;

public abstract class FreeObject {

	protected float x, y, velX, velY;
	protected int id;
	
	protected int height;
	
	protected int width;
	
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

	
	
	public FreeObject(float x, float y, int id, Textures tex){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
	}
	
	public FreeObject(float x, float y, int id, BufferedImage image){
		this.x = x;
		this.y = y;
		this.id = id;
		this.image = image;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
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
