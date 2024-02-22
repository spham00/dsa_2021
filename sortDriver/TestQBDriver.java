package sortDriver;

import list.*;
import sort.*;

/**
 * Made by me.
 * @author Sarah
 *
 */
public class TestQBDriver {
	
	private static List<Integer> numbers = new ArrayList<Integer>();
	private static Sorter<Integer> sorter = new QuickSort<Integer>();
	private static BinarySearch<Integer> searcher;
	
	public static void main(String[] args) {
		//init3();
		//sortAndPrint();
		
		/**
		initb1();
		int target = 200;
		searcher = new BinarySearch<Integer>(numbers);
		int thing = searcher.search(target);
		System.out.println(thing);
		*/
		
		number2();
		sortAndPrint();
	}
	
	private static void number2() {
		numbers.clear();
		
		// attempt to initialize (debug, worse case occurs if the input list
		// is such that the maximum/minimum element is always chosen as the pivot
		/**
		numbers.add(7);
		numbers.add(4);
		numbers.add(2);
		numbers.add(5);
		numbers.add(8);
		numbers.add(10);
		*/
		
		// here the minimum element is always chosen
		numbers.add(4);
		numbers.add(2);
		numbers.add(0);
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
	}
	
	private static void sortAndPrint() {
		System.out.println("Before: " + numbers);
		sorter.sort(numbers);
		System.out.println("After: " + numbers);
	}

	private static void init1() {
		numbers.add(38);
		numbers.add(40);
		numbers.add(38);
		numbers.add(16);
		numbers.add(29);
		numbers.add(24);
		numbers.add(6);
		numbers.add(18);
		numbers.add(47);
		numbers.add(11);
		numbers.add(30);
		numbers.add(10);
		numbers.add(49);
		numbers.add(20);
		numbers.add(6);
		numbers.add(29);
		numbers.add(27);
		numbers.add(44);
		numbers.add(35);
		numbers.add(21);
	}
	
	private static void init2() {
		numbers.add(19);
		numbers.add(22);
		numbers.add(63);
		numbers.add(105);
		numbers.add(2);
		numbers.add(46);
	}
	
	private static void init3() {
		numbers.add(3);
		numbers.add(2);
		numbers.add(6);
	}
	
	private static void initb1() {
		numbers.clear();
		
		numbers.add(-3);
		numbers.add(-3);
		numbers.add(0);
		numbers.add(5);
		numbers.add(12);
		numbers.add(23);
		numbers.add(36);
		numbers.add(99);
	}
	
}
