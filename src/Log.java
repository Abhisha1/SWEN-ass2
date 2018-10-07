import java.util.ArrayList;
/** A sub class from Rideable which handles both small and long logs.
 *  These objects can be ridden on by the player and one log can contain
 *  the extra life object.
 *  Initialisation and movement of logs handled here.
 * */
public class Log extends Rideable{
	
	private static float longLogRate = 0.07f;
	private static float logRate = 0.1f;
	
			
	private static String logStringAddress = "assets/log.png";
	private static String longLogStringAddress = "assets/longlog.png";
	private static String name = "log";
	/** Creates a long log object
     * @param x The x coordinate of object.
     * @param y The y coordinate of object.
     * @param moveRight Whether the long log moves left or right
     * @return a Long log
     */
	public static Log createLongLog(float x, float y, boolean moveRight) {
		return new Log(longLogStringAddress, x, y, longLogRate, moveRight);
	}
	/** Creates a log object
     * @param x The x coordinate of object.
     * @param y The y coordinate of object.
     * @param moveRight Whether the log moves left or right
     * @return a log
     */
	public static Log createLog(float x, float y, boolean moveRight) {
		return new Log(logStringAddress, x, y, logRate, moveRight);
	}
		
	private Log(String imageSrc, float x, float y, float rate, boolean moveRight) {	
		// Creates an object of class Log
		super(rate, x, y, imageSrc, moveRight);
		super.setName(name);
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
