package set;

import tree.*;
import list.Iterator;

/** 
 * An implementation of Set, using a BinaryTree
 * @author (sdb)
 * @author (Sarah Pham) 
 */
public class TreeSet<E extends Comparable> implements Set<E>
{ 
	BinaryTree<E> tree = new EmptyBinarySearchTree();
	int size = 0;

	public boolean add (E value) { 
		if (tree.containsKey(value))
			return false; // no duplicates
		tree = tree.add(value);
		size++;
		return true;
	}

	public boolean contains (Object obj) { 
		return tree.containsKey (obj);
	}

	public boolean remove (Object obj) { 
		if (! contains (obj))
			return false;
		tree = tree.remove (obj);
		size--;
		return true;
	}
	
	public Iterator<E> iterator() {
		if (size == 0)
			return new EmptyIterator();
		return new TreeSetIterator(this);
	}

	public void clear() {
		// Destroy reference to old BinarySearchTree
		tree = new EmptyBinarySearchTree();
	}

	public boolean isEmpty() {
		return tree.isEmpty();
	}

	public int size() {
		return size;
	}
	
	public boolean equals(Object obj) {
		// If obj is not a Set, return false
		if (!(obj instanceof Set))
			return false;
		
		// Can cast to Set now
		Set<E> o = (Set)obj;
		
		// If the size is not equal, return false because they should be the same size
		// if duplicates not allowed to be added
		if (this.size() != o.size())
			return false;
		
		// Make an Iterator to check over this HashSet's elements
		Iterator<E> this_itty = this.iterator();
		
		while (this_itty.hasNext()) {
			E a = this_itty.next();
			
			// If other Set doesn't contain an element, they're not equal
			if (!o.contains(a))
				return false;
		}
		
		// If break free of while loop, this means all items were found
		return true;
	}

	@Override
	public String toString() {
		// If no elements, nothing to print
		if (size == 0) {
			return "No elements in this TreeSet";
		}
		
		String s = "{";
		Iterator <E> itty = this.iterator();
		
		while (itty.hasNext()) {
			s = s + itty.next() + ", ";
		}
		
		return s.substring(0, s.length() - 2) + "}";
	}
}