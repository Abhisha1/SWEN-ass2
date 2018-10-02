import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * Where each stage/level of game is created.
 * Handles initialization, input and rendering of level
 */

public class Level {
	/** Has player completed level*/
	private boolean isComplete = false;
	
	private Tile tile;
	private static Player player;
	
	private static boolean isHit = false;
	
	/** All rendered images in level*/
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	/**Objects that move*/
	Movable movingObject;
	
	/**Data that controls the initialising of the level background*/
	Instruction levelInstructions;
	
	/** Creates the level
     * @param instructionFileAddress file path name which contains level instructions.
     * @param player Game player.
     */
	public Level(String instructionFileAddress, Player player) {
		this.player = player;
		this.levelInstructions = new Instruction(instructionFileAddress);
		
		for (String[] a: levelInstructions.getInstructions()) {
			//System.out.println(Arrays.toString(a));
			if (Tile.isTile(a[0])){
				tile = Instruction.instructionParsedTile(a);
				tile.createBoundingBox(tile);
				sprites.add(tile);
			}
			else {
				movingObject = Instruction.instructionParsedMovable(a);
				movingObject.createBoundingBox(movingObject);
				sprites.add(movingObject);
			}
		}
		sprites.add(player);
	}
	
	/** Checks if level has been completed by player
     * @param player Game player.
     * @return boolean whether game has finished.
     */
	private boolean isLevelComplete(Player player) {
		return false;
	}
	
	/** Update the game state for a frame while checking for collisions.
     * @param gc The Slick game container object.
     * @param delta Time passed since last frame (milliseconds).
     * @param input The user input.
     */
	public void update(Input input, int delta, GameContainer gc) {
		// Update all of the sprites in the game
		for (Sprite a: sprites) {
			a.update(input, delta);
			if (!isHit) {
				System.out.println("hit");
				player.contactSprite(a);
				
			}
			
		}
		
	}
	
    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
	public void render(Graphics g) {
		// Draw all of the sprites in the game
		for (Sprite a:sprites) {
			a.render();
		}
	}
    /** Checks if player has hit another object.
     * @param a A drawable object in game.
     * @return boolean returns if there has been a collision.
     */
	public static void isCollision(Sprite a) {
		//Checks if the player has hit a sprite that causes the game to exit (bus or water)
		if (a.getDanger()) {
			player.resetPlayer();
			System.out.println("reset");
			Life.loseLife(player);
		//	isHit = true;
		}
	}
	
	
}
