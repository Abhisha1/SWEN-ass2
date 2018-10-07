/**A sub class of Vehicle which handles the objects Bus.
 * This objects results in death for the player or loss 
 * of life if collided with.
 * Initialisation and movement of bus handled here
 * */
public class Bus extends Vehicle{
	private static float rate = 0.15f;
	private static String imageAddress = "assets/bus.png";
	private static String name = "bus";
	
	
	/** Creates an object of class Bus
	 * @param x The x coordinate of the bus.
	 * @param y The y coordinate of the bus.
	 * @param moveRight Whether the bus moves right or left.
	 * */
	public Bus(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
		this.setName(name);
	}
	
	
}
