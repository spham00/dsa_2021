package set;

import tree.TreeIterator;

/** 
 * Iterate over a TreeSet
 * The remove() method needs to update the size of the Set.
 */
class TreeSetIterator<E extends Comparable> extends TreeIterator<E>
{ 
	private TreeSet<E> set;

	TreeSetIterator (TreeSet<E> set) { 
		super (set.tree);
		this.set = set;
	}

	public void remove () { 
		set.tree = set.tree.remove (getLastGotten());
		set.size--;
	}
}