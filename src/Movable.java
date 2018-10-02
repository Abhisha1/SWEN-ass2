import org.newdawn.slick.Input;

public class Movable extends Sprite{
	private float rate;
	private boolean moveToRight;
	
	public Movable(float rate, float x, float y, String imageAddress, boolean moveRight) {
		super(imageAddress, x, y);
		this.rate = rate;
		this.moveToRight = moveRight;
	}
	
	public void move(int delta) {
		// Obstacle's speed updated
		this.setXLocation(this.getXLocation() + this.rate*delta*moveDirection(this.moveToRight));
		this.getBoundingBox().setX(this.getXLocation());
	}
	
	public int moveDirection(boolean moveRight) {
		if (moveRight) {
			return 1;
		}
		return -1;
	}
	

	
	
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
		move(delta);
		
	}
	public void setXLocation(float x) {
		// Updates the location of obstacle to newly computed value or either end of game container
		super.setXLocation(x);
		if (x > 0 && x <= App.SCREEN_WIDTH) {
			super.setXLocation(x);
		}
		else if (x - this.spritePhoto.getWidth()/2 >= App.SCREEN_WIDTH) {
			super.setXLocation(0.0f - this.spritePhoto.getWidth()/2);
		}
		
		else if (x  + this.spritePhoto.getWidth()/2 <= 0.0f) {
			super.setXLocation(App.SCREEN_WIDTH + this.spritePhoto.getWidth()/2);
		}
	}
}
