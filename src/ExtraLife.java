import java.util.Random;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class ExtraLife extends Sprite{
	private static int randomSeconds;
	private static int nthLog;
	
	private static int maxSeconds = 35;
	private static int minSeconds = 25;
	private static String imageAddress = "assets/extralife.png";
	
	Log log;
	
	private boolean moveToRight = true;
	private float moveOnLog = 2000f;
	
	static Random rand = new Random();
	
	private float myDelta = 0f;
	
	
	public ExtraLife(ArrayList<Sprite> sprites) {
		super(imageAddress, 0f, 0f);
		super.setName("extra life");
		super.priority = Sprite.HIGH_PRIORITY;
		this.setVisibility(true);
		this.createBoundingBox(this);
		selectLog(sprites);
		try {
			this.setXLocation(log.getXLocation());
			this.setYLocation(log.getYLocation());
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	private void selectLog(ArrayList<Sprite> sprites) {
		int counter = 0;
		for (Sprite a: sprites) {
			if (a.getName().equals("log")) {
				counter++;
			}
			if (counter == nthLog && a.getName().equals("log")) {
				log = (Log)a;
				break;
			}
		}
	}
	public static void initialiseSpawning(ArrayList<Sprite> sprites) {
		randomSeconds = (rand.nextInt(5))*1000;
	//	randomSeconds = (rand.nextInt(maxSeconds-minSeconds)+minSeconds)*1000;
		nthLog = rand.nextInt(Log.getNumberOfLogs(sprites)-1);
		
	}
	
	public static int spawnTimeExtraLife() {
		return randomSeconds;
	}
	public void removeExtraLife(ArrayList<Sprite> sprites) {
		selectLog(sprites);
		this.setVisibility(false);
		sprites.remove(this);
		log = null;
	}
	
	
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
		myDelta+=delta;
		logDirectionTraversal();
		if (myDelta >= moveOnLog) {
			this.setXLocation(this.getXLocation() + Tile.TILE_SIZE*log.moveDirection(this.moveToRight));
			myDelta = 0f;
		}
		if (!log.equals(null) && !this.equals(null)) {
			log.pushSprite(delta, (Sprite)this);
		}
		
	}
	
	private void logDirectionTraversal() {
		System.out.format("box"+this.getBoundingBox().getRight()+"   "+log.getBoundingBox().getRight()+"\n");
		if (this.getBoundingBox().getRight()+Tile.TILE_SIZE > log.getBoundingBox().getRight() && this.moveToRight) {
			this.moveToRight = false;
		}
		else {
			this.moveToRight = true;
		}
	}
	
	
	

}
