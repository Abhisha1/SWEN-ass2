import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;


import java.util.Collections;
/**
 * Where each stage/level of game is created.
 * Handles initialization, input and rendering of level
 */

public class Level {
	/** Has player completed level*/
	public boolean isComplete = false;
	
	private Tile tile;
	private static Player player;
	
	private float myDelta = 0f;
	
	private float spawnExtraLife;
	//private float destroyExtraLife = 2000;
	private float destroyExtraLife = 14000;
	/** All rendered images in level*/
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	/**Objects that move*/
	Movable movingObject;
	
	/**Data that controls the initialising of the level background*/
	Instruction levelInstructions;
	
	ExtraLife extraLife;
	
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
		ExtraLife.initialiseSpawning(sprites);
		sprites.add(player);
		sprites.trimToSize();
		
	}
	
	/** Checks if level has been completed by player
     * @param player Game player.
     * @return boolean whether game has finished.
     */
	
	/** Update the game state for a frame while checking for collisions.
     * @param gc The Slick game container object.
     * @param delta Time passed since last frame (milliseconds).
     * @param input The user input.
     */
	public void update(Input input, int delta, GameContainer gc) {
		// Update all of the sprites in the game
		ArrayList<Sprite> sortedSprites = new ArrayList<Sprite>(sprites);
		Collections.sort(sortedSprites, new PriorityComparator());
		myDelta+=delta;
		
		for (Sprite a: sortedSprites) {
			a.update(input, delta);
			player.checkValidMoves(a);
			if (!player.isHit) {
				if (a.getName().equals("extra life")){
		//			System.out.format("extra life bb cords"+ a.getBoundingBox().getLeft() + a.getBoundingBox().getRight()
		//					+ "player coords"+ player.getBoundingBox().getLeft() + player.getBoundingBox().getRight()+"\n");
				}
				player.contactSprite(a);
			}
		
		}
		spawnExtraLife();
		if (FinalLocation.isGapFilled(player, sprites) && FinalLocation.GAPS_TO_FILL <= 0) {
			isComplete = true;
		}
		player.isHit = false;
		
	}
	
    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
	public void render(Graphics g) {
		// Draw all of the sprites in the game
		for (Sprite a:sprites) {
			if (a.getVisibility()) {
				a.render();
			}
		}
	}
    /** Checks if player has hit another object.
     * @param a A drawable object in game.
     * @return boolean returns if there has been a collision.
     */
	public static void isCollision(Sprite a) {
		//Checks if the player has hit a sprite that causes the player to loose a life
		if (a.getDanger()) {
			player.resetPlayer();
			Life.loseLife(player);
			player.isHit = true;
		}
	}
	public static void isPushed(Sprite a) {
		//Checks if the player has hit a sprite that causes the game to exit (bus or water)
		if (a.getPushable()) {
			player.isHit = true;
			player.attachToPusher((Movable)a);
		}
	}
	public static void isSolid(Sprite a) {
		//Checks if the player has hit a sprite that causes the game to exit (bus or water)
		if (a.getSolid()) {
			player.isHit = true;
		}
	}
	
	
	public static void getExtraLife(Sprite a) {
		if (a.getName().equals("extra life")) {
			Life.gainLife();
			a.setVisibility(false);
			a = null;
			player.isHit = true;
		}
	}
	
	private void spawnExtraLife() {
		if (myDelta >= ExtraLife.spawnTimeExtraLife()+destroyExtraLife) {
			extraLife.removeExtraLife(sprites);
			myDelta = 0f;
			ExtraLife.initialiseSpawning(sprites);
		}
		if (myDelta >= ExtraLife.spawnTimeExtraLife() && extraLife== null) {
			extraLife = new ExtraLife(sprites);
			sprites.add(extraLife);
		}
	}
}
