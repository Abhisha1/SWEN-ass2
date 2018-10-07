/** A subclass from vehicle which handles the initialisation
 * and movement of racecars.
 * */
public class Racecar extends Vehicle{
	private static float rate = 0.5f;
	private static String imageAddress = "assets/racecar.png";
	private static String name = "racecar";
	
	/** Creates an object of class Racecar
	 * @param x The x coordinate of the racecar.
	 * @param y The y coordinate of the racecar.
	 * @param moveRight Whether the racecar moves right or left.
	 * */
	public Racecar(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
		this.setName(name);
	}
}
