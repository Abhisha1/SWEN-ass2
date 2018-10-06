//This program was written by Abhisha Nirmalathas for SWEN20003 Project 1
import java.util.ArrayList;


import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import utilities.BoundingBox;
public class Player extends Sprite {
	
	private float initialXPos;
	private float initialYPos;
	
	private ArrayList<Life> playerLives;
	
	public boolean isHit = false;
	
	
	private Movable pusher;
	
	private boolean isPushed = false;
	
	private boolean isLeftValid =true;
	private boolean isRightValid = true;
	private boolean isUpValid = true;
	private boolean isDownValid = true;
	
	private BoundingBox nextMoveChecker;
	
	
	public Player(String imageSrc, float x, float y){
		super(imageSrc, x, y);
		this.playerLives = Life.initialiseLives();
		initialXPos = this.getXLocation();
		initialYPos = this.getYLocation();
		nextMoveChecker = new BoundingBox(this.spritePhoto, initialXPos, initialYPos);
	}
	
	public void update(Input input, int delta, Player player) {
		// Updates the location of the player, moving one tile in the selected direction
		// whilst ensuring the update location is not outside the game container
		
		if (this.isPushed) {
			pusher.pushSprite(delta, (Sprite)player);
		}
		
		if (input.isKeyPressed(Input.KEY_UP) && ((this.getYLocation() - Tile.TILE_SIZE) >= 0 ) && isUpValid) {
			this.setYLocation(this.getYLocation() - Tile.TILE_SIZE);
			player.getBoundingBox().setY(this.getYLocation());
			this.isPushed = false;
		}
		
		else if (input.isKeyPressed(Input.KEY_DOWN) && ((this.getYLocation() + Tile.TILE_SIZE) < App.SCREEN_HEIGHT ) && isDownValid) {
			this.setYLocation(this.getYLocation() + Tile.TILE_SIZE);
			player.getBoundingBox().setY(this.getYLocation());
			this.isPushed = false;
		}
		
		else if (input.isKeyPressed(Input.KEY_LEFT) && ((this.getXLocation() - Tile.TILE_SIZE) >= 0 ) && isLeftValid) {
			this.setXLocation(this.getXLocation() - Tile.TILE_SIZE);
			player.getBoundingBox().setX(this.getXLocation());
			this.isPushed = false;
		}
		
		else if (input.isKeyPressed(Input.KEY_RIGHT) && ((this.getXLocation() + Tile.TILE_SIZE) < App.SCREEN_WIDTH ) && isRightValid) {
			this.setXLocation(this.getXLocation() + Tile.TILE_SIZE);
			player.getBoundingBox().setX(this.getXLocation());
			this.isPushed = false;
		}
		resetValidMoves();
	}
	public ArrayList<Life> getLives(){
		return this.playerLives;
	}
	
	public void resetPlayer() {
		deattachToPusher(pusher);
		resetValidMoves();
		this.setXLocation(initialXPos);
		this.setYLocation(initialYPos);
	}
	
	private boolean reachedFinalLocation(Sprite a) {
		return false;
	}
	
	public void attachToPusher(Movable pusher) {
		this.pusher = pusher;
		this.isPushed = true;
	}
	private void deattachToPusher(Movable pusher) {
		this.pusher = null;
		this.isPushed = false;
	}
	
	public void checkValidMoves(Sprite sprite) {
		float x = this.getXLocation();
		float y = this.getYLocation();
		nextMoveChecker.setX(x+Tile.TILE_SIZE);
		if (sprite.getBoundingBox().intersects(nextMoveChecker) && sprite.getSolid()) {
			isRightValid = false;
		}
		nextMoveChecker.setX(x-Tile.TILE_SIZE);
		if (sprite.getBoundingBox().intersects(nextMoveChecker) && sprite.getSolid()) {
			isLeftValid = false;
		}
		nextMoveChecker.setX(x);
		nextMoveChecker.setY(y+Tile.TILE_SIZE);
		if (sprite.getBoundingBox().intersects(nextMoveChecker) && sprite.getSolid()) {
			isDownValid = false;
		}
		nextMoveChecker.setY(y-Tile.TILE_SIZE);
		if (sprite.getBoundingBox().intersects(nextMoveChecker) && sprite.getSolid()) {
			isUpValid = false;
		}
		nextMoveChecker.setY(y);
	}
	
	private void resetValidMoves() {
		isLeftValid =true;
		isRightValid = true;
		isUpValid = true;
		isDownValid = true;
	}



}
