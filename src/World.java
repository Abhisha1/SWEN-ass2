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
	
	/** First game level */
	private Level level1;
	
	private Level level2;
	
	
	/** Checks if game is completed */
	private boolean gameWon = false;
	
	public static int LOW_PRIORITY = 0;
	public static int HIGH_PRIORITY = 1;
	
	/** Creates world with a player and corresponding level
     */
	public World() {
		buildPlayer();
		level1 = new Level("assets/levels/0.lvl", player);
		level2 = new Level("assets/levels/1.lvl", player);
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
	//	if (!level1.isComplete) {
	//		level1.update(input, delta, gc);
	//	}
	//	else {
			level2.update(input, delta, gc);
	//	}
		if (gameOver()) {
		//	gc.exit();
		}
		
	}

		
	/** Update the game state for a frame.
     * @param g The Slick graphics object, used for drawing.
     */
	public void render(Graphics g) {
		// Draw all of the sprites in the game
		//if (!level1.isComplete) {
			//level1.render(g);
		//}
	//	else {
			level2.render(g);
		//}
		for (Life a: player.getLives()) {
			a.render();
		}
	}
	/** Checks if the game has ended as all lives are lost
     * @param g The Slick graphics object, used for drawing.
     */
	private boolean gameOver() {
		if (player.getLives().isEmpty() || gameWon) {
			return true;
		}
		return false;
	}
}
