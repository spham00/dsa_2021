package misc;

import hash.*;

public class FinalTesting {

	public static void main(String[] args) {
		question6();
	}
	
	private static void question6() {
		HashTable<Integer> table = new HashTable<Integer>(5);
		table.put (5);
		table.put(2);
		table.put(193939);
		table.put(4);
		System.out.println(table);
	}
	
}
