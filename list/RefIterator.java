package list;

/** 
 * A RefIterator is an Iterator which allows iteration 
 * through a LinkedList.
 * @author (sdb)
 * @author (Sarah Pham)
 * @version	(September 18, 2021)
 */
public class RefIterator<E> implements Iterator<E> 
{

	LinkedList<E> list;
	// Reference to the Node storing the last value 
	// obtained by a call to next()
	Node<E> cursor;
	
	boolean callNext = false;

	// Constructor
	/**
	 * Creates a RefIterator of the LinkedList.
	 * @param list	The LinkedList that the RefIterator should iterate over.
	 */
	public RefIterator(LinkedList<E> list)
	{ 
		this.list = list;
		cursor = list.head;
	}

	/**
	 * Returns true iff there is another element in the List yet to be iterated over.
	 * @return	Whether the List has another element or not.
	 */
	public boolean hasNext()
	{ 
		return cursor.next != list.tail; 
	}
	
	/**
	 * Returns the next value in the List, only if hasNext() is true.
	 * @return	The next value in the List.
	 */
	public E next()
	{ 
		cursor = cursor.next;
		if(!callNext)
			callNext = true;
		return cursor.value;
	}
	
	/**
	 * Removes the last node obtained with next() from the LinkedList (next() has to be called
	 * at least once to successfully remove).
	 */
	public void remove()
	{ 
		cursor.prev.next = cursor.next;
		cursor.next.prev = cursor.prev;
		list.size--;
		callNext = false;
	}
	
	/** @return true iff there are at least two or more values
	 * to be obtained
	 */
	public boolean has2More() {
		return cursor.next != list.tail && cursor != list.tail.prev;
		//return cursor.next != list.tail && cursor.next != list.tail.prev;

	}
	
	public void remove2() {
		if(has2More() && callNext) {	// add second pre here
			cursor.prev.next = cursor.next.next;
			cursor.next.next.prev = cursor.prev;
			list.size = list.size - 2;
			callNext = false;
		}
	}

}
