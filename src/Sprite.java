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
	
	//Priority Ranking assigned for each sprite so that higher priority collisions are checked first
	/**Sprites that are checked last if collided with*/
	public static int LOW_PRIORITY = 0;
	
	/**Sprites that should be checked after high priority sprites*/
	public static int MEDIUM_PRIORITY = 1;
	
	/**Sprites that should be checked if collided with*/
	public static int HIGH_PRIORITY = 2;
	
	
	private float xLocation;
	
	
	private float yLocation;
	
	
	private boolean isSolid = false;
	
	
	private boolean isDanger = false;
	
	
	private boolean isPushable = false;
	
	private String name = "sprite";
	

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
     */
	public BoundingBox getBoundingBox() {
		//returns the bounding box via getter method
		return this.boundingBox;
	}
	/** Checks if sprite has a bounding box.
     * @param box A box in which the sprite image is contained inside.
     * @return Bounding Box
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
			Level.isPushed(other);
			Level.getExtraLife(other);
			Level.isCollision(other);
		}
	}
	/**Gets the x coordinate of sprite
	 * @return x coordinate of sprite*/
	public float getXLocation() {
		// returns x coordinate
		return this.xLocation;
	}
	/**Gets the y coordinate of sprite
	 * @return y coordinate of sprite*/
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
	/**Gets the danger of the sprite/ whether collision with this sprite causes death
	 * @return danger of sprite*/
	public boolean getDanger() {
		return this.isDanger;
	}
	public void setPushable(boolean isPushable) {
		this.isPushable = isPushable;
	}
	/** Returns whether sprite can push another sprite
	 * @return whether sprite can push other sprites*/
	public boolean getPushable() {
		return this.isPushable;
	}
	/** Returns whether the sprite can be moved onto
	 * @return if solid*/
	public boolean getSolid() {
		return this.isSolid;
	}
	public void setVisibility(boolean visibility) {
		this.isVisible = visibility;
	}
	/** Returns if the sprite is visible in the game countainer
	 * @return sprite's visibility in game*/
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
	/**Gets the sprite's name
	 * @return name of sprite*/
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
		// Sprite moving off right end of screen
		else if (x - this.spritePhoto.getWidth()/2 >= App.SCREEN_WIDTH) {
			this.setXLocation(0.0f - this.spritePhoto.getWidth()/2);
		}
		//Sprite moving off left end of screen
		else if (x  + this.spritePhoto.getWidth()/2 <= 0.0f) {
			this.setXLocation(App.SCREEN_WIDTH + this.spritePhoto.getWidth()/2);
		}
	}
}
