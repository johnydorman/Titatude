package uk.johndorman.world;

import java.awt.image.BufferedImage;

import org.json.JSONArray;
import org.json.JSONObject;

import uk.johndorman.Controller;
import uk.johndorman.Game;
import uk.johndorman.gfx.Textures;
import uk.johndorman.libs.Identities;
import uk.johndorman.libs.Images;
import uk.johndorman.objects.Block;

public class Level {

	private BufferedImage image;
	private Controller controller = Game.getInstance().getController();
	private Textures tex = Game.getInstance().getTextureHandler();

	public Level(String name, int levelNumber, String[] textures, String objects) {
		
	}
	
	public Level(int levelNumber){
		switch(levelNumber){
			case 1:
				image = Images.levelOne;
				break;
			default:
				image = Images.levelOne;
				break;
	   }
    }
	
	public void load(String filename) {
		JSONArray loadFile = new JSONArray(filename);
		
		for(int index = 0; index < loadFile.length(); index++) {
			loadFile.getJSONObject(index);
		}
	}
	
    public void load(){
       int w = image.getWidth();
       int h = image.getHeight();
	        
        for(int x = 0; x < w; x++){
            for(int y = 0; y < h; y++){
                int pixel = image.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
               
               if(red == 255 && green == 255 && blue == 255)
                   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_GRASS, tex.blockGrass, true));
               else if(red == 150 && green == 150 && blue == 150)
            	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_DIRT, tex.blockDirt, true));
               else{
            	   
            	// RED   
                   if(red == 255 && green == 0 && blue == 0)
                       controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_HOUSEWOOD, tex.blockHouseWood, true));
                   if(red == 200)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.WATER, tex.blockWater, true));
                   if(red == 150)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_EDGEWOOD, tex.blockEdgeWood, false));
                   if(red == 100)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_EDGEWOOD2, tex.blockEdgeWood2, true));
                   if(red == 75)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_DIRTEDGE, tex.blockDirtEdge, false));
                   if(red == 50)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_EDGEWOOD2, tex.blockGrassPath, false));
                   if(red == 20)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_EDGEWOOD2, tex.blockGrassJoin, false));
                   if(red == 10)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_DIRTNOCLIP, tex.blockDirtNoClip, false));
                   
                // BLUE   
                   if(blue == 255)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_DIRTWOOD, tex.blockDirtWood, true));
                   if(blue == 200)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_CLEARWOOD, tex.blockClearWood, true));
                   if(blue == 150)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_WOOD, tex.blockWood, true));
                   if(blue == 100)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_TOPWOOD, tex.blockTopWood, true));
                   if(blue == 60)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_EDGEWOOD2, tex.blockGrassJoin2, false));
                   if(blue == 20)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_EDGEWOOD2, tex.blockGrassTrans, false));
                   
                  // no clip
                   
                   if(blue == 95)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_LEFTWOOD, tex.blockTopWoodHouse, false));
                   if(blue == 90)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_LEFTWOOD, tex.blockOutsideTop, false)); //
                   if(blue == 85)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_LEFTWOOD, tex.blockOutsideBot, false));
                   if(blue == 80)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_LEFTWOOD, tex.blockOutsideJoin, false));
                   if(blue == 75)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_LEFTWOOD, tex.blockMidWoodHouse, false));
                   if(blue == 70)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_LEFTWOOD, tex.blockOutsideTopMid, false));
                   if(blue == 65)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_LEFTWOOD, tex.blockOutsideTopEnd, false));
                   if(blue == 50)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_LEFTWOOD, tex.blockBotWoodHouse, false));
                   if(blue == 30)
                   		controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_LEFTWOOD, tex.blockLeftWood, false));
                   if(blue == 25)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_RIGHTWOOD, tex.blockRightWood, false));
                   if(blue == 5)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_CENTERWOOD, tex.blockCenterWood, false));
                   
                   
                 // GREEN 
                   
                   if(green == 255 && red == 0 && blue == 0)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_STONE, tex.blockWoodDarkShade, false));
                   if(green == 225)
                	   controller.addObject(new Block(x *32, y * 32, Identities.BLOCK_DIRTNOCLIP, tex.blockWoodCornerLight, false));
                   if(green == 200)
                	   controller.addObject(new Block(x *32, y * 32, Identities.BLOCK_DIRTNOCLIP, tex.blockWoodCorner, true));
                   if(green == 175)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_DIRTNOCLIP, tex.blockGrassDirtJoin, false));
                   if(green == 150)
                	   controller.addObject(new Block(x *32, y * 32, Identities.BLOCK_STONEEDGE, tex.blockWoodDrop, false));
                   if(green == 100)
                	   controller.addObject(new Block(x *32, y * 32, Identities.BLOCK_STONECORNER, tex.blockWoodCornerDrop, true));
                   if(green == 50)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_EDGEWOOD2, tex.blockGrassDirt, false));
                   
                   // yellow
                   
                   if(red == 255 && green == 255 && blue == 0)
                	   controller.addObject(new Block(x * 32, y * 32, Identities.backgroundBuilding, tex.buidlingBackground, false));

               }
            }
        }
    }
}
