
public class Turtle extends Rideable{
	private static boolean isSolid = false;
	private static float rate = 0.085f;
	private static String imageAddress = "assets/turtles.png";
	
	public Turtle(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
		this.setRideable(true);
	}
}
