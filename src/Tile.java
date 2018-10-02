public class Tile extends Sprite {
		public static final int TILE_SIZE = 48;
		private static final String GRASS_PATH = "assets/grass.png";
		private static final String WATER_PATH = "assets/water.png";
		private static final String TREE_PATH = "assets/tree.png";
		
		public static final boolean WATER_DANGER = true;
		public static final boolean WATER_SOLID = false;
		
		public static final boolean TREE_DANGER = false;
		public static final boolean TREE_SOLID = true;
		
		public static Tile createGrassTile(float x, float y) {
			return new Tile(GRASS_PATH, x, y);
			
		}
		public static Tile createWaterTile(float x, float y) {
			return new Tile(WATER_PATH, x, y, WATER_DANGER, WATER_SOLID);
		}
		public static Tile createTreeTile(float x, float y) {
			return new Tile(TREE_PATH, x, y, TREE_DANGER, TREE_SOLID);
		}
		
		
		private Tile(String imageSrc, float x, float y) {		
			super(imageSrc, x, y);
		}
		private Tile(String imageSrc, float x, float y, boolean isDanger, boolean isSolid) {		
			super(imageSrc, x, y);
			this.setSolid(isSolid);
			this.setDanger(isDanger);
		}
		public static boolean isTile(String spriteName) {
			if (spriteName.equals("water") || spriteName.equals("tree") || spriteName.equals("grass")) {
				return true;
			}
			return false;
		}
		
	}