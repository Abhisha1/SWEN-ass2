import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/** Handles the CSV file and parses the instructions so as to
 *  load the sprites for each level.
 * */
public class Instruction {
	private ArrayList<String[]> instructions;
	
	/**Creates an object of class Instruction
     * @param fileAddress The file path for the csv instructions for a level.
     */
	public Instruction(String fileAddress) {
		instructions = new ArrayList<String[]>();
		readCSV(fileAddress);
	}
	
	private void readCSV(String fileAddress) {
		// Reads in a CSV file and stores in an array
		try (BufferedReader br =
	            new BufferedReader(new FileReader(fileAddress))) {
				String text;
				
				
	            while ((text = br.readLine()) != null) {
	            	String[] textArr = text.split(",");
	            	this.instructions.add(textArr);
	                
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	/** Returns a list of instructions
     * @return An array of instructions.
     */
	public ArrayList<String[]> getInstructions(){
		return this.instructions;
	}
	/** Reads the a line of instructions for a tile and builds the tile
     * @param objectInstructions An array of instructions in the format (name, x coordinate, y coordinate)
     * @return Tile
     */
	public static Tile instructionParsedTile(String[] objectInstructions) {
		float xPos = Float.parseFloat(objectInstructions[1]);
		float yPos = Float.parseFloat(objectInstructions[2]);
		if (objectInstructions[0].equals("water")) {
			return Tile.createWaterTile(xPos, yPos);
		}
		if (objectInstructions[0].equals("grass")) {
			return Tile.createGrassTile(xPos, yPos);
		}
		else {
			FinalLocation.setYPos(yPos);
			return Tile.createTreeTile(xPos, yPos);
		}
	}
	/** Reads the a line of instructions for moving objects and builds the respective movable
     * @param objectInstructions An array of instructions in the format (name, x coordinate, y coordinate, moveRight)
     * @return Movable
     */
	public static Movable instructionParsedMovable(String[] objectInstructions) {
		float xPos = Float.parseFloat(objectInstructions[1]);
		float yPos = Float.parseFloat(objectInstructions[2]);
		boolean moveRight = Boolean.parseBoolean(objectInstructions[3]);
		Movable movingObject;
		if (objectInstructions[0].equals("bus")) {
			movingObject = new Bus(xPos, yPos, moveRight);
		}
		else if (objectInstructions[0].equals("bike")) {
			movingObject = new Bike(xPos, yPos, moveRight);
		}
		else if (objectInstructions[0].equals("racecar")) {
			movingObject =  new Racecar(xPos, yPos, moveRight);
		}
		else if (objectInstructions[0].equals("log")) {
			movingObject =  Log.createLog(xPos, yPos, moveRight);
		}
		else if (objectInstructions[0].equals("longLog")) {
			movingObject = Log.createLongLog(xPos, yPos, moveRight);
		}
		else if (objectInstructions[0].equals("bulldozer")) {
			movingObject = new Bulldozer(xPos, yPos, moveRight);
		}
		else if (objectInstructions[0].equals("turtle")) {
			movingObject = new Turtle(xPos, yPos, moveRight);
		}
		else {
			movingObject = new Racecar(xPos, yPos, moveRight);
		}
		return movingObject;
	}
	
}
