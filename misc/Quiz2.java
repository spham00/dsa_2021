package misc;

import list.*;
import queue.*;

public class Quiz2 {

	public static void main(String[] args) {
		question1();
		question4();
	}
	
	private static void question1() {
		List<String> e = new ArrayList<String>();
		System.out.println("ArrayIterator");
		test1(e);
		e = new LinkedList<String>();
		System.out.println("RefIterator");
		test1(e);
	}
	
	private static void test1(List<String> e) {
		e.add("a");
		e.add("e");
		e.add("i");
		
		Iterator<String> it = e.iterator();
		// Should print true
		System.out.println(it.has2More());
		
		// Should print false
		it.next();
		it.next();
		System.out.println(it.has2More());
	}
	
	private static void question4() {
		QueueADT<String> myQ = new Queue<String>();
		myQ.add("jim");
		myQ.add("susie");
		myQ.add("jimmy");
		myQ.peek();
		System.out.println("\n" + myQ.remove());
		myQ.add("jim");
		System.out.println(myQ.remove());
	}

}
