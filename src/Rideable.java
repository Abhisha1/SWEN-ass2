
public class Rideable extends Movable{
	public Rideable(float rate, float x, float y, String imageAddress, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight); 
		super.setRate(rate);
		super.setMoveToRight(moveRight);
		super.setPushable(true);
		super.setName("rideable");
		
	}
	
	

}
