package setDriver;

import set.*;
import map.*;

public class Quiz6 {

	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(2);
		set2.add(4);
		set2.add(5);
		set2.add(3);
		set1.intersection(set2);
		System.out.println(set1.intersection(set2));
		
		System.out.println();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 2);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 2);
		System.out.println(map.getKeys(2));
	}
}
