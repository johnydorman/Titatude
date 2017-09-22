package uk.johndorman.gfx;

import java.awt.image.BufferedImage;

import uk.johndorman.libs.Images;
import uk.johndorman.utils.SpriteSheet;

public class Textures {

	private SpriteSheet sheetTest;
	private SpriteSheet playerSheet;
	
	public BufferedImage clouds;
	public BufferedImage clouds2;
	public BufferedImage buidlingBackground;
	
	public BufferedImage blockGrass;
	public BufferedImage blockDirt;
	public BufferedImage blockDirtNoClip;
	public BufferedImage blockClearWood;
	public BufferedImage blockWood;
	public BufferedImage blockDirtWood;
	public BufferedImage blockTopWood;
	public BufferedImage blockStone;
	public BufferedImage blockDirtStone;
	public BufferedImage blockStoneEdge;
	public BufferedImage blockStoneCorner;
	public BufferedImage blockWater;
	public BufferedImage blockDirtEdge;
	
	public BufferedImage blockLeftWood;
	public BufferedImage blockRightWood;
	public BufferedImage blockCenterWood;
	public BufferedImage blockBotWoodHouse;
	public BufferedImage blockMidWoodHouse;
	public BufferedImage blockTopWoodHouse;
	public BufferedImage blockOutsideTop;
	public BufferedImage blockOutsideBot;
	public BufferedImage blockOutsideJoin;
	
	public BufferedImage blockOutsideTopMid;
	public BufferedImage blockOutsideTopEnd;
	public BufferedImage blockEdgeWood;
	public BufferedImage blockEdgeWood2;
	
	public BufferedImage blockHouseWood;
	public BufferedImage blockGrassPath;
	public BufferedImage blockGrassJoin;
	public BufferedImage blockGrassJoin2;
	public BufferedImage blockGrassTrans;
	public BufferedImage blockGrassDirt;
	public BufferedImage blockGrassDirtJoin;
	public BufferedImage blockWoodDarkShade;
	
	public BufferedImage blockWoodCorner;
	public BufferedImage blockWoodDrop;
	public BufferedImage blockWoodCornerDrop;
	public BufferedImage blockWoodCornerLight;
	
	public BufferedImage playerStandingRight;
	public BufferedImage playerStandingLeft;
	public BufferedImage playerRight[] = new BufferedImage[4];
	public BufferedImage playerLeft[] = new BufferedImage[4];
	
	public Textures(){
		
		
		sheetTest = new SpriteSheet(Images.spritesheetTest, 32);
		playerSheet = new SpriteSheet(Images.spritesheetPlayer, 32, 70);
		
		
		initTextures();
	}
	
	private void initTextures(){
		
		blockGrass = sheetTest.getSprite(1, 1);
		blockDirtNoClip = sheetTest.getSprite(2, 1);
		blockDirt = sheetTest.getSprite(2, 1);
		blockDirtWood = sheetTest.getSprite(3, 1);		
		blockWoodCornerLight = sheetTest.getSprite(4, 1);
		blockDirtStone = sheetTest.getSprite(5,1);
		blockStoneEdge = sheetTest.getSprite(6, 1);
		blockStoneCorner = sheetTest.getSprite(7,1);
		
		blockDirtEdge = sheetTest.getSprite(1, 5);
		blockWood = sheetTest.getSprite(3,2);
		blockClearWood = sheetTest.getSprite(3, 3);



		blockTopWood = sheetTest.getSprite(5, 2); 
		blockEdgeWood = sheetTest.getSprite(5, 5);
		blockEdgeWood2 = sheetTest.getSprite(5, 6);
		blockGrassDirtJoin = sheetTest.getSprite(1, 6);
		
		blockWoodDrop = sheetTest.getSprite(6, 3);
		blockWoodCornerDrop = sheetTest.getSprite(7, 3);
		
		blockLeftWood = sheetTest.getSprite(2, 4);
		blockCenterWood = sheetTest.getSprite(3, 4);
		blockRightWood = sheetTest.getSprite(4, 4);
		blockWoodCorner = sheetTest.getSprite(6, 2);
		blockWoodDarkShade = sheetTest.getSprite(7, 2);
		
		blockBotWoodHouse =  sheetTest.getSprite(2, 5);
		blockMidWoodHouse =  sheetTest.getSprite(3, 5);
		blockTopWoodHouse =  sheetTest.getSprite(4, 5);
		blockOutsideTop = sheetTest.getSprite(5, 3);
		blockOutsideBot = sheetTest.getSprite(4, 3);
		blockOutsideTopMid = sheetTest.getSprite(6, 4);
		blockOutsideTopEnd = sheetTest.getSprite(7, 4);
		
		blockOutsideJoin = sheetTest.getSprite(5, 4);
		
		
		blockHouseWood = sheetTest.getSprite(4,2);
		
		blockGrassPath = sheetTest.getSprite(1, 2);
		blockGrassJoin = sheetTest.getSprite(2, 2);
		blockGrassJoin2 = sheetTest.getSprite(1, 3);
		blockGrassDirt = sheetTest.getSprite(1, 4);
		blockGrassTrans = sheetTest.getSprite(2, 3);
		
		clouds = sheetTest.getSprite(3,8);
		clouds2 = sheetTest.getSprite(3,8);
		buidlingBackground = sheetTest.getSprite(3, 8);
		
		playerStandingRight = playerSheet.getSprite(1, 1);
		playerStandingLeft = playerSheet.getSprite(10, 1);
		
		playerRight[0] = playerSheet.getSprite(2,1);
		playerRight[1] = playerSheet.getSprite(3,1);
		playerRight[2] = playerSheet.getSprite(4,1);
		playerRight[3] = playerSheet.getSprite(5,1);
		
		playerLeft[0] = playerSheet.getSprite(6,1);
		playerLeft[1] = playerSheet.getSprite(7,1);
		playerLeft[2] = playerSheet.getSprite(8,1);
		playerLeft[3] = playerSheet.getSprite(9,1);
		

	}
}
