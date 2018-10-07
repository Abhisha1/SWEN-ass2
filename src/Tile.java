// Adapted from Eleanor McMurty's Solution to Project 1
/** A subclass from Sprite which handles the initialisation of Tiles.
 * */
public class Tile extends Sprite {
		/** The size of each tile, as per the game spec.*/
		public static final int TILE_SIZE = 48;
		
		// file path to Tile images
		private static final String GRASS_PATH = "assets/grass.png";
		private static final String WATER_PATH = "assets/water.png";
		private static final String TREE_PATH = "assets/tree.png";
		
		/** If collision with water tile results in death of player (danger)*/
		public static final boolean WATER_DANGER = true;
		/**If player can move onto water tile (solid)*/
		public static final boolean WATER_SOLID = false;
		/** If collision with tree tile results in death of player (danger)*/
		public static final boolean TREE_DANGER = false;
		/**If player can move onto tree tile (solid)*/
		public static final boolean TREE_SOLID = true;
		
		/**Creates a Grass Tile
	     * @param x The x location of the sprite.
	     * @param y The y location of the sprite.
	     */
		public static Tile createGrassTile(float x, float y) {
			return new Tile(GRASS_PATH, x, y);
			
		}
		/**Creates a Water Tile
	     * @param x The x location of the sprite.
	     * @param y The y location of the sprite.
	     */
		public static Tile createWaterTile(float x, float y) {
			return new Tile(WATER_PATH, x, y, WATER_DANGER, WATER_SOLID);
		}
		/**Creates a Tree Tile
	     * @param x The x location of the sprite.
	     * @param y The y location of the sprite.
	     */
		public static Tile createTreeTile(float x, float y) {
			return new Tile(TREE_PATH, x, y, TREE_DANGER, TREE_SOLID);
		}
		
		
		private Tile(String imageSrc, float x, float y) {
			// Tile is created
			super(imageSrc, x, y);
			super.priority = Sprite.LOW_PRIORITY;
			super.setName("tile");
		}
		private Tile(String imageSrc, float x, float y, boolean isDanger, boolean isSolid) {
			// Tile is created for tiles with customer Danger and Solid settings.
			super(imageSrc, x, y);
			this.setSolid(isSolid);
			this.setDanger(isDanger);
			super.setName("tile");
		}
		/** Checks if the sprite is a tile
	     * @param spriteName A drawable object in game.
	     * @return boolean whether sprite is a tile or not.
	     */
		public static boolean isTile(String spriteName) {
			if (spriteName.equals("water") || spriteName.equals("tree") || spriteName.equals("grass")) {
				return true;
			}
			return false;
		}
		
	}