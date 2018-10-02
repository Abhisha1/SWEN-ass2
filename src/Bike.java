
public class Bike extends Vehicle{
	private static final int[] REVERSE_LOCS = {24, 100};
	
	private static boolean isSolid = false;
	private static float rate = 0.2f;
	private static String imageAddress = "assets/bike.png";
		
	
	private int currentDirection;
	
	public Bike(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
		this.currentDirection = moveDirection(moveRight);
	}
	
	public void move(int delta) {
		// Obstacle's speed updated
		for (int a: REVERSE_LOCS) {
			if (this.getXLocation() == a) {
				this.currentDirection*= -1;
			}
		}
		this.setXLocation(this.getXLocation() + rate*delta*this.currentDirection);
		this.getBoundingBox().setX(this.getXLocation());
	}
}
