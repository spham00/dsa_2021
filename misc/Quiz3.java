package misc;

import list.*;
import sort.*;

/**
 * Another test project for quiz 3.
 * @author Sarah
 *
 */
public class Quiz3 {
	
	private static int first = 18;
	private static int second = 6;
	
	private static List<Integer> descending = new ArrayList<Integer>();

	public static void main(String[] args) {
		System.out.println(first % second);
		int answer = mod(first, second);
		System.out.println(answer);
		
		init();
		BubbleSort<Integer> sorter = new BubbleSort<Integer>();
		System.out.println(descending);
		sorter.sort(descending);
		System.out.println(descending);
		
	}
	
	private static int mod(int x, int y) {
		if(x < 0 || y <= 0) {
			// Return -1 if preconditions not met
			return -1;
		}
		if(x < y) {
			// x would be the remainder since it cannot be subtracted from y anymore
			// without being a positive number.
			return x;
		}
		return mod((x - y), y);
	}
	
	private static void init() {
		descending.add(5);
		descending.add(10);
		descending.add(14);
		descending.add(4);
	}

}
