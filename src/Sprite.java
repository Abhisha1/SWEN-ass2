//This program was written by Abhisha Nirmalathas for SWEN20003 Project 1
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import utilities.BoundingBox;


/**
 * Objects that are drawn onto the game screen.
 * Handles initialization, input and rendering.
 */

public class Sprite {
	
	/**Priority Ranking assigned for each sprite so that higher priority collisions are checked first*/
	public static int LOW_PRIORITY = 0;
	public static int MEDIUM_PRIORITY = 1;
	public static int HIGH_PRIORITY = 2;
	
	/** The x position of sprite*/
	private float xLocation;
	
	/**The y position of sprite*/
	private float yLocation;
	
	/**If object can be moved on top of*/
	private boolean isSolid = false;
	
	/**If touching this object results in player losing life*/
	private boolean isDanger = false;
	
	/**If touching this object causes player to move/ride with it*/
	private boolean isPushable = false;
	
	
	/**Name of object*/
	private String name = "sprite";
	
	/**bounding box for the sprite*/
	private BoundingBox boundingBox;
	
	private boolean isVisible = true;
	
	/**Rendered image of the sprite*/
	Image spritePhoto;
	
	/**Default priority ranking*/
	public int priority = LOW_PRIORITY;
	
	/** Creates a new object of class Sprite
     * @param imageSrc A string containing the file path for image.
     * @param x The x location of the sprite.
     * @param y The y location of the sprite.
     */
	public Sprite(String imageSrc, float x, float y) {
		// Every sprite/image drawn on the game container has a photo, and coordinates
		try {
			spritePhoto = new Image(imageSrc);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		xLocation = x;
		yLocation = y;
		
		
	}
	/** Creates a bounding box for sprite
     * @param sprite A drawable object in game.
     */
	public void createBoundingBox(Sprite sprite) {
		// Makes a bounding box for sprite
		boundingBox = new BoundingBox(sprite.spritePhoto, sprite.getXLocation(), sprite.getYLocation());
		
	}
	/** Returns bounding box.
     * @param a A drawable object in game.
     */
	public BoundingBox getBoundingBox() {
		//returns the bounding box via getter method
		return this.boundingBox;
	}
	/** Checks if sprite has a bounding box.
     * @param box A box in which the sprite image is contained inside.
     */
	public boolean hasBoundingBox(BoundingBox box) {
		// checks if bounding box exists
		if (box.equals(null)) {
			return false;
		}
		return true;
	}
	/** Update the game state for a frame when dealing with a sprite.
     * @param delta Time passed since last frame (milliseconds).
     * @param input The user input.
     */
	public void update(Input input, int delta) {
	}
	/** Draws the sprite onto the game container
     */
	public void render() {
		this.spritePhoto.drawCentered(this.xLocation, this.yLocation);
		// This should be pretty simple.
		
	}
	/** Checks if a sprite has hit another sprite
     * @param other A drawable object in game.
     */
	public void contactSprite(Sprite other) {
		// Should be called when one sprite makes contact with another. 
		if (this.getBoundingBox().intersects(other.getBoundingBox())) {
			Level.getExtraLife(other);
			Level.isPushed(other);
			Level.isCollision(other);
		}
	}
	public float getXLocation() {
		// returns x coordinate
		return this.xLocation;
	}
	
	public float getYLocation() {
		// returns y coordinate
		return this.yLocation;
	}
	public void setXLocation(float x) {
		// sets x coordinate value
			this.xLocation = x;
			this.boundingBox.setX(x);
	}
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	public void setDanger(boolean isDanger) {
		this.isDanger = isDanger;
	}
	public boolean getDanger() {
		return this.isDanger;
	}
	public void setPushable(boolean isPushable) {
		this.isPushable = isPushable;
	}
	public boolean getPushable() {
		return this.isPushable;
	}
	public boolean getSolid() {
		return this.isSolid;
	}
	public void setVisibility(boolean visibility) {
		this.isVisible = visibility;
	}
	public boolean getVisibility() {
		return this.isVisible;
	}
	public void setYLocation(float y) {
		// sets y coordinate value
			this.yLocation = y;
			this.boundingBox.setY(y);
	}
	public void setName(String name) {
		// sets y coordinate value
			this.name = name;
	}
	public String getName() {
		// sets y coordinate value
			return this.name;
	}
	/** Updates the location of a sprite whilst ensuring it wraps around the game container.
     * @param x Value to assign the x location of sprite.
     */
	public void wrapXLocation(float x) {
		// Updates the location of obstacle to newly computed value or either end of game container
		this.setXLocation(x);
		if (x > 0 && x <= App.SCREEN_WIDTH) {
			this.setXLocation(x);
		}
		else if (x - this.spritePhoto.getWidth()/2 >= App.SCREEN_WIDTH) {
			this.setXLocation(0.0f - this.spritePhoto.getWidth()/2);
		}
		
		else if (x  + this.spritePhoto.getWidth()/2 <= 0.0f) {
			this.setXLocation(App.SCREEN_WIDTH + this.spritePhoto.getWidth()/2);
		}
	}
}
