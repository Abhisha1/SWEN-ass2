
public class Racecar extends Vehicle{
	private static boolean isSolid = false;
	private static float rate = 0.5f;
	private static String imageAddress = "assets/racecar.png";
	
	/** Creates an object of class Racecar
	 * @param x The x coordinate of the racecar.
	 * @param y The y coordinate of the racecar.
	 * @param moveRight Whether the racecar moves right or left.
	 * */
	public Racecar(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
	}
}
