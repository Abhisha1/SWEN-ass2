//This program was written by Abhisha Nirmalathas for SWEN20003 Project 1

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * Stage of game where levels are initialized 
 * Player is created, updated and rendered
 */



public class World {
	/** Game player*/
	private Player player;
	
	private static final int MAX_LEVELS = 2;
	
	/** First game level */
	private Level level;
	
	/** Second game level */
	private int levelsPassed = 1;
	
	
		
	/** Creates world with a player and corresponding level
     */
	public World() {
		buildPlayer();
		level = new Level("assets/levels/0.lvl", player);
	}
	

	
	/** Creates game player
     */
	private void buildPlayer() {
		//Builds a frog player onto game
		player = new Player("assets/frog.png", 512, 720);
		player.createBoundingBox(player);
	}
	
	/** Update the game state for a frame.
     * @param gc The Slick game container object.
     * @param delta Time passed since last frame (milliseconds).
     * @param input The user input.
     */
	public void update(Input input, int delta, GameContainer gc) {
		// Update all of the sprites in the game
		player.update(input, delta, player);
		level.update(input, delta, gc);
		if (level.isComplete && levelsPassed < MAX_LEVELS) {
			levelsPassed++;
			level = new Level("assets/levels/1.lvl", player);
		}
		if (gameOver() || (level.isComplete && levelsPassed == MAX_LEVELS)) {
			gc.exit();
		}
		
	}

		
	/** Update the game state for a frame.
     * @param g The Slick graphics object, used for drawing.
     */
	public void render(Graphics g) {
		// Draw all of the sprites in the game
		level.render(g);
		for (Life a: player.getLives()) {
			a.render();
		}
	}
	/** Checks if the game has ended as all lives are lost
     * @param g The Slick graphics object, used for drawing.
     */
	private boolean gameOver() {
		if (player.getLives().isEmpty()) {
			return true;
		}
		return false;
	}
}
