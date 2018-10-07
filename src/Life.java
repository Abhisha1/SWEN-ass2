import java.util.ArrayList;
/**
 * Handles the attempts the player has at the game before it hits a danger sprite.
 */
public class Life extends Sprite{
	/**The number of lives a player has, with the default set to 3*/
	public static int livesCount = 3;
	private static int minLives = 0;
	
	private static float XPos = 24f;
	private static float YPos = 744f;
	private static float pixelSize = 32f;
	private static String imageAddress = "assets/lives.png";
	private static String name = "life";
	
	
	private static ArrayList<Life> playerLives = new ArrayList<Life>(3);
	
	/**Creates an object of the class Life
	 * @param x The x coordinate of the life.
	 * @param y The y coordinate of the life.
	 */
	public Life(float x, float y) {
		super(imageAddress, x, y); 
		this.setName(name);
	}
	/**Creates the players initial set of lives which the player has for the entire game.
	 * @return An array containing the players lives.
	 */
	public static ArrayList<Life> initialiseLives(){
		for (int i = 0; i < livesCount; i++) {
			playerLives.add(new Life(XPos, YPos));
			XPos+=pixelSize;
		}
		return playerLives;
	}
	/** Player loses a life object.
	 * @param player The game player/user.
	 */
	public static void loseLife(Player player) {
		if (livesCount > minLives) {
			player.getLives().remove(livesCount-1);
			livesCount--;
			XPos -= pixelSize;
			player.resetPlayer();
		}
	}
	/** Player gains a life object.
	 */
	public static void gainLife() {
		livesCount++;
		playerLives.add(new Life(XPos, YPos));
		System.out.println("got a ilife");
		XPos += pixelSize;
	}
}
