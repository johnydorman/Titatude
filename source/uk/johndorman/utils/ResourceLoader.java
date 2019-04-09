package uk.johndorman.utils;

import java.io.IOException;

import uk.johndorman.libs.Audio;
import uk.johndorman.libs.Fonts;
import uk.johndorman.libs.Images;

public class ResourceLoader {
	
	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void LoadImages()
	{
		try{
			//Images.background = imageLoader.loadImage("background1.png");
			Images.backgroundHouse = imageLoader.loadImage("house.png");
			Images.backgroundHouse2 = imageLoader.loadImage("house2.png");
			Images.backgroundHouse3 = imageLoader.loadImage("house3.png");
			Images.sign = imageLoader.loadImage("sign.png");
			Images.fence = imageLoader.loadImage("fence.png");
			
			
			
			Images.title = imageLoader.loadImage("title.png");
			Images.sub_title = imageLoader.loadImage("sub_title.png");
			Images.options = imageLoader.loadImage("options.png");
			Images.options_sub_title = imageLoader.loadImage("options_sub_title.png");
			Images.credits = imageLoader.loadImage("credits.png");
			Images.credits_sub_title = imageLoader.loadImage("credits_sub_title.png");
			Images.gameOver = imageLoader.loadImage("GameOver.png");
			Images.gameOver_sub_title = imageLoader.loadImage("gameOver_sub_title.png");
			Images.pause = imageLoader.loadImage("pause.png");
			Images.pause_sub_title = imageLoader.loadImage("pause_sub_title.png");
			Images.spritesheetTest = imageLoader.loadImage("testSpriteSheet.png");
			Images.spritesheetPlayer = imageLoader.loadImage("female.png");
			Images.levelOne = imageLoader.loadImage("level/level1.png");
			Images.levelOneBackground = imageLoader.loadImage("level/level1Background1.png");
			
			
			Images.background_mountains = imageLoader.loadImage("mountains.png");
			Images.background_sky = imageLoader.loadImage("sky.png");
			Images.background_woods = imageLoader.loadImage("woods.png");
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void loadFonts(){
		Fonts.addFont(new Fonts("tinytots.ttf"));
	}
	
	public static void loadSounds(){
		//AudioPlayer.addSound(Audio.MUSIC_TITLE, "Carefree.ogg");
		AudioPlayer.addMusic(Audio.MUSIC_TITLE, "Carefree.ogg");
	}
}
