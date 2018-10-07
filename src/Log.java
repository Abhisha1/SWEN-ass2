import java.util.ArrayList;
public class Log extends Rideable{
	private static boolean isSolid = false;
	
	private static float longLogRate = 0.07f;
	private static float logRate = 0.1f;
	
			
	private static String logStringAddress = "assets/log.png";
	private static String longLogStringAddress = "assets/longlog.png";
	
	public static Log createLongLog(float x, float y, boolean moveRight) {
		return new Log(longLogStringAddress, x, y, longLogRate, moveRight);
	}
	public static Log createLog(float x, float y, boolean moveRight) {
		return new Log(logStringAddress, x, y, logRate, moveRight);
	}
		
	private Log(String imageSrc, float x, float y, float rate, boolean moveRight) {	
		super(rate, x, y, imageSrc, moveRight);
		super.setName("log");
	}
	
	public static int getNumberOfLogs(ArrayList<Sprite> sprites) {
		int counter = 0;
		for (Sprite a: sprites) {
			if (a.getName().equals("log")) {
				counter++;
			}
		}
		return counter;
	}
}
