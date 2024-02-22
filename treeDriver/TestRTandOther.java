package treeDriver;

import tree.*;

public class TestRTandOther {

	public static void main(String[] args) {

		//seeingRemove();
		//diagram();
		//quiz4();
		quiz5();
		
	}
	
	private static void quiz5() {
		Quotient q = new Quotient(new Variable('a'), new Variable('b'));
		Quotient a = new Quotient(new Variable('b'), new Variable('c'));
		Product p = new Product(q, a);
		System.out.println(p.simplify());
		
		Variable v = new Variable('b');
		Product e = new Product(q, v);
		System.out.println(e.simplify());
	}
	
	private static void quiz4() {
		BinaryTree<String> tree = new EmptyBinarySearchTree<String>();
		tree = tree.add("mary");
		tree = tree.add("susie");
		tree = tree.add("john");
		tree = tree.add("al");
		tree = tree.add("norm");
		tree = tree.add("rob");
		
		System.out.println("done");
	}

	private static void seeingRemove() {
		// For the RUNTIME
		BinaryTree<String> e = new EmptyBinarySearchTree<String>();

		// initialize the tree
		e = e.add("mouse");
		e = e.add("cat");
		e = e.add("snake");
		e = e.add("bat");
		e = e.add("cow");
		e = e.add("rat");
		e = e.add("worm");

		//remove
		e.remove("worm");
		
		System.out.println("Done");
	}
	
	private static void diagram() {
		BinaryTree<String> tree = new BinarySearchTree("monkey");
		tree = tree.add ("snake");
		tree = tree.add ("wombat");
		tree = tree.add ("bat");
		tree = tree.add ("cat");
		tree = tree.add ("shark");
		tree = tree.add ("rat");
		tree = tree.add ("sheep");
		tree = tree.remove("monkey");
		
		System.out.println("done");
	}
}
