package treeDriver;

import tree.*;

public class FinalQuestion5 {
	
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new EmptyBinarySearchTree<Integer>();
		tree = tree.add(5);
		tree = tree.add(6);
		tree = tree.add(4);
		tree = tree.add(3);
		tree = tree.add(2);
		tree = tree.add(1);
		System.out.println(tree.height());
		
		System.out.println("\nBalanced?");
		System.out.println(tree.isBalanced());
		tree = tree.add(0);
		tree = tree.add(-1);
		System.out.println(tree.isBalanced());
	}

}
