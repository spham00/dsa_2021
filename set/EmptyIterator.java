package set;

import list.Iterator;

/**
 * An EmptyIterator for an empty collection (set for now).
 * @author Sarah Pham
 */
class EmptyIterator<E> implements Iterator<E> {

	EmptyIterator() {
		// Empty constructor
	}
	
	public void remove() {
		// Unable to remove anything from something that's empty
		// Nothing done here
	}

	public boolean hasNext() {
		// Has no next element since there are no elements
		return false;
	}

	public E next() {
		// There is no next value to return
		return null;
	}

	@Override
	public boolean has2More() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove2() {
		// TODO Auto-generated method stub
		
	}
	
	
}
