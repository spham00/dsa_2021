package listDriver;

import list.*;

public class FinalQuestion2 {
	
	public static void main(String[] args) {
		
		System.out.println("ArrayList");
		List<Integer> list = new ArrayList<Integer>(5);
		list.add(2);
		list.add(5);
		list.add(3);
		Iterator<Integer> itty = new ArrayIterator<Integer>(list);
		System.out.println(list);
		System.out.println(itty.next());
		//System.out.println(itty.next());
		//itty.remove();
		//itty.remove();
		itty.remove2();
		System.out.println(list);
		
		System.out.println("\nLinkedList");
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(2);
		list2.add(5);
		list2.add(3);
		itty = new RefIterator<Integer>(list2);
		System.out.println(list2);
		System.out.println(itty.next());
		//System.out.println(itty.next());
		itty.remove2();
		System.out.println(list2);
		
		
		/**
		ArrayList<Integer> listA = new ArrayList<Integer>(5);
		listA.add(6);
		listA.add(7);
		listA.add(9);
		ArrayList<Integer> listB = new ArrayList<Integer>(5);
		listB.add(9);
		listB.add(7);
		listB.add(6);
		System.out.println(listA.equals(listB));
		System.out.println(listA.hashCode());
		System.out.println(listB.hashCode());
		
		ArrayList<Integer> listC = new ArrayList<Integer>(5);
		listC.add(6);
		listC.add(7);
		listC.add(9);
		System.out.println(listA.equals(listC));
		System.out.println(listC.hashCode());
		*/
	}

}
