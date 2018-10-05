import org.newdawn.slick.Input;

public class Turtle extends Rideable{
	private static boolean isSolid = false;
	private static float rate = 0.085f;
	private static String imageAddress = "assets/turtles.png";

	
	private float myDelta = 0f;
	private float disappear = 7000f;
	private float reappear = 9000f;
	
	
	public Turtle(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
		this.setRideable(true);
		super.setName("TUTRLTE");
	}
	
	public void update(Input input, int delta) {
		// Obstacle's speed updated
		myDelta+= delta;
		super.move(delta);
		if (myDelta >= reappear) {
			super.setVisibility(true);
			super.setDanger(false);
			myDelta = 0;
		}
		else if (myDelta >= disappear) {
			super.setVisibility(false);
			super.setDanger(true);
		}
	}
	
	
}
