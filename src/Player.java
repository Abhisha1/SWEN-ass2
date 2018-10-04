//This program was written by Abhisha Nirmalathas for SWEN20003 Project 1
import java.util.ArrayList;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player extends Sprite {
	
	private float initialXPos;
	private float initialYPos;
	
	private ArrayList<Life> playerLives;
	
	public boolean isHit = false;
	
	public Player(String imageSrc, float x, float y){
		super(imageSrc, x, y);
		this.playerLives = Life.initialiseLives();
		initialXPos = this.getXLocation();
		initialYPos = this.getYLocation();
	}
	
	public void update(Input input, int delta, Player player) {
		// Updates the location of the player, moving one tile in the selected direction
		// whilst ensuring the update location is not outside the game container
		if (input.isKeyPressed(Input.KEY_UP) && ((this.getYLocation() - Tile.TILE_SIZE) >= 0 )) {
			this.setYLocation(this.getYLocation() - Tile.TILE_SIZE);
			player.getBoundingBox().setY(this.getYLocation());
		}
		
		else if (input.isKeyPressed(Input.KEY_DOWN) && ((this.getYLocation() + Tile.TILE_SIZE) < App.SCREEN_HEIGHT )) {
			this.setYLocation(this.getYLocation() + Tile.TILE_SIZE);
			player.getBoundingBox().setY(this.getYLocation());
		}
		
		else if (input.isKeyPressed(Input.KEY_LEFT) && ((this.getXLocation() - Tile.TILE_SIZE) >= 0 )) {
			this.setXLocation(this.getXLocation() - Tile.TILE_SIZE);
			player.getBoundingBox().setX(this.getXLocation());
		}
		
		else if (input.isKeyPressed(Input.KEY_RIGHT) && ((this.getXLocation() + Tile.TILE_SIZE) < App.SCREEN_WIDTH )) {
			this.setXLocation(this.getXLocation() + Tile.TILE_SIZE);
			player.getBoundingBox().setX(this.getXLocation());
		}
	}
	public ArrayList<Life> getLives(){
		return this.playerLives;
	}
	
	public void resetPlayer() {
		this.setXLocation(initialXPos);
		this.setYLocation(initialYPos);
	}
	
	private boolean reachedFinalLocation(Sprite a) {
		return false;
	}
	


}
