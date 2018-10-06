
public class Bulldozer extends Movable implements Pusher{
	private static boolean isSolid = true;
	private static float rate = 0.05f;
	private static String imageAddress = "assets/bulldozer.png";
	
	public Bulldozer(float x, float y, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight);
		this.setDanger(false);
		this.setSolid(true);
		super.isPushable = true;
	}
	public void pushSprite(int delta, Sprite sprite) {
		sprite.setXLocation(sprite.getXLocation() + super.getRate()*delta*moveDirection(super.getMoveToRight()));
		sprite.getBoundingBox().setX(sprite.getXLocation());
	}
	
}
