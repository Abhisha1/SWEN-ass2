import org.newdawn.slick.Input;

/**
 * A sub class of Sprite which handles all moving objects*/
public class Movable extends Sprite{
	
	private float rate;
	
	private boolean moveToRight;
	/** Creates an object of class Movable
     * @param rate Speed at which Movable object moves at.
     * @param x The x coordinate of object.
     * @param y The y coordinate of object.
     * @param imageAddres The file path containing the image for the object.
     * @param moveRight A boolean which determines if object moves right or left.
     */
	public Movable(float rate, float x, float y, String imageAddress, boolean moveRight) {
		super(imageAddress, x, y);
		this.rate = rate;
		this.moveToRight = moveRight;
		super.priority = Sprite.MEDIUM_PRIORITY;
	}
	/** Moves the object at the respective rate
     * @param delta Number of milliseconds elapsed since last frame.
     */
	public void move(int delta) {
		// Obstacle's speed updated
		this.wrapXLocation(this.getXLocation() + this.rate*delta*moveDirection(this.moveToRight));
		this.getBoundingBox().setX(this.getXLocation());
	}
	/** Converts the Move Right boolean into a integer value to determine direction
     * @param moveRight A boolean which states whether object moves right (true) or left (false).
     * @return Integer representation of direction of travel.
     */
	public int moveDirection(boolean moveRight) {
		if (moveRight) {
			return 1;
		}
		return -1;
	}
	/** Updates the rate of object
	 * @param rate The new rate of the object.
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}
	/** Gets the rate of the object.
	 * @return float The rate of the object.
	 */
	public float getRate() {
		return this.rate;
	}
	/** Update the game state for a movable object.
     * @param delta Time passed since last frame (milliseconds).
     * @param input The user input.
     */
	@Override
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
		move(delta);
		
	}
	/** Moves the sprite at the same rate as the movable object.
     * @param delta Time passed since last frame (milliseconds).
     * @param sprite A drawable object in game.
     */
	public void pushSprite(int delta, Sprite sprite) {
		// Moves the object along with the moving object it is riding/pushed by along with being wrapped
		// around the game container like the moving object
		sprite.wrapXLocation(sprite.getXLocation() + rate*delta*moveDirection(moveToRight));
		sprite.getBoundingBox().setX(sprite.getXLocation());
	}
}
