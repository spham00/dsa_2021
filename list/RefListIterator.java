package list;

/** A ListIterator specifically for LinkedLists
 * @author (sdb)
 * @author (PUT YOUR NAME HERE)
 */
class RefListIterator<E> extends RefIterator<E> implements ListIterator<E>
{
	/** cursor, in the superclass, is a reference
	to the last value returned by a call to 
	next() or previous().
	 */
	// forward => iterating left to right using next()
	// !forward => iterating right to left using previous()
	private boolean forward = true;

	/**
	 * Creates an RefListIterator of the given LinkedList.
	 * @param list	The LinkedList that the RefListIterator is created for.
	 */
	RefListIterator (LinkedList<E> list)
	{ 
		super(list);
	}

	/**
	 * Creates an RefListIterator of the given LinkedList at the given index.
	 * @param list	The LinkedList that the RefListIterator is created for.
	 * @param start	The index that the Iterator should start with.
	 */
	RefListIterator (LinkedList<E> list, int start)
	{ 
		super(list); 
		for (int i=0; i<start; i++)
			cursor = cursor.next;
	}

	/**
	 * Returns whether there is a next node in the LinkedList.
	 * @return	True iff there is a next node in the LinkedList.
	 */
	public boolean hasNext()
	{ 
		if (list.isEmpty())
			return false;
		if (forward)
			return cursor.next != list.tail;
		return true;
	}

	/**
	 * Returns the next node's value in the LinkedList.
	 * @return	The next node's value in the LinkedList.
	 */
	public E next()
	{ 
		if (forward)
			cursor = cursor.next;
		forward = true;
		return cursor.value;
	}

	/**
	 * Returns whether there is a previous node.
	 * @return	True iff there is a previous node.
	 */
	public boolean hasPrevious()
	{ 
		if (!forward)
			return cursor.prev != list.head;
		return cursor != list.head; // initial call to hasPrevious() ?
	}

	/**
	 * Returns the previous node's value in the LinkedList.
	 * @return	The previous node's value in the LinkedList.
	 */
	public E previous()
	{ 
		if (!forward)
			cursor = cursor.prev;
		forward = false;
		return cursor.value;
	}

	/**
	 * Removes the last returned value by either next() or previous().
	 */
	public void remove()
	{ 
		super.remove();
		if (forward)
			cursor = cursor.prev;
		else
			cursor = cursor.next;
	}

	/** Insert the given value just prior to the implicit cursor position.  A subsequent call to previous()
    should return the inserted value, and a subsequent call to next() should be unaffected.
	 */
	public void add(E value) {
		Node<E> e;
		
		// If forward, cursor.value would be referring to the previously called next(), which means the
		// one before where the new element should be added.
		
		// Edit was made since using indexOf should be avoided when possible; there could be duplicate
		// items which means errors.
		if(forward) {
			e = new Node<E>(value, cursor.next, cursor);
			cursor.next = e;
			cursor.next.next.prev = e;
			cursor = cursor.next;
		}
		
		// If not forward, cursor value will be referring to the .previous, which in this case is the
		// index where we want to add the new element.
		else {
			e = new Node<E>(value, cursor, cursor.prev);
			cursor.prev = e;
			cursor.prev.prev.next = e;
		}
		list.size++;
	}
}
