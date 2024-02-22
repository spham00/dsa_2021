package list;

/** A ListIterator specifically for ArrayLists
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (September 18, 2021)
 */
class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E> {

	// forward => iterating left to right using next()
	// !forward => iterating right to left using previous()
	private boolean forward = true;

	/**
	 * Creates an ArrayListIterator of the given List.
	 * @param list	The List that the ArrayListIterator is created for.
	 */
	ArrayListIterator (List<E> list)
	{ 
		super (list); 
	}

	/**
	 * Creates an ArrayListIterator of the given List at the given index.
	 * @param list	The List that the ArrayListIterator is created for.
	 * @param start	The index that the Iterator should start with.
	 */
	ArrayListIterator (List<E> list, int start)
	{ 
		super(list);
		ndx = start - 1;
	}

	/**
	 * Returns whether there is a previous element.
	 * @return	True iff there is a previous element.
	 */
	public boolean hasPrevious()
	{ 
		return ndx >= 0; 
	}

	/**
	 * Returns the previous value in the ArrayList.
	 * @return	The previous value in the ArrayList.
	 */
	public E previous()
	{ 
		forward = false;
		ndx--;
		return list.get(ndx+1);
	}

	/**
	 * Removes the last returned value by either next() or previous().
	 */
	public void remove() 
	{
		if(forward) {
			list.remove(ndx);
			ndx--;
		}
		else {
			list.remove(ndx+1);
		}
	}

	/**
	 * Returns the next value in the ArrayList.
	 * @return	The next value in the ArrayList.
	 */
	public E next() 
	{
		forward = true;
		return super.next();
	}

	/**
	 * Returns whether there is a next element.
	 * @return	True iff there is a next element.
	 */
	public boolean hasNext()
	{
		return ndx < list.size() - 1;
	}

	/** Insert the given value just prior to the implicit cursor position.  A subsequent call to previous()
    should return the inserted value, and a subsequent call to next() should be unaffected.
	 */
	public void add(E value) {
		list.add(ndx + 1, value);
		ndx++;
	}
}
