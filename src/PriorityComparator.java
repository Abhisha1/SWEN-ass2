import java.util.Comparator;

public class PriorityComparator implements Comparator<Sprite>{
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
