/**
 * 
 */
package uk.johndorman;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import org.lwjgl.openal.AL;

import uk.johndorman.entity.Ai;
import uk.johndorman.entity.Player;
import uk.johndorman.enums.GameState;
import uk.johndorman.gfx.Renderer;
import uk.johndorman.gfx.Textures;
import uk.johndorman.input.KeyInput;
import uk.johndorman.input.MouseInput;
import uk.johndorman.libs.Audio;
import uk.johndorman.libs.Identities;
import uk.johndorman.screens.Credits;
import uk.johndorman.screens.Death;
import uk.johndorman.screens.Menu;
import uk.johndorman.screens.Options;
import uk.johndorman.screens.Pause;
import uk.johndorman.screens.Score;
import uk.johndorman.utils.AudioPlayer;
import uk.johndorman.utils.ResourceLoader;
import uk.johndorman.world.Level;
/**
 * @author John Dorman
 *
 */
public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -3714621458582752754L;
	public static final int WIDTH  = 980; //32 640 // 1280
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final String TITLE = "Titatude";
	private static Game game = new Game();
	
	public static GameState state = GameState.MENU;
	
	private boolean running = false;
	private Thread thread;
	private Renderer gfx;
	private Menu menu;
	private Credits credits;
	private Options options;
	private Death death;
	private Score score;
	private Pause pause;
	
	private Player player;
	private int playerScore;
	private int playerLife;
	private int playerX;
	private int playerY;
	
	private Controller controller = new Controller(); // game objects
	
	private Textures tex;
	public Level currentLevel;
	private int levelId;
	private Camera camera;
	
	public static Game getInstance(){
		return game;
	}
	
	public Menu getMenu(){
		return menu;
	}
	public Credits getCredits(){
		return credits;
	}
	public Options getOptions(){
		return options;
	}
	public Death getDeath(){
		death = new Death();
		return death;
	}
	public Score getScore(){
		return score;
	}
	public Pause getPause(){
		return pause;
	}
	public Textures getTextureHandler(){
		return tex;
	}
	public Controller getController(){
		return controller;
	}
	
	// PLAYER STUFF
	
	public void setPlayer(Player player){	
		this.player = player;
	}
	public Player getPlayer(){
		return player;
	}
	public int getPlayerLife(){
		return playerLife;
	}
	public void setPlayerLife(int life){
		this.playerLife = life;
	}
	public int getPlayerScore(){
		return playerScore;
	}
	public void setPlayerScore(int score){
		this.playerScore = score;
	}
	public void setPlayerXLocation(int xLoc){
		this.playerX = xLoc;
	}
	public int getPlayerXLocation(){
		return playerX;
	}
	public void setPlayerYLocation(int YLoc){
		this.playerY = YLoc;
	}
	public int getPlayerYLocation(){
		return playerY;
	}
	
	
	// PLAYER STUFF END
	// Level STUFF 
	
	public int getPlayerLevelId(){
		return levelId;
	}
	public void setPlayerLevelId(int levelId){
		this.levelId = levelId;
	}
	
	// LEVEL STUFF END
	
	public void init(){
				
		ResourceLoader.LoadImages();
		ResourceLoader.loadFonts();
		ResourceLoader.loadSounds();
		tex = new Textures();
		AudioPlayer.playMusic(Audio.MUSIC_TITLE);
		menu = new Menu();
		credits = new Credits();
		options = new Options();
		score = new Score();
		pause = new Pause();
		gfx = new Renderer();
		MouseInput mouse = new MouseInput();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		levelId = 1;
		currentLevel = new Level(levelId);
		
		controller.addObject(new Player(300, 602, Identities.PLAYER, tex, true, 2, 0));//100 , 100
		
		controller.addObject(new Ai(137, 762, Identities.AI, tex, true, 1));//100 , 100
		controller.addObject(new Ai(930, 762, 3, tex, true, 1));
		
		camera = new Camera(0,0);
		this.addKeyListener(new KeyInput());
	}
	
	public void tick(){
		if(state == GameState.GAME){
			controller.tick();
			camera.tick();
		}
	}
	

	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(new Color(6, 0, 40));
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		
		///////////////////////////////////////////////////////////////
		
		
		gfx.renderBackground(g);
		g2d.translate(camera.getX(), camera.getY());
		gfx.renderForeBackground(g);
		gfx.renderForeground(g);
		g2d.translate(-camera.getX(), -camera.getY());
		
		
		///////////////////////////////////////////////////////////////
		
		/////////////////////////// Hud ////////////////////////////////////////
		
		if(Game.state == GameState.GAME){
			g.setColor(Color.WHITE);
			Font tinytots = new Font("04b03", Font.PLAIN, 30);
			g.setFont(tinytots);
			
			g.drawString("Score: "+ Game.getInstance().getPlayerScore(), 10, 30);
				
			g.drawString("Lives: "+ Game.getInstance().getPlayerLife(), (Game.WIDTH/2)-60, 30);
			
			g.drawString("Best: 12000", Game.WIDTH - 200, 30);
			
		}
		///////////////////////////////////////////////////////////////////////
		g.dispose();
		bs.show();
		
		
	}
	
	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if(delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer+=1000;
				System.out.println(ticks + " Ticks, FPS: " + frames);
				Window.setTitle(TITLE + "     FPS: " + frames);
				ticks = 0;
				frames = 0;
			}
			
		}
		stop();
	}

	public static void main(String args[]){
		Window.initWindow(TITLE);
		Window.addGame(game);
		Window.createtWindow();
		game.start();
		
	}

	
	
	
	private synchronized void start(){
		if(running)
			return;
		else
			running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running)
			return;
		else
			running = false;	
		
		cleanUp();
		System.exit(1);
	}
	
	private void cleanUp(){
		AL.destroy();
	}
	
	public static void exit(){
		game.stop();
	}
}
