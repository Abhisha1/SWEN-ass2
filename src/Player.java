//This program was written by Abhisha Nirmalathas for SWEN20003 Project 1
import java.util.ArrayList;
import org.newdawn.slick.Input;
import utilities.BoundingBox;

public class Player extends Sprite {
	
	private float initialXPos;
	private float initialYPos;
	
	private ArrayList<Life> playerLives;
	
	/**Whether player has hit another sprite*/
	public boolean isHit = false;
	
	// Object that player travels on (rideable) or is pushed by (bulldozer).
	private Movable pusher;
	
	private boolean isPushed = false;
	
	/**Whether player has just got an extra life*/
	public boolean gotExtraLife = false;
	
	private boolean isLeftValid =true;
	private boolean isRightValid = true;
	private boolean isUpValid = true;
	private boolean isDownValid = true;
	
	private BoundingBox nextMoveChecker;
	
	/**Creates object of class Player
	 * @param imageSrc A string containing the file path for image.
     * @param x The x location of the sprite.
     * @param y The y location of the sprite.
     */
	public Player(String imageSrc, float x, float y){
		super(imageSrc, x, y);
		this.playerLives = Life.initialiseLives();
		initialXPos = this.getXLocation();
		initialYPos = this.getYLocation();
		nextMoveChecker = new BoundingBox(this.spritePhoto, initialXPos, initialYPos);
	}
	/** Update the game state for a frame for a player.
     * @param delta Time passed since last frame (milliseconds).
     * @param input The user input.
     */
	public void update(Input input, int delta, Player player) {
		// Updates the location of the player, moving one tile in the selected direction
		// whilst ensuring the update location is not outside the game container
		
		if (player.isPushed) {
			pusher.pushSprite(delta, (Sprite)this);
		}
		
		if (input.isKeyPressed(Input.KEY_UP) && ((this.getYLocation() - Tile.TILE_SIZE) >= 0 ) && isUpValid) {
			this.setYLocation(this.getYLocation() - Tile.TILE_SIZE);
			this.getBoundingBox().setY(this.getYLocation());
			player.isPushed = false;
		}
		
		else if (input.isKeyPressed(Input.KEY_DOWN) && ((this.getYLocation() + Tile.TILE_SIZE) < App.SCREEN_HEIGHT ) && isDownValid) {
			this.setYLocation(this.getYLocation() + Tile.TILE_SIZE);
			this.getBoundingBox().setY(this.getYLocation());
			player.isPushed = false;
		}
		
		else if (input.isKeyPressed(Input.KEY_LEFT) && ((this.getXLocation() - Tile.TILE_SIZE) >= 0 ) && isLeftValid) {
			this.setXLocation(this.getXLocation() - Tile.TILE_SIZE);
			this.getBoundingBox().setX(this.getXLocation());
			player.isPushed = false;
		}
		
		else if (input.isKeyPressed(Input.KEY_RIGHT) && ((this.getXLocation() + Tile.TILE_SIZE) < App.SCREEN_WIDTH ) && isRightValid) {
			this.setXLocation(this.getXLocation() + Tile.TILE_SIZE);
			this.getBoundingBox().setX(this.getXLocation());
			player.isPushed = false;
		}
		resetValidMoves();
	}
	/** Gets the list of lives the player has
     * @return Array of player lives
     */
	public ArrayList<Life> getLives(){
		return this.playerLives;
	}
	/** Resets the player by moving back to initial coordinates when game begins
     */
	public void resetPlayer() {
		// Resets the players location, valid moves and any sprites it was attached to.
		deattachToPusher(pusher);
		resetValidMoves();
		this.setXLocation(initialXPos);
		this.setYLocation(initialYPos);
	}
	
	private boolean reachedFinalLocation(Sprite a) {
		return false;
	}
	/** Attaches player to a movable object
     */
	public void attachToPusher(Movable pusher) {
		this.pusher = pusher;
		this.isPushed = true;
	}/** Removes player to a movable object
     */
	private void deattachToPusher(Movable pusher) {
		this.pusher = null;
		this.isPushed = false;
	}
	/** Checks whether the player can move up, down, left or right without moving
	 *  into a solid object.
	 *  @param sprite A drawable object in game.
     */
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
		// resets x position
		nextMoveChecker.setX(x);
		nextMoveChecker.setY(y+Tile.TILE_SIZE);
		if (sprite.getBoundingBox().intersects(nextMoveChecker) && sprite.getSolid()) {
			isDownValid = false;
		}
		nextMoveChecker.setY(y-Tile.TILE_SIZE);
		if (sprite.getBoundingBox().intersects(nextMoveChecker) && sprite.getSolid()) {
			isUpValid = false;
		}
		//resets y position
		nextMoveChecker.setY(y);
	}
	
	private void resetValidMoves() {
		// Resets all restricted moves for player.
		isLeftValid =true;
		isRightValid = true;
		isUpValid = true;
		isDownValid = true;
	}


}
