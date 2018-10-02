import java.util.ArrayList;

public class Life extends Sprite{
	public static int livesCount = 3;
	private static int minLives = 0;
	
	private static float XPos = 24f;
	private static float YPos = 744f;
	private static float pixelSize = 32f;
	private static String imageAddress = "assets/lives.png";
	
	public Life(float x, float y) {
		super(imageAddress, x, y); 
	}
	
	public static ArrayList<Life> initialiseLives(){
		ArrayList<Life> playerLives = new ArrayList<Life>(3);
		for (int i = 0; i < livesCount; i++) {
			playerLives.add(new Life(XPos, YPos));
			XPos+=pixelSize;
		}
		return playerLives;
	}
	public static void loseLife(Player player) {
		if (livesCount > minLives) {
			player.getLives().remove(livesCount-1);
			livesCount--;
			player.resetPlayer();
			System.out.println(livesCount);
		}
	}
}
