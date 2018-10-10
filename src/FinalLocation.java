import java.util.ArrayList;
/** The Final position that needs to be filled.
 * Handles whether a level has been completed.
 * */
public class FinalLocation {
	
	// The number of holes the player must fill
	private int gapsToFill = 5;
	private static float yPos = Float.MIN_VALUE;
	
	
	private ArrayList<Float> gapMidPoints = new ArrayList<Float>();
	
	/** Sets the position of the holes as the last line of trees.
     * @param treeYPos The final y coordinate for the lowest tree line.
     */
	public static void setYPos(float treeYPos) {
		// Gets the lowest y position as the lowest y tree tiles are where the gaps are.
		if (yPos< treeYPos) {
			yPos = treeYPos;
		}
	}
	/** Checks if the gap is filled by a player and updates the gap to be a solid tile.
     * @param player The game player.
     * @param sprites The list of drawable objects.
     * @return boolean Indicates whether the gap has been filled or not.
     */
	public boolean isGapFilled(Player player, ArrayList<Sprite> sprites) {
		// Ensures the player is at the y position with the gaps
		if (player.getYLocation() == yPos){
			// Renders the frog at the centre of the hole and resets the player such that they can resume playing
			Sprite gapFilledFrog = new Sprite("assets/frog.png", getNearestGap(player.getXLocation()), player.getYLocation());
			gapFilledFrog.setSolid(true);
			gapFilledFrog.createBoundingBox(gapFilledFrog);
			sprites.add(gapFilledFrog);
			gapsToFill--;
			player.resetPlayer();
			return true;
		}
		return false;
	}
	/** Gets the number of gaps to Fill
	 * @return the number of gaps to be filled to complete level*/
	public int getGapsToFill() {
		return gapsToFill;
	}
	// Computes the midpoint between to x coordinates
	private void gapMidPoint(float xUpper, float xLower){
		gapMidPoints.add(((xUpper-xLower)/2)+xLower);
	}
	/** Reads all the tree tiles and computes the midpoint for every hole that
	 *  the player must fill.
	 *  @param tiles A list of Tile object which are all trees
	 * */
	public void readTrees(ArrayList<Tile> tiles) {
		float xLower = Float.MIN_VALUE;
		float xUpper  = Float.MIN_VALUE;
		for (Tile a: tiles) {
			// Ensures the trees are at the same y location as the holes to be filled.
			if (a.getYLocation() == yPos && a.getXLocation() > xUpper) {
				xLower = xUpper;
				
				xUpper = a.getXLocation();
				// Adds the midpoint of tiles which are not neighboring each other
				if (xLower != Float.MIN_VALUE && (xUpper-xLower) > Tile.TILE_SIZE) {
					gapMidPoint(xUpper, xLower);
				}
			}
		}
	}
	
	
	
	// Ensures that when the player has reached the final location, the nearest midpoint
	// is found such that it is rendered in the centre of the gap
	private float getNearestGap(float x) {
		for (float midPoint: gapMidPoints) {
			if (Math.abs(x-midPoint) <= Tile.TILE_SIZE) {
				return midPoint;
			}
		}
		return x;
	}
}
