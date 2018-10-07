
public class Bulldozer extends Movable{
	private static boolean isSolid = true;
	private static float rate = 0.05f;
	private static String imageAddress = "assets/bulldozer.png";
	
	/** Creates an object of class Bulldozer
	 * @param x The x coordinate of the bulldozer.
	 * @param y The y coordinate of the bulldozer.
	 * @param moveRight Whether the bulldozer moves right or left.
	 * */
	public Bulldozer(float x, float y, boolean moveRight) {
		// Ensures bulldozer pushes the player but cannot be moved onto (solid).
		super(rate, x, y, imageAddress, moveRight);
		this.setDanger(false);
		this.setSolid(true);
		this.setPushable(true);
	}
}
