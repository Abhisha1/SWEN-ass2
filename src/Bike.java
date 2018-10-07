
public class Bike extends Vehicle{
	private static final float[] REVERSE_LOCS = {24f, 1000f};
	
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
		float buffer;
		for (float a: REVERSE_LOCS) {
			buffer = Math.abs(this.getXLocation()-a);
			if (buffer <= delta*rate) {
				this.currentDirection*= -1;
			}
		}
		//System.out.println(delta);
		this.setXLocation(this.getXLocation() + rate*delta*this.currentDirection);
		this.getBoundingBox().setX(this.getXLocation());
	}
}
