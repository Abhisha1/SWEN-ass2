import org.newdawn.slick.Input;

public class Movable extends Sprite{
	private float rate;
	private boolean moveToRight;
	
	public Movable(float rate, float x, float y, String imageAddress, boolean moveRight) {
		super(imageAddress, x, y);
		this.rate = rate;
		this.moveToRight = moveRight;
		super.priority = Sprite.MEDIUM_PRIORITY;
	}
	
	public void move(int delta) {
		// Obstacle's speed updated
		this.wrapXLocation(this.getXLocation() + this.rate*delta*moveDirection(this.moveToRight));
		this.getBoundingBox().setX(this.getXLocation());
	}
	
	public int moveDirection(boolean moveRight) {
		if (moveRight) {
			return 1;
		}
		return -1;
	}
	
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getRate() {
		return this.rate;
	}
	public void setMoveToRight(boolean rate) {
		this.moveToRight = rate;
	}
	public boolean getMoveToRight() {
		return this.moveToRight;
	}
	
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
		move(delta);
		
	}
	public void pushSprite(int delta, Sprite sprite) {
		sprite.wrapXLocation(sprite.getXLocation() + rate*delta*moveDirection(moveToRight));
		sprite.getBoundingBox().setX(sprite.getXLocation());
	}
}
