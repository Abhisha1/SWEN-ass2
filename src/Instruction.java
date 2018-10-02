import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Instruction {
	private ArrayList<String[]> instructions;
	
	public Instruction(String fileAddress) {
		instructions = new ArrayList<String[]>();
		readCSV(fileAddress);
	}
	
	private void readCSV(String fileAddress) {
		
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
	public ArrayList<String[]> getInstructions(){
		return this.instructions;
	}
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
			return Tile.createTreeTile(xPos, yPos);
		}
	}
	
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
		else {
			movingObject = new Racecar(xPos, yPos, moveRight);
		}
		return movingObject;
	}
	
}
