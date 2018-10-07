/**
 * A sub class of Movable for sprites in which a player should lose a life generally
 * if made contact with.
 * Handles the initialisation of Vehicles*/

public class Vehicle extends Movable{
	
	/**Creates an object of class Vehicle
	 * @param rate Speed at which Vehicle object moves at.
	 * @param x The x coordinate of object.
	 * @param y The y coordinate of object.
	 * @param imageAddress The file path containing the image for the object.
	 * @param moveRight A boolean which determines if object moves right or left.
	 */
	public Vehicle(float rate, float x, float y, String imageAddress, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight); 
		super.setDanger(true);
		super.setName("vehicle");
		
	}
	
	
	

}
