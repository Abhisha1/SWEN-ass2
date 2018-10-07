/**
 * A sub class of Movable, which is a bulldozer.
 * Objects of this class push the player along.
 * Initialisation and movement of bulldozers handled here.*/
public class Bulldozer extends Movable{
	private static boolean isSolid = true;
	private static boolean isDanger = false;
	private static boolean isPushable = true;
	private static float rate = 0.05f;
	private static String imageAddress = "assets/bulldozer.png";
	private static String name = "bulldozer";
	
	/** Creates an object of class Bulldozer
	 * @param x The x coordinate of the bulldozer.
	 * @param y The y coordinate of the bulldozer.
	 * @param moveRight Whether the bulldozer moves right or left.
	 * */
	public Bulldozer(float x, float y, boolean moveRight) {
		// Ensures bulldozer pushes the player but cannot be moved onto (solid).
		super(rate, x, y, imageAddress, moveRight);
		this.setDanger(isDanger);
		this.setSolid(isSolid);
		this.setPushable(isPushable);
		this.setName(name);
	}
}
