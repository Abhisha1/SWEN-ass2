
public class Bus extends Vehicle{
	private static boolean isSolid = false;
	private static float rate = 0.15f;
	private static String imageAddress = "assets/bus.png";
	
	public Bus(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
	}
	
	
}
