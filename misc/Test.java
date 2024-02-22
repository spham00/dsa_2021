package misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Just used to test out some things.
 * @author Sarah
 */

public class Test {
	
	public static void main(String[] args) {
		//for_loop();
		//arrayList();
		//testingDivision();
		//seeingLinkedList();
		//addLists();
		three_10_4(-2, 4);

	}
	
	/**
	 * Tests out the for loop VS an Iterator.
	 */
	private static void for_loop() {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(9);
		numbers.add(0);
		numbers.add(-3);
		numbers.add(-2);
		numbers.add(4);
		
		System.out.println("List before:" + "\n" + numbers);
		
		for (int i = 0; i < numbers.size(); i++) {
			if(numbers.get(i) < 0) {
				numbers.remove(i);
				System.out.println(numbers);
			}
		}
		
		System.out.println("List after:" + "\n" + numbers);
	}
	
	/**
	 * Testing to see how the actual ArrayList works compared to mine.
	 */
	private static void arrayList() {
		List<String> names = new ArrayList<String>();
		names.add("ash");
		names.add("joy");
		names.add("celeste");
		names.add("eric");
		names.add("peter");
		for(String name : names) {
			System.out.println(name);
		}
		System.out.println(names.toString());
		System.out.println("hello");
	}
	
	private static void testingDivision() {
		System.out.println(5/2);
	}
	
	private static List<String> seeingLinkedList() {
		List<String> names = new LinkedList<String>();
		names.add("ash");
		names.add("joy");
		names.add("celeste");
		names.add("eric");
		
		names.remove("eric");
		
		return names;
	}
	
	private static void addLists() {
		List<String> names = seeingLinkedList();
		List<String> namesAndPlaces = new ArrayList<String>();
		namesAndPlaces.add("Tokyo");
		namesAndPlaces.add("London");
		namesAndPlaces.add("Milan");
		namesAndPlaces.addAll(names);
	}
	
	private static void three_10_4(int x, int y) {
		int answer = x + y * 16;
		System.out.println(answer);
	}

}
