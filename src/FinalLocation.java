import java.util.ArrayList;
/** The Final position that needs to be filled.
 * Handles whether a level has been completed.
 * */
public class FinalLocation {
	
	// The number of holes the player must fill
	private int gapsToFill = 5;
	private static float yPos = Float.MIN_VALUE;
	/** Sets the position of the holes as the last line of trees.
     * @param treeYPos The final y coordinate for the lowest tree line.
     */
	public static void setYPos(float treeYPos) {
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
		if (player.getYLocation() == yPos){
			Sprite gapFilledFrog = new Sprite("assets/frog.png", player.getXLocation(), player.getYLocation());
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
	 * @return the number fo gaps to be filled to complete level*/
	public int getGapsToFill() {
		return this.gapsToFill;
	}
}
