import org.newdawn.slick.Input;
/** A sub class from rideable, which is a turtles.
 * These objects disappear underwater.
 * handles the initialisation and movement of Turtles.
 * */
public class Turtle extends Rideable{
	private static float rate = 0.085f;
	private static boolean isPushable = true;
	private static String imageAddress = "assets/turtles.png";
	private static String name = "turtle";

	
	private float myDelta = 0f;
	private float disappear = 7000f;
	private float reappear = 9000f;
	
	/** Creates an object of class Turtle
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param moveRight If the turtle moves right or left.
	 * */
	public Turtle(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
		this.setPushable(isPushable);
		super.setName(name);
	}
	/** Update the game state for a movable object.
     * @param delta Time passed since last frame (milliseconds).
     * @param input The user input.
     */
	@Override
	public void update(Input input, int delta) {
		// Obstacle's speed updated
		myDelta+= delta;
		super.move(delta);
		// turtle re emerges from water
		if (myDelta >= reappear) {
			super.setVisibility(true);
			super.setDanger(false);
			myDelta = 0;
		}
		// turtle disappears so player is no longer safe from water
		else if (myDelta >= disappear) {
			super.setVisibility(false);
			super.setDanger(true);
		}
	}
	
	
}
