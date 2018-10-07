import java.util.Comparator;
/**
 * Used to sort the Sprites according to Priority
 */
public class PriorityComparator implements Comparator<Sprite>{
	/** Compares the priority of sprites.
	 * @param s1 The first sprite
	 * @param s2 The second sprite.
	 * */
	public int compare(Sprite s1, Sprite s2) {
		if (s1.priority<s2.priority) {
			return 1;
		}
		else if (s1.priority> s2.priority) {
			return -1;
		}
		return 0;
	}

}
