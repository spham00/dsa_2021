package hashDriver;

import hash.*;

public class MyLabHBDriver {

	public static void main(String[] args) {
		/**
		Book book = new Book ("Java", "Barnes", 300, new Date(12,20,1985));
		System.out.println(book.hashCode());
		
		Date date = new Date(12, 20, 1985);
		Book book1 = new Book ("Java", "Barnes", 0, date);
		System.out.println(book1.hashCode());
		
		HashTable library = new HashTable();
		library.put(book);
		
		boolean e = library.containsKey(book1);
		System.out.println(e);
		*/
		
		//problem2lab();
		//compOrg();
		quiz5();
	}
	
	public static void problem2lab() {
		HashTable<String> table = new HashTable<String> (5);
		table.put ("dog");
		table.put ("mouse");
		table.put ("cat");
		table.put ("dog");
		table.put ("spider");
		
		System.out.println("dog".hashCode());
		System.out.println("mouse".hashCode());
		System.out.println("cat".hashCode());
		System.out.println("dog".hashCode());
		System.out.println("spider".hashCode());
		
		System.out.println("hello");
	}
	
	public static void compOrg() {
		for (double x = 0.0; x != 1.0; x = x + 0.1)
			System.out.println("x is " + x);
	}
	
	public static void quiz5() {
		HashTable<Integer> table = new HashTable<Integer>(5);
		table.put(3);
		System.out.println(Integer.hashCode(3));
		table.put(-3);
		System.out.println(Integer.hashCode(-3));
		table.put(20);
		System.out.println(Integer.hashCode(20));
		table.put(8);
		System.out.println(Integer.hashCode(8));
		table.put(0);
		System.out.println(Integer.hashCode(0));
		table.put(30);
		System.out.println(Integer.hashCode(30));
		System.out.println("done");
	}
	
}
