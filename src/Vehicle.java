
public class Vehicle extends Movable{
	
	
	public Vehicle(float rate, float x, float y, String imageAddress, boolean moveRight) {
		super(rate, x, y, imageAddress, moveRight); 
		super.setDanger(true);
		super.setName("vehicle");
		
	}
	
	
	

}
