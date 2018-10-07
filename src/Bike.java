/**
 * A sub class of vehicle which contains a bike,
 * an object which changes direction at regular intervals as specified
 * by the game spec.
 * Handles all the intialisation and movement of the bike.*/

public class Bike extends Vehicle{
	private static final float[] REVERSE_LOCS = {24f, 1000f};
	
	private static float rate = 0.2f;
	private static String imageAddress = "assets/bike.png";
	private static String name = "bike";
		
	
	private int currentDirection;
	/** Creates an object of class Bike
     * @param x The x coordinate of object.
     * @param y The y coordinate of object.
     * @param moveRight A boolean which determines if object moves right or left.
     */
	public Bike(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
		this.currentDirection = moveDirection(moveRight);
		this.setName(name);
	}
	/** Moves the bike such that it reverses direction at the user defined x coordinates
     * @param delta Time passed since last frame (milliseconds).
     */
	@Override
	public void move(int delta) {
		// Obstacle's speed updated
		float buffer;
		for (float a: REVERSE_LOCS) {
			// Computes a buffer size distance which triggers the bike to change location
			buffer = Math.abs(this.getXLocation()-a);
			if (buffer < delta*rate) {
				this.currentDirection*= -1;
			}
		}
		this.setXLocation(this.getXLocation() + rate*delta*this.currentDirection);
		this.getBoundingBox().setX(this.getXLocation());
	}
}
