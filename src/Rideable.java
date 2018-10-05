
public class Rideable extends Movable {
	public Rideable(float rate, float x, float y, String imageAddress, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight); 
		super.setRate(rate);
		super.setMoveToRight(moveRight);
		super.setRideable(true);
		super.setName("rideable");
		
	}
	
	public void pushSprite(int delta, Sprite sprite) {
		sprite.setXLocation(sprite.getXLocation() + super.getRate()*delta*moveDirection(super.getMoveToRight()));
		sprite.getBoundingBox().setX(sprite.getXLocation());
	}
	

}
