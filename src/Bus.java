
public class Bus extends Vehicle{
	private static boolean isSolid = false;
	private static float rate = 0.15f;
	private static String imageAddress = "assets/bus.png";
	
	
	/** Creates an object of class Bus
	 * @param x The x coordinate of the bus.
	 * @param y The y coordinate of the bus.
	 * @param moveRight Whether the bus moves right or left.
	 * */
	public Bus(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
	}
	
	
}
