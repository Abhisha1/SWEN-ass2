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
	
	/** The x position of sprite*/
	private float xLocation;
	
	/**The y position of sprite*/
	private float yLocation;
	
	/**If object can be moved on top of*/
	private boolean isSolid = false;
	
	/**If touching this object results in player losing life*/
	private boolean isDanger = false;
	
	/**If touching this object causes player to move/ride with it*/
	private boolean isRideable = false;
	
	/**Name of object*/
	private String name;
	
	
	private BoundingBox boundingBox;
	
	
	Image spritePhoto;
	
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
	
	public void createBoundingBox(Sprite sprite) {
		// Makes a bounding box for sprite
		boundingBox = new BoundingBox(sprite.spritePhoto, sprite.getXLocation(), sprite.getYLocation());
		
	}
	
	public BoundingBox getBoundingBox() {
		//returns the bounding box via getter method
		return this.boundingBox;
	}
	
	public boolean hasBoundingBox(BoundingBox box) {
		// checks if bounding box exists
		if (box.equals(null)) {
			return false;
		}
		return true;
	}
	
	public void update(Input input, int delta) {
		// How can this one method deal with different types of sprites?
	}
	
	public void render() {
		this.spritePhoto.drawCentered(this.xLocation, this.yLocation);
		// This should be pretty simple.
		
	}
	
	public void contactSprite(Sprite other) {
		// Should be called when one sprite makes contact with another. 
		if (this.getBoundingBox().intersects(other.getBoundingBox())) {
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
	public void setRideable(boolean isRideable) {
		this.isRideable = isRideable;
	}
	public boolean getRideable() {
		return this.isRideable;
	}
	public void setYLocation(float y) {
		// sets y coordinate value
			this.yLocation = y;
	}
	public void setName(String name) {
		// sets y coordinate value
			this.name = name;
	}
	public String getName() {
		// sets y coordinate value
			return this.name;
	}
}
