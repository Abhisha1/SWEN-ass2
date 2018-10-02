
public class Bulldozer extends Movable{
	private static boolean isSolid = false;
	private static float rate = 0.05f;
	private static String imageAddress = "assets/bulldozer.png";
	
	public Bulldozer(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
		this.setDanger(false);
		this.setSolid(true);
	}
}
