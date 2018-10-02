
public class Racecar extends Vehicle{
	private static boolean isSolid = false;
	private static float rate = 0.5f;
	private static String imageAddress = "assets/racecar.png";
	
	public Racecar(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
	}
}
