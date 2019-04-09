package uk.johndorman;

import java.awt.Graphics;
import java.util.ArrayList;

import uk.johndorman.core.CoreObject;

public class Controller {

	private ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
	
	public void tick(){
		for(CoreObject obj : objects){
			obj.tick();
		}
	}
	
	public void renderForeground(Graphics g){
		for(CoreObject obj : objects){
			if(obj.getId() < 200)
				obj.render(g);
		}
	}
	
	public void render2(Graphics g){
		for(CoreObject obj : objects){
			if(obj.getId() > 200)
				obj.render(g);
		}
	}

	public void addObject(CoreObject instance){
		objects.add(instance);
	}
	
	public void removeObject(CoreObject instance){
		objects.remove(instance);
	}
	
	public ArrayList<CoreObject> getObjects(){
		return objects;
	}
}