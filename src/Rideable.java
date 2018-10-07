/**
 * Handles a sub class of Movable objects, which an object can ride on.
 */
public class Rideable extends Movable{
	private static boolean isPushable = true;
	/** Creates an object of the class Rideable
	 * @param rate Speed at which Rideable object moves at.
     * @param x The x coordinate of object.
     * @param y The y coordinate of object.
     * @param imageAddres The file path containing the image for the object.
     * @param moveRight A boolean which determines if object moves right or left.
	 */
	public Rideable(float rate, float x, float y, String imageAddress, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight); 
		super.setRate(rate);
		super.setPushable(isPushable);
		super.setName("rideable");
		
	}
	
	

}
