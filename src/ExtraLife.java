import java.util.Random;
import java.util.ArrayList;

import org.newdawn.slick.Input;
/**
 * A subclass from sprite which handles the Extra Life Object.
 * This Object helps the player get an additional life if the 
 * player can hit the extra life.*/
public class ExtraLife extends Sprite{
	private static int randomSeconds;
	private static int nthLog;
	
	private static int maxMilliSeconds = 35000;
	private static int minMilliSeconds = 25000;
	private static String name = "extra life";
	private static String imageAddress = "assets/extralife.png";
	
	/** The log that the extra life object attaches to*/
	Log log;
	
	private boolean moveToRight = true;
	private float moveOnLog = 2000f;
	
	/** The random object which helps randomly pick a log and a time to spawn the extra life*/
	static Random rand = new Random();
	
	private float myDelta = 0f;
	
	/** Creates an object of class ExtraLife
	 * @param sprites An array of sprites.
	 * */
	public ExtraLife(ArrayList<Sprite> sprites) {
		// Creates the Extra Life object
		super(imageAddress, 0f, 0f);
		super.setName(name);
		super.priority = Sprite.HIGH_PRIORITY;
		this.setVisibility(true);
		this.createBoundingBox(this);
		selectLog(sprites);
		// Sets the location of the extra life to its assigned log whilst the log exists
		try {
			this.setXLocation(log.getXLocation());
			this.setYLocation(log.getYLocation());
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	private void selectLog(ArrayList<Sprite> sprites) {
		// Picks a log from the list of sprites
		int counter = 0;
		for (Sprite a: sprites) {
			if (a.getName().equals("log")) {
				counter++;
			}
			if (counter == nthLog && a.getName().equals("log")) {
				log = (Log)a;
				break;
			}
		}
	}
	/** Computes the number of seconds and which log the Extra Life object
	 *  will be created at and attached to.
	 * @param sprites An array of sprites.
	 * */
	public static void initialiseSpawning(ArrayList<Sprite> sprites) {
		randomSeconds = (rand.nextInt(maxMilliSeconds-minMilliSeconds)+minMilliSeconds);
		nthLog = rand.nextInt(Log.getNumberOfLogs(sprites))+1;
		
	}
	/** Returns the number of seconds at which the Extra Life object should be created at
	 * @return when the extra life object should be made.
	 * */
	public static int spawnTimeExtraLife() {
		return randomSeconds;
	}
	/** Removes the extraLife object and detaches from the log.
	 * @param sprites An array of sprites.
	 * */
	public void removeExtraLife(ArrayList<Sprite> sprites) {
		selectLog(sprites);
		this.setVisibility(false);
		sprites.remove(this);
	}
	
	/** Update the game state for an extra life object.
     * @param delta Time passed since last frame (milliseconds).
     * @param input The user input.
     */
	@Override
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
		myDelta+=delta;
		// Checks whether the 2 seconds have passed and traverses the log by one tile
		if (myDelta >= moveOnLog && !log.equals(null)) {
			this.wrapXLocation(this.getXLocation() + Tile.TILE_SIZE*log.moveDirection(this.moveToRight), (Movable)log);
			myDelta = 0f;
		}
		// Log pushes the extra life along
		if (!log.equals(null) && !this.equals(null)) {
			log.pushExtra(delta, (Sprite)this);
			logDirectionTraversal();
		}
		
	}
	
	private void logDirectionTraversal() {
		// Determines which direction the extra life object should move on the log without
		// falling off the log
		if (this.getBoundingBox().getRight() > log.getBoundingBox().getRight()) {
			this.moveToRight = false;
		}
		if (this.getBoundingBox().getLeft() < log.getBoundingBox().getLeft()) {
			this.moveToRight = true;
		}
	}
	
	
	
	

}
