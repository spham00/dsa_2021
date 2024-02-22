package tree;

import queue.*;
import list.*;

/** 
 * An Iterator for a BinaryTree, using an InOrder traversal.
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (October 2021) 
 */
public class TreeIterator<E> implements Iterator<E>
{ 
	QueueADT<E> queue = new Queue<E>();
	BinaryTree<E> tree;
	private E lastGotten;		// Last value obtained by next()

	public TreeIterator(BinaryTree<E> tree)
	{ 
		this.tree = tree; 
		buildQ (tree);
	}

	/** 
	 * Build the queue of values using InOrder traversal 
	 */
	private void buildQ (BinaryTree<E> bst)
	{ 
		if (!bst.getLeft().isEmpty())
			buildQ (bst.getLeft());
		queue.add (bst.getValue());
		if (!bst.getRight().isEmpty())
			buildQ (bst.getRight());
	}
	/**
	 * @return Whether the tree has another element to iterate over
	 */
	public boolean hasNext()
	{ 
		return !queue.isEmpty(); 
	}

	/**
	 * @return Returns the next element of the queue.
	 */
	public E next()
	{ 
		lastGotten = queue.peek();
		return queue.remove();
	}

	/**
	 * Removes the last element called by next() from the Iterator.
	 */
	public void remove() {
		// Has 2 children or not removing the root?
		if(!tree.getLeft().isEmpty() && !tree.getRight().isEmpty()
				|| !tree.getValue().equals(lastGotten)) {
			tree = tree.remove(lastGotten);
			return;		// terminate
		}

		// If removing root/has fewer than 2 children
		E repl;		// replacement value
		if(tree.getLeft().isEmpty())
			repl = getSuccessorValue();
		else
			repl = getPredecessorValue();
		tree.remove(repl);
		tree.setValue(repl);
	}

	/** 
	 * @return successor of this BinarySearchTree.
	 * Smallest value in family of right child
	 */
	private E getSuccessorValue()
	{ 
		BinaryTree<E> result = tree.getRight();
		while (!result.getLeft().isEmpty())
			result = result.getLeft();
		return result.getValue();
	}

	/** 
	 * @return predecessor of this BinarySearchTree.
	 * Largest value in family of left child
	 */
	private E getPredecessorValue()
	{ 
		BinaryTree<E> result = tree.getLeft();
		while (!result.getRight().isEmpty())
			result = result.getRight();
		return result.getValue();
	}

	@Override
	public boolean has2More() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public E getLastGotten() {
		return lastGotten;
	}

	@Override
	public void remove2() {
		// TODO Auto-generated method stub
		
	}

}