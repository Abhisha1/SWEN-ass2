import java.util.ArrayList;

public abstract class FinalLocation {
	public static int GAPS_TO_FILL = 1;
	private static float yPos = Float.MIN_VALUE;
	
	public static void setYPos(float treeYPos) {
		if (yPos< treeYPos) {
			yPos = treeYPos;
		}
	}
	
	public static boolean isGapFilled(Player player, ArrayList<Sprite> sprites) {
		if (player.getYLocation() == yPos){
			Sprite gapFilledFrog = new Sprite("assets/frog.png", player.getXLocation(), player.getYLocation());
			gapFilledFrog.setSolid(true);
			gapFilledFrog.createBoundingBox(gapFilledFrog);
			sprites.add(gapFilledFrog);
			GAPS_TO_FILL--;
			player.resetPlayer();
			return true;
		}
		return false;
	}
}
