package list;

/** An ArrayIterator is an Iterator which allows 
 * iteration through an ArrayList.
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (September 18, 2021)
 */
public class ArrayIterator<E> implements Iterator<E> 
{

	List<E> list;
	// Position of the last value obtained by a call to next();
	int ndx = -1;
	
	// Boolean to make sure that next has been called at least once since
	// last call to remove or remove2
	boolean callNext = false;		// no remove yet, so initially set true

	// Constructor
	/**
	 * Creates an ArrayIterator for the given List.
	 * @param list	The List that the ArrayIterator should iterate over.
	 */
	public ArrayIterator(List<E> list) 
	{ 
		this.list = list; 
	}

	/**
	 * Returns true iff there is another element in the List yet to be iterated over.
	 * @return	Whether the List has another element or not.
	 */
	public boolean hasNext()
	{ 
		return ndx < list.size() - 1; 
	}

	/**
	 * Returns the next value in the List, only if hasNext() is true.
	 * @return	The next value in the List.
	 */
	public E next()
	{ 
		ndx++;
		if(!callNext)
			callNext = true;	// if there was no call next, now that it's been called, set true
		return list.get(ndx);
	}

	/**
	 * Removes the last value obtained with next() from the List (next() has to be called
	 * at least once to successfully remove).
	 */
	public void remove()
	{ 
		list.remove(ndx);
		ndx--;
		callNext = false;	// next has not been called yet as of this remove
	}

	/** @return true iff there are at least two or more values
	 * to be obtained
	 */
	public boolean has2More() {
		return ndx <= list.size() - 2;
	}

	public void remove2() {
		if(has2More() && callNext) {
			list.remove(ndx);
			list.remove(ndx);
			ndx--;
			callNext = false;	// next has not been called yet as of this remove
		}
	}

}
