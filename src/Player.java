//This program was written by Abhisha Nirmalathas for SWEN20003 Project 1
import java.util.ArrayList;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player extends Sprite {
	
	private float initialXPos;
	private float initialYPos;
	
	private ArrayList<Life> playerLives;
	
	public boolean isHit = false;
	
	private boolean onRideable = false;
	
	private Rideable rideable;
	
	private Bulldozer bulldozer;
	
	private boolean isPushed = false;
	
	
	public Player(String imageSrc, float x, float y){
		super(imageSrc, x, y);
		this.playerLives = Life.initialiseLives();
		initialXPos = this.getXLocation();
		initialYPos = this.getYLocation();
	}
	
	public void update(Input input, int delta, Player player) {
		// Updates the location of the player, moving one tile in the selected direction
		// whilst ensuring the update location is not outside the game container
		
		if (this.onRideable) {
			rideable.pushSprite(delta, (Sprite)player);
		}
		if (this.isPushed) {
			bulldozer.pushSprite(delta, (Sprite)player);
		}
		
		if (input.isKeyPressed(Input.KEY_UP) && ((this.getYLocation() - Tile.TILE_SIZE) >= 0 )) {
			this.setYLocation(this.getYLocation() - Tile.TILE_SIZE);
			player.getBoundingBox().setY(this.getYLocation());
			this.onRideable = false;
			this.isPushed = false;
		}
		
		else if (input.isKeyPressed(Input.KEY_DOWN) && ((this.getYLocation() + Tile.TILE_SIZE) < App.SCREEN_HEIGHT )) {
			this.setYLocation(this.getYLocation() + Tile.TILE_SIZE);
			player.getBoundingBox().setY(this.getYLocation());
			this.onRideable = false;
			this.isPushed = false;
		}
		
		else if (input.isKeyPressed(Input.KEY_LEFT) && ((this.getXLocation() - Tile.TILE_SIZE) >= 0 )) {
			this.setXLocation(this.getXLocation() - Tile.TILE_SIZE);
			player.getBoundingBox().setX(this.getXLocation());
			this.onRideable = false;
			this.isPushed = false;
		}
		
		else if (input.isKeyPressed(Input.KEY_RIGHT) && ((this.getXLocation() + Tile.TILE_SIZE) < App.SCREEN_WIDTH )) {
			this.setXLocation(this.getXLocation() + Tile.TILE_SIZE);
			player.getBoundingBox().setX(this.getXLocation());
			this.onRideable = false;
			this.isPushed = false;
		}
	}
	public ArrayList<Life> getLives(){
		return this.playerLives;
	}
	
	public void resetPlayer() {
		deattachToRideable(rideable);
		deattachToBulldozer(bulldozer);
		this.setXLocation(initialXPos);
		this.setYLocation(initialYPos);
		System.out.println("***");
		System.out.println(onRideable);
	}
	
	private boolean reachedFinalLocation(Sprite a) {
		return false;
	}
	
	public void attachToRideable(Rideable rideable) {
		this.rideable = rideable;
		this.onRideable = true;
	}
	private void deattachToRideable(Rideable rideable) {
		this.rideable = null;
		this.onRideable = false;
	}
	public void attachToBulldozer(Bulldozer bulldozer) {
		this.bulldozer = bulldozer;
		this.isPushed = true;
	}
	private void deattachToBulldozer(Bulldozer bulldozer) {
		this.bulldozer = null;
		this.isPushed = false;
	}



}
