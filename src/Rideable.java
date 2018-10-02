
public class Rideable extends Movable {
	
	public Rideable(float rate, float x, float y, String imageAddress, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight); 
		super.setRideable(true);
		
	}
	
	public void pushPlayer(Player player) {
		
	}

}
