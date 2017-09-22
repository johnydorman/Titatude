package uk.johndorman;

import uk.johndorman.core.CoreObject;
import uk.johndorman.entity.Player;
import uk.johndorman.libs.Identities;

public class Camera {

	private float x,y;
	private Player player;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
		for(CoreObject obj : Game.getInstance().getController().getObjects())
			if(obj.getId() == Identities.PLAYER)
				player = (Player) obj;
	}
	
	public void tick(){
		if(-16000 > -player.getX() - Game.WIDTH / 2)
			x += ((-16000 + Game.WIDTH) -x) * 0.0500f;
		else if(0 > -player.getX() + Game.WIDTH / 2)
			x += ((-player.getX() + Game.WIDTH / 2) -x) * 0.0500f;
		else
			x += ((0) -x) * 0.0500f;
		if(player.getY() < 500)
			y += ((-player.getY() + Game.HEIGHT / 2) -y) * 0.0500f;
		else
			y += (-250 - y) * 0.0500f;
		/* if( 224 < -player.getY() + Game.HEIGHT / 2)
			y = (-player.getY() + 36);
		else
			y = 0; */
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
}
